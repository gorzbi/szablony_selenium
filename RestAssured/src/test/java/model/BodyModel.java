package model;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BodyModel {

    // domyślnie są to wartości = null
    private Integer id;
    private String title;
    private String author;

    // getter i setter alt + insert

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    // porównywanie obiektów alt + insert equals() hash code()
    // bez id bo id jest nadawane po utworzeniu elementu

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyModel bodyModel = (BodyModel) o;
        return Objects.equals(title, bodyModel.title) && Objects.equals(author, bodyModel.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }
}
