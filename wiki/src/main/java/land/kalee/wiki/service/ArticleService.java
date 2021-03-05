package land.kalee.wiki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import land.kalee.wiki.entity.auth.Article;
import land.kalee.wiki.entity.response.Result;
import land.kalee.wiki.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	private final int ARTICLE_SAVE_SUCCESS = 0x00000001;
	private final int ARTICLE_SAVE_FAIL = 0x00000002;
	
	public List<Article> getUpdateArticleList()
	{
		return articleRepository.findTop10ByOrderByArticleIDDesc();
	}
	
	public long getLatestIndex()
	{
		return articleRepository.findTopByOrderByArticleIDDesc().getArticleID();
	}
	
	public Article getArticle(long index) {
		return articleRepository.findByArticleID(index);
	}
	
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}
	
	public Result insertArticle(Article article) {
		Article result = articleRepository.save(article);
		
		if(result != null)
			return Result.builder()
					.resultCode(ARTICLE_SAVE_SUCCESS)
					.message("SUCCESS")
					.build();
		else 
			return Result.builder()
					.resultCode(ARTICLE_SAVE_FAIL)
					.message("FAIL")
					.build();
	}
}
