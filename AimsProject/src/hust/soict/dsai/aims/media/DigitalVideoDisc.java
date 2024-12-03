package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDiscs = 0;
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
	public DigitalVideoDisc(String title) {
		super(title);
		setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
		setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
		setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
		setId(++nbDigitalVideoDiscs);
	}
	
}
