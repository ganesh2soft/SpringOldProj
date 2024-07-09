package com.ayna.item.entity;

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
@Table(name = "item_tbl")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;
	
	@Column(name="seller_name",unique=true)
	private String sellerName;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="stock_units")
	private int stockUnits;
	
	@Column(name="unit_price")
	private int unitPrice;

	@Column(name = "listed_date")
	@CreationTimestamp
	private Date listedDate;
	
	@Column(name="image_url")
	private String imageUrl;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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
		return Objects.hash(categoryId, imageUrl, itemId, itemName, listedDate, sellerName, stockUnits, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return categoryId == other.categoryId && Objects.equals(imageUrl, other.imageUrl)
				&& Objects.equals(itemId, other.itemId) && Objects.equals(itemName, other.itemName)
				&& Objects.equals(listedDate, other.listedDate) && Objects.equals(sellerName, other.sellerName)
				&& stockUnits == other.stockUnits && unitPrice == other.unitPrice;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", sellerName=" + sellerName + ", itemName=" + itemName + ", categoryId="
				+ categoryId + ", stockUnits=" + stockUnits + ", unitPrice=" + unitPrice + ", listedDate=" + listedDate
				+ ", imageUrl=" + imageUrl + "]";
	}

	public Item(Long itemId, String sellerName, String itemName, int categoryId, int stockUnits, int unitPrice,
			Date listedDate, String imageUrl) {
		super();
		this.itemId = itemId;
		this.sellerName = sellerName;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.stockUnits = stockUnits;
		this.unitPrice = unitPrice;
		this.listedDate = listedDate;
		this.imageUrl = imageUrl;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
