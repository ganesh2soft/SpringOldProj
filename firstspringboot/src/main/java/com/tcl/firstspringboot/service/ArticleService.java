package com.tcl.firstspringboot.service;

import java.util.List;
import java.util.Optional;

import com.tcl.firstspringboot.entity.Article;

public interface ArticleService {
	public Article addArticle(Article article);
	public List<Article> listAllArticle();
	public Optional<Article> findByArticleId(Long id);
	public Article findByTitle(String title);
	public Article updateArticle(Article article);
	public String deleteArticle(Long id);
}
