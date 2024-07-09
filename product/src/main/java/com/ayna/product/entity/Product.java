 package com.ayna.product.entity;

import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="product_tbl")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="seller_name",unique=true)
	private String sellerName;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="brand_name", unique = true)
	private String brandName;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="stock_units")
	private int stockUnits;
	
	@Column(name="unit_price")
	private int unitPrice;
	
	@Column(name="listed_date")
	@CreationTimestamp
	private Date listedDate;
	
	@Column(name="image_url")
	private String imageUrl;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getStockUnits() {
		return stockUnits;
	}

	public void setStockUnits(int stockUnits) {
		this.stockUnits = stockUnits;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getListedDate() {
		return listedDate;
	}

	public void setListedDate(Date listedDate) {
		this.listedDate = listedDate;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brandName, categoryId, imageUrl, listedDate, productId, productName, sellerName, stockUnits,
				unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(brandName, other.brandName) && categoryId == other.categoryId
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(listedDate, other.listedDate)
				&& productId == other.productId && Objects.equals(productName, other.productName)
				&& Objects.equals(sellerName, other.sellerName) && stockUnits == other.stockUnits
				&& unitPrice == other.unitPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", sellerName=" + sellerName + ", productName=" + productName
				+ ", brandName=" + brandName + ", categoryId=" + categoryId + ", stockUnits=" + stockUnits
				+ ", unitPrice=" + unitPrice + ", listedDate=" + listedDate + ", imageUrl=" + imageUrl + "]";
	}

	public Product(int productId, String sellerName, String productName, String brandName, int categoryId,
			int stockUnits, int unitPrice, Date listedDate, String imageUrl) {
		super();
		this.productId = productId;
		this.sellerName = sellerName;
		this.productName = productName;
		this.brandName = brandName;
		this.categoryId = categoryId;
		this.stockUnits = stockUnits;
		this.unitPrice = unitPrice;
		this.listedDate = listedDate;
		this.imageUrl = imageUrl;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
