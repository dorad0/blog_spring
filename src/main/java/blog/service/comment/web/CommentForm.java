package blog.service.comment.web;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created by Alex on 20.02.2015.
 */
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
