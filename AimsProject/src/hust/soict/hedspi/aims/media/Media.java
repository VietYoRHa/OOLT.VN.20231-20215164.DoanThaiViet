package hust.soict.hedspi.aims.media;


import java.util.Comparator;

public class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedias = 0;
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public Media(String title) {
        nbMedias++;
        this.id = nbMedias;
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

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

    public boolean isMatch (int id){
        return this.getId() == id;
    }

    public boolean isMatch (String title){
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(title);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Media otherMedia = (Media) obj;
        return title != null ? title.equals(otherMedia.title) : otherMedia.title == null;
    }
}
