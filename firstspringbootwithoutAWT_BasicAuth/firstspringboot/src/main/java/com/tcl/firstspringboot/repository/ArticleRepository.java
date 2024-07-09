package com.tcl.firstspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcl.firstspringboot.entity.Article;
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	public Article findByTitleContains(String title);
}
