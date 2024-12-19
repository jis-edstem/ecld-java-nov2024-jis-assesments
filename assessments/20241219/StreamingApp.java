package com.edstem.ecld.assesment;

import java.util.Iterator;
import java.util.Scanner;

public class StreamingApp {
    public static void main(String[] args) {
        SmartPlaylist playlist = new SmartPlaylist();

        // Hard-coded Tracks
        Track track1 = new Track(1L, "Hello", false);
        Track track2 = new Track(2L, "Mood", true);
        Track track3 = new Track(3L, "Goodbyes", false);

        // User Input via Scanner
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the track name to be added: ");
        String trackName4 = sc.nextLine();
        System.out.print("Enter the track ID for the above track: ");
        Long trackId4 = Long.parseLong(sc.nextLine());
        System.out.print("Enter the Premium status in boolean (true/false): ");
        boolean isPremium4 = Boolean.parseBoolean(sc.nextLine());
        Track track4 = new Track(trackId4, trackName4, isPremium4);
        
        playlist.addTrack(track1);
        playlist.addTrack(track2);
        playlist.addTrack(track3);
        playlist.addTrack(track4);

        System.out.println("================");
        System.out.println("Current Queue: ");
        for(Track track : playlist.getCurrentQueue()) {
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("================");

        playlist.updateRating(1L, 4);
        playlist.updateRating(2L, 5);
        playlist.updateRating(3L, 3);

        System.out.println("Rating Updates:");
        for(Track track: playlist.getCurrentQueue()) {
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("================");

        System.out.println("Queue Shuffle:");
        Iterator<Track> shuffledIterator = playlist.shuffleIterator();
        while(shuffledIterator.hasNext()) {
            Track track = shuffledIterator.next();
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("======================================");

        System.out.println("Current State of Queue after Updates:");
        for (Track track: playlist.getCurrentQueue()) {
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("======================================");

        System.out.println("Removing Track no. 1 from the queue");
        playlist.removeTrack(1L);

        System.out.println("=======================================");
        System.out.println("Current State of Queue after Updates:");
        for (Track track: playlist.getCurrentQueue()) {
            System.out.println(track.getTitle() + ", Rating: " + track.getRating());
        }
        System.out.println("=======================================");
    }
}
