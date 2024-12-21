package hust.soict.dsai.aims.media;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.exception.PlayerException;

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
	@Override
	public void play() throws PlayerException {

		if (getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("Playing DVD: " + this.getTitle() + "\n");
			sb.append("DVD length: " + this.getLength() + "\n");
			JOptionPane.showMessageDialog(null, sb.toString(), "Play DVD", JOptionPane.INFORMATION_MESSAGE);
		}

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
