package com.edstem.ecld.assesment;

import java.util.Iterator;
import java.util.Scanner;

public class StreamingApp {

    private static final String ENTER_TRACK_NAME = "Enter the track name to be added: ";
    private static final String ENTER_TRACK_ID = "Enter the track ID for the above track: ";
    private static final String ENTER_PREMIUM_STATUS = "Enter the Premium status in boolean (true/false): ";

    public static void main(String[] args) {
        SmartPlaylist playlist = new SmartPlaylist();
        initializePlaylist(playlist);
        handleUserInput(playlist);
        displayCurrentQueue(playlist);
        updateRatings(playlist);
        shuffleAndDisplayQueue(playlist);
        removeTrackAndDisplayQueue(playlist, 1L);
    }

    public static void initializePlaylist(SmartPlaylist playlist) {        
        playlist.addTrack(new Track(1L, "Hello", false));
        playlist.addTrack(new Track(2L, "Mood", true));
        playlist.addTrack(new Track(3L, "Goodbyes", false));
    }
    
    public static void handleUserInput(SmartPlaylist playlist) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(ENTER_TRACK_NAME);
            String trackName = sc.nextLine();
            System.out.println(ENTER_TRACK_ID);
            long trackId = Long.parseLong(sc.nextLine());
            System.out.println(ENTER_PREMIUM_STATUS);
            boolean isPremium = Boolean.parseBoolean(sc.nextLine());
            Track newTrack = new Track(trackId, trackName, isPremium);
            playlist.addTrack(newTrack);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for Track ID. Please enter a valid number.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }         

    private static void displayCurrentQueue(SmartPlaylist playlist) {
        System.out.println("================");
        System.out.println("Current Queue: ");
        playlist.getCurrentQueue().forEach(track -> System.out.println(track.getTitle() + ", Rating: " + track.getRating()));
        System.out.println("================");
    }

    private static void updateRatings(SmartPlaylist playlist) {
        playlist.updateRating(1L, 4);
        playlist.updateRating(2L, 5);
        playlist.updateRating(3L, 3);
        System.out.println("Rating Updates:");
        displayCurrentQueue(playlist);
    }
    
    private static void shuffleAndDisplayQueue(SmartPlaylist playlist) {
        System.out.println("Queue Shuffle:");
        Iterator<Track> shuffledIterator = playlist.shuffleIterator();
        while(shuffledIterator.hasNext()) {
            Track track = shuffledIterator.next();
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("======================================");
    }
    
    private static void removeTrackAndDisplayQueue(SmartPlaylist playlist, Long trackId) {
        System.out.println("Removing Track no. " + trackId + " from the queue");
        playlist.removeTrack(trackId);
        System.out.println("=======================================");
        System.out.println("Current State of Queue after Updates:");
        displayCurrentQueue(playlist);
        System.out.println("=======================================");
    }
}
