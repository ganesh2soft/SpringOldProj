package com.tcl.firstspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.tcl.firstspringboot.entity.Article;

import com.tcl.firstspringboot.service.ArticleService;

@RestController
@RequestMapping("/api/article")
//@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*",exposedHeaders="Access-Control-Allow-Origin",
//methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.OPTIONS})
public class ArticleController {
	@Autowired
	public ArticleService articleService;
	
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Helloooooooo";
	}
	
	@PostMapping("/addarticle")
	public Article addArticle(@RequestBody Article article) {
		
		return articleService.addArticle(article);
	}

	@GetMapping("/listall")
	public ResponseEntity<List<Article>> listAllArticle() {
		 HttpHeaders responseHeaders = new HttpHeaders();
		  //  responseHeaders.set("Access-Control-Allow-Origin", "http://localhost:4200");
		return  ResponseEntity.ok()
			      .headers(responseHeaders)
			      .body(articleService.listAllArticle());
	}

	@GetMapping("/findbyid/{id}")
	public Optional<Article> findByArticleId(@PathVariable(value = "id") Long id) {
		Optional<Article> article = articleService.findByArticleId(id);
		return article;
	}

	@PutMapping("/updateart/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") Long id,
			@RequestBody Article updarticle) throws Exception {
		Article article = articleService.findByArticleId(id)
				.orElseThrow(() -> new Exception("Article not found for this id :: " + id));;
		article.setTitle(updarticle.getTitle());
		article.setCategory(updarticle.getCategory());
		article.setAuthor(updarticle.getAuthor());
		article.setDescription(updarticle.getDescription());
		article.setLastModified(updarticle.getLastModified());
		article.setViews(updarticle.getViews());
		final Article updatedArticle = articleService.addArticle(article);	
		
		return ResponseEntity.ok(updatedArticle);
	}
	@DeleteMapping("/deleteart/{id}")
	public String deleteArticle(@PathVariable(value = "id") Long id) {
		
		articleService.deleteArticle(id);
		return id + "Deleted successfully !!!";		
	}
	@GetMapping("/findbytitle/{title}")
	public Article findByTitle(@PathVariable(value = "title") String title) {
		return articleService.findByTitle(title);
	}
	
	/*
	 * @PostMapping("/error") public String fnError() { return "Error"; }
	 */

}
