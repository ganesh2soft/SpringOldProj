package com.ayna.item.service;

import java.util.List;
import com.ayna.item.entity.Item;

public interface ItemService {
	public Item saveItem(Item item);
	public List<Item> getAllItems();
	public void deleteItem(Long itemId);
}
