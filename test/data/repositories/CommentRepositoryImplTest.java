package data.repositories;

import data.models.Comment;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    private CommentRepository commentRepository;

    private Comment comment;

    @BeforeEach
    public void startWith(){
        commentRepository = new CommentRepositoryImpl();
        comment = new Comment();
        comment.setComment("Comment");
    }

    @Test
    public void postComment_countIsOneTest(){
        Comment comment = new Comment();
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }

    @Test
    public void saveOneComment_idOfCommentIsOneTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
    }

    @Test
    public void saveOneComment_findCommentByIdTest(){
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        Comment foundUser = commentRepository.findById(1);
        assertEquals(foundUser, savedComment);
    }

    @Test
    public void saveOneComment_deleteOneComment_countIsZeroTest(){
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count());
    }

}