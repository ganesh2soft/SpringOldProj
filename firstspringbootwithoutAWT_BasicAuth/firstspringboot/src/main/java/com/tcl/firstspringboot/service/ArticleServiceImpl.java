package com.tcl.firstspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcl.firstspringboot.entity.Article;
import com.tcl.firstspringboot.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Article addArticle(Article article) {
	
		return articleRepository.save(article);
	}

	@Override
	public List<Article> listAllArticle() {
		
		return articleRepository.findAll();
	}

	@Override
	public Optional<Article> findByArticleId(Long id) {
		
		return articleRepository.findById(id);
	}



	@Override
	public Article updateArticle(Article article) {
	
		return articleRepository.save(article);
	}

	@Override
	public String deleteArticle(Long id) {
		
		articleRepository.deleteById(id);
		return "Deleted Successfully";
		
	}

	@Override
	public Article findByTitle(String title) {
		return articleRepository.findByTitleContains(title);
	}
	
	
}
