package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
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
