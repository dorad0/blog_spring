package blog.service.forms;

import javax.validation.constraints.Size;

public class CommentForm {

    @Size(min = 1, max = 300)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}