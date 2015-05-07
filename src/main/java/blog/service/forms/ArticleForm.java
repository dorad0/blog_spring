package blog.service.forms;

import javax.validation.constraints.Size;

public class ArticleForm {


    @Size(min = 1, max = 1000)
    private String text;

    @Size(min = 1, max = 140)
    private String title;

    @Size(min = 1, max = 30)
    private String userName;

    public ArticleForm() {
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
