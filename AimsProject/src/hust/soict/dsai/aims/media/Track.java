package hust.soict.dsai.aims.media;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	
	@Override
	public void play() throws PlayerException {
		
		if (length<=0) {
			throw new PlayerException("ERROR: Track length is non-positive!");
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Playing track: " + this.getTitle() + "\n");
		sb.append("Track length: " + this.getLength() + "\n");
		JOptionPane.showMessageDialog(null, sb.toString(), "Play track", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track() {
	}
	public Track(String title) {
		this.title=title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Track track = (Track) obj;
	    return title.equals(track.title) && length == track.length;
	}
	
}
