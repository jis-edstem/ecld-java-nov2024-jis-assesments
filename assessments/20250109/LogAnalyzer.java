package com.edstem.ecld.assesment;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

class LogEntry {
    private final String userId;
    private final LocalDateTime timestamp;
    private final String action;
    private final String status;
    private final long processingTimeMs;

    // Constructor and respective getters
    public LogEntry(String userId, LocalDateTime timestamp, String action, String status, long processingTimeMs) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.action = action;
        this.status = status;
        this.processingTimeMs = processingTimeMs;
    }

    public String getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }

    public String getAction() {
        return action;
    }
}

class UserActivityStats {
    private final double successRate;
    private final double avgProcessingTime;
    private final Set<String> distinctActions;

    // Constructor and their respective getters
    public UserActivityStats(double successRate, double avgProcessingTime, Set<String> distinctActions) {
        this.successRate = successRate;
        this.avgProcessingTime = avgProcessingTime;
        this.distinctActions = distinctActions;
    }

    // Getters
    public double getAvgProcessingTime() {
        return avgProcessingTime;
    }

    @Override
    public String toString() {

        return "User ActivityStats { " +
                "successRate=" + String.format("%.2f",successRate) +
                ", avgProcessingTime=" + String.format("%.2f",avgProcessingTime) +
                ", distinctActions=" + distinctActions +
                " }";
    }
}

public class LogAnalyzer {

    public static Map<String, UserActivityStats> analyzeUserActivity(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUserId)) // Group by userId
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 5) // Filter users with at least 5 log entries
                .map(entry -> {
                            List<LogEntry> userLogs = entry.getValue();
                            long totalEntries = userLogs.size();
                            long successCount = userLogs.stream()
                                    .filter(log -> "SUCCESS".equals(log.getStatus()))
                                    .count();
                            double successRate = (double) successCount / totalEntries * 100;

                             //if (successRate <= 90) {
                              //  return null; // Filters users who have a success rate below 90%, could be commented out for the actual full O/P
                             //}

                            double avgProcessingTime = userLogs.stream()
                                    .filter(log -> "SUCCESS".equals(log.getStatus()))
                                    .mapToLong(LogEntry::getProcessingTimeMs)
                                    .average()
                                    .orElse(0);

                            Set<String> distinctActions = userLogs.stream()
                                    .map(LogEntry::getAction)
                                    .collect(Collectors.toSet());

                            return new AbstractMap.SimpleEntry<>(entry.getKey(), new UserActivityStats(successRate, avgProcessingTime, distinctActions));
                })
                .filter(entry -> entry.getValue() != null) // Remove users with null stats (filtered out earlier)
                .sorted(Comparator.comparingDouble(entry -> entry.getValue().getAvgProcessingTime())) // Sort by avg processing time
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function
                        LinkedHashMap::new // Preserve sorting order
                ));
    }

    public static void main(String[] args) {

        //Input as in the given format
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("user1", LocalDateTime.now(), "LOGIN", "SUCCESS", 100),
                new LogEntry("user1", LocalDateTime.now(), "UPLOAD", "SUCCESS", 150),
                new LogEntry("user1", LocalDateTime.now(), "DOWNLOAD", "FAILURE", 200),
                new LogEntry("user1", LocalDateTime.now(), "LOGOUT", "SUCCESS", 120),
                new LogEntry("user1", LocalDateTime.now(), "VIEW", "SUCCESS", 80),
                new LogEntry("user1", LocalDateTime.now(), "EDIT", "SUCCESS", 90),
                new LogEntry("user2", LocalDateTime.now(), "LOGIN", "SUCCESS", 90),
                new LogEntry("user2", LocalDateTime.now(), "UPLOAD", "FAILURE", 200),
                new LogEntry("user2", LocalDateTime.now(), "DOWNLOAD", "SUCCESS", 150),
                new LogEntry("user2", LocalDateTime.now(), "LOGOUT", "SUCCESS", 110),
                new LogEntry("user2", LocalDateTime.now(), "VIEW", "SUCCESS", 95),
                new LogEntry("user2", LocalDateTime.now(), "EDIT", "SUCCESS", 85),
                new LogEntry("user3", LocalDateTime.now(), "LOGIN", "SUCCESS", 90),
                new LogEntry("user3", LocalDateTime.now(), "UPLOAD", "SUCCESS", 200),
                new LogEntry("user3", LocalDateTime.now(), "DOWNLOAD", "SUCCESS", 150),
                new LogEntry("user3", LocalDateTime.now(), "LOGOUT", "SUCCESS", 110),
                new LogEntry("user3", LocalDateTime.now(), "VIEW", "SUCCESS", 95),
                new LogEntry("user3", LocalDateTime.now(), "EDIT", "SUCCESS", 85)
        );

        Map<String, UserActivityStats> userActivityStats = analyzeUserActivity(logs);
        userActivityStats.forEach((userId, stats) -> {
            System.out.println("User ID: " + userId + ", Stats: " + stats); // Prints out the values in the order
        });
    }
}