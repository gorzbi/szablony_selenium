package model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // nie musimy przesyłać w body pól, które są null

public class PutModel {

    // dla PUTobjectFromClass
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
