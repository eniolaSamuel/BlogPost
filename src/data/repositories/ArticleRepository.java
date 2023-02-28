package data.repositories;

import data.models.Article;
import data.models.Comment;

import java.util.List;

public interface ArticleRepository {
    Article save(Article article);

    Article findById(int id);
    long count();
    List<Article> findAll();
    void delete(Article article);
    void delete (int id);
    void deleteAll();
}

