package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public String toString() {
		String s;
		s = "DVD - " + getTitle() + " - " + getCategory() + " - " 
				+ getDirector() + " - " + getLength() + ": " + getCost() + "$";
		return s;
	}
	public boolean isMatch(String t) {
		if (this.getTitle() == t) return true;
		return false;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	
}
