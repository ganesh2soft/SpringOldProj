package com.ayna.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ayna.item.entity.Item;
import com.ayna.item.service.ItemService;

@RestController
@RequestMapping("/api/v1/item")
// @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", methods = { RequestMethod.GET, RequestMethod.POST,
//		RequestMethod.PUT, RequestMethod.DELETE })
public class ItemCtrl {
	@Autowired
	ItemService itemService;
	
	@PostMapping("/additem")
	public Item  saveItem (@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	@GetMapping("/allitems")
	public List<Item> fetchAllItem (){
		return itemService.getAllItems();
	}
	@DeleteMapping("/deleteitem/{itemId}")
	public void deleteItembyId(@PathVariable("itemId") Long iid) {
		itemService.deleteItem(iid);
		
	}

	
	
}
