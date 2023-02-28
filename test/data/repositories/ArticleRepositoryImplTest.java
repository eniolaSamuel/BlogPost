package data.repositories;

import data.models.Article;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
    private ArticleRepository articleRepository;
    private Article article;

    @BeforeEach
    public void startWithThis() {
        articleRepository = new ArticleRepositoryImpl();
        article = new Article();
        article.setTitle("Title");
        article.setBody("Body");
    }

    @Test
    public void saveOneArticle_countIsOneTest(){
        Article article = new Article();
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
    }

    @Test
    public void saveOneArticle_idOfArticleIsOneTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
    }

    @DisplayName("Update Article Test")
    @Test
    public void saveTwoArticlesWithSameId_countIsOneTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        savedArticle.setBody("Body");
        savedArticle.setTitle("Title");
        articleRepository.save(savedArticle);
        assertEquals(1, articleRepository.count());
    }

    @Test
    public void saveOneArticle_findArticleByIdTest(){
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundUser = articleRepository.findById(1);
        assertEquals(foundUser, savedArticle);
    }

    @Test
    public void saveOneArticle_deleteOneArticle_countIsZeroTest(){
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.count());
    }

}