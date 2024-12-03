package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track trackName) {
        if(tracks.contains(trackName)) {
            System.out.println(trackName.getTitle() + " is already in the CD");
        } else {
            tracks.add(trackName);
        }
    }
	
	public void removeTrack(Track trackName) {
        if(tracks.contains(trackName)) {
            tracks.remove(trackName);
        } else {
            System.out.println(trackName.getTitle() + "is not in the CD");
        }
    }
	
	public int getLength() {
        int sum = 0;
        for(Track song : tracks) {
            sum += song.getLength();
        }
        return sum;
    }
	
	public void play() {
        System.out.println("\nTitle: " + getTitle() + '\n' + "Artist: " + getArtist() + "\n\n");
        for(Track track : tracks) {
            track.play();
        }
    }

	public CompactDisc(String artist) {
		super();
		this.artist = artist;
	}
	public CompactDisc(ArrayList<Track> tracks) {
		super();
		this.tracks = tracks;
	}
	
	public CompactDisc(String title,String artist) {
		super(title);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title,category,cost);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String artist, float cost, ArrayList<Track> tracks) {
		super(title,category,cost);
		this.artist = artist;
		this.tracks = tracks;
	}

}
