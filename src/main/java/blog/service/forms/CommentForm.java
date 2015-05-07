package blog.service.forms;

import javax.validation.constraints.Size;

public class CommentForm {

    @Size(min = 1, max = 300)
    private String text;

    private String userName;

    private Long articleId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
