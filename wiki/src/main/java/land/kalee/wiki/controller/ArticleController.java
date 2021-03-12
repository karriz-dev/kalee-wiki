package land.kalee.wiki.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import land.kalee.wiki.entity.auth.Article;
import land.kalee.wiki.entity.response.Result;
import land.kalee.wiki.service.ArticleService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/article")
@Slf4j
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/{index}")
	public Article getArticle(@PathVariable("index") long index)
	{
		return articleService.getArticle(index);
	}
	
	@GetMapping("/latest")
	public Long getLastestIndex()
	{
		return articleService.getLatestIndex();
	}
	
	@GetMapping("/update/list")
	public List<Article> getUpdateArticleList()
	{
		return articleService.getUpdateArticleList();
	}
	
	@GetMapping("/get")
	public List<Article> getArticles()
	{
		return articleService.getArticles();
	}
	
	@GetMapping("/get/{search}")
	public List<Article> getArticles(@PathVariable("search") String keyword)
	{
		return articleService.getArticles(keyword);
	}

	@PostMapping("/insert")
	public Result insertArticles(@RequestBody Article article)
	{
		article.setCreateAt(new Date(System.currentTimeMillis()));
		return articleService.insertArticle(article);
	}
}
