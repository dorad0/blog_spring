package blog.service.forms;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class ArticleForm {

    @NotEmpty
    @Size(min = 1, max = 1000)
    private String text;

    @NotEmpty
    private String title;

    public ArticleForm() {
    }

    public ArticleForm(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}