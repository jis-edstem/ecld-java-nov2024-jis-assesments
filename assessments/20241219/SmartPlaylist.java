package com.edstem.ecld.assesment;

import java.util.*;

class Track {
    private final Long trackId;
    private final String title;
    private int rating;
    private final boolean isPremium;

    public Track(Long trackId, String title, boolean isPremium) {
        this.trackId = trackId;
        this.title = title;
        this.isPremium = isPremium;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackId=" + trackId +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", isPremium=" + isPremium +
                '}';
    }

    public Long getTrackId() {
        return trackId;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >= 1 && rating <=5) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
    }

}

interface PlaylistManager {
    void addTrack(Track track);
    void removeTrack(Long trackId);
    void moveTrack(int fromIndex, int toIndex);
    Iterator<Track> shuffleIterator();
    void updateRating(Long trackId, Integer newRating);
    List<Track> getCurrentQueue();
}

class TrackIterator implements Iterator<Track> {
    private final List<Track> tracks;
    private int currentIndex = 0;

    public TrackIterator(List<Track> tracks) {
        this.tracks = tracks;
    }

    public boolean hasNext() {
        return currentIndex < tracks.size();
    }

    public Track next() {
        if(!hasNext()) {
            throw new NoSuchElementException("No more tracks to iterate");
        }
        return tracks.get(currentIndex++);
    }
}

/**
 * SmartPlaylist class manages a collection of tracks, allowing for adding, removing, moving, shuffling, and updating ratings of tracks.
 */

class SmartPlaylist implements PlaylistManager {
    private final List<Track> currentQueue;
    private final List<Track> playedTracks;
    private final Random random;

    public SmartPlaylist() {
        this.currentQueue = new ArrayList<>();
        this.playedTracks = new ArrayList<>();
        this.random = new Random();
    }

    public void addTrack(Track track) {
        currentQueue.add(track);
    }

    public void removeTrack(Long trackId) {
        currentQueue.removeIf(track -> track.getTrackId().equals(trackId));
    }

    public void moveTrack(int fromIndex, int toIndex) {
        if(fromIndex < 0|| fromIndex >= currentQueue.size() || toIndex < 0 || toIndex >= currentQueue.size()) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        Track track = currentQueue.remove(fromIndex);
        currentQueue.add(toIndex, track);
    }

    public Iterator<Track> shuffleIterator() {
        List<Track> shuffledList = new ArrayList<>(currentQueue);
        Collections.shuffle(shuffledList, random);
        return new TrackIterator(shuffledList);
    }

    public void updateRating(Long trackId, Integer newRating) {
        currentQueue.stream()
                .filter(track -> track.getTrackId().equals(trackId))
                .findFirst()
                .ifPresent(track -> track.setRating(newRating));
    }

    public List<Track> getCurrentQueue() {
        return currentQueue;
    }

    public class TrackNotFoundException extends RuntimeException {
        public TrackNotFoundException(String message) {
            super(message);
        }
    }
}
