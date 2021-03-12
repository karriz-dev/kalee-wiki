package land.kalee.wiki.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import land.kalee.wiki.entity.auth.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	public Article findByArticleID(Long id);
	public Article findTopByOrderByArticleIDDesc();
	public List<Article> findTop10ByOrderByArticleIDDesc();
	public List<Article> findByTitleContaining(String title);
}
