package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public String toString() {
		String s;
		s = "DVD - " + title + " - " + category + " - " 
				+ director + " - " + length + ": " + cost + "$";
		return s;
	}
	public boolean isMatch(String t) {
		if (this.title == t) return true;
		return false;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.id = ++nbDigitalVideoDiscs;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
}
