package com.ayna.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayna.item.entity.Item;
import com.ayna.item.repo.ItemRepo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepo itemRepo;
	
	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepo.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepo.findAll();
	}

	@Override
	public void deleteItem(Long itemId) {
		itemRepo.deleteById(itemId);
		
	}

	}
