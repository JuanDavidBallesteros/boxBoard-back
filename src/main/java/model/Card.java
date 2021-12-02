package model;

public class Card {

    private String id;
    private String title;
    private String description;
    private String date;
    private String status;

    public Card() {
    }

    public Card(String id, String title, String description, String date, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
