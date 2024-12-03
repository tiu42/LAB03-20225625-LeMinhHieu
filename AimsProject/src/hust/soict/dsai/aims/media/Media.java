package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	private static int nboMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	 public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nboMedia;
    }
	public Media(String title) {
        this.title = title;
        this.id = ++nboMedia;
    }
	public Media() {
		this.id = ++nboMedia;
	}
	
	@Override
	public String toString() {
        return this.getClass().getSimpleName() +
                " [id= " + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost= " + cost + " $]";
    }
	
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Media media = (Media) obj;
	    return title.equals(media.title);
	}


}
