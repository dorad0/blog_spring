package blog.dao;


import blog.model.Comment;

/**
 * Created by user on 19.12.2014.
 */
public interface CommentDAO {
    public void addComment(Comment comment);

    public void deleteComment(Comment comment);
}
