package data.models;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private int articleId;
    private int userId;
    private String comment;
    private LocalDateTime timeCommented = LocalDateTime.now();

    public LocalDateTime getTimeCommented() {
        return timeCommented;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
