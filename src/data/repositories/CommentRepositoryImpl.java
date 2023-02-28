package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository {
    private int count;
    private List<Comment> comments = new ArrayList<>();

    @Override
    public Comment save(Comment comment) {
        boolean commentHasNotBeenSaved = comment.getId()== 0;
        if(commentHasNotBeenSaved) {
            saveNew(comment);
        }
        return comment;
    }

    private void saveNew(Comment comment) {
        comment.setId(generateCommentId());
        comments.add(comment);
        count++;
    }

    private int generateCommentId(){
        return count+1;
    }


    @Override
    public Comment findById(int id) {
        for(Comment comment : comments){
            if (comment.getId()== id)
                return comment;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Comment> findAll() {
        return comments;
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void delete(int id) {
        for (Comment comment: comments) {
            if (comment.getId() == id){
                comments.remove(comment);
                count--;
                break;
            }
        }

    }

    @Override
    public void deleteAll() {

    }
}
