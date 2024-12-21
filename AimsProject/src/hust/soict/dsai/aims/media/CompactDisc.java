package hust.soict.dsai.aims.media;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;

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
	
	@Override
	public void play() throws PlayerException {
		StringBuilder sb= new StringBuilder();

		if (getLength() <= 0) {
			throw new PlayerException("ERROR: CD length is non-positive!");
		} else {
			sb.append("Playing CD: " + this.getTitle() + (this.getArtist().equals("") ? "" : " by " + this.getArtist())
					+ "\n");
			sb.append("CD total length: " + this.getLength() + "\n");
			JOptionPane.showMessageDialog(null, sb.toString(), "Play CD", JOptionPane.INFORMATION_MESSAGE);
			for (Track t : tracks) {
				try {
					t.play();
				} catch (PlayerException e) {
					throw e;
				}
			}
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

	public ArrayList<Track> getTracks() {
		return tracks;
	}

}
