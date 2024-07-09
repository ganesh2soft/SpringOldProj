package com.tcl.firstspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private String category;
	private String description;
	private String lastModified;
	private int views;

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(Long id, String title, String author, String category, String description, String lastModified,
			int views) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.lastModified = lastModified;
		this.views = views;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", description=" + description + ", lastModified=" + lastModified + ", views=" + views + "]";
	}
}
