package model;

public class PostModel {

    // dla POSTobjectFromClass
    // domyślnie są to wartości = null
    private int userId;
    private String title;
    private String body;

    // getter i setter alt + insert


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
