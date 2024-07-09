package com.ayna.item.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayna.item.entity.Item;


@Repository
public interface ItemRepo  extends JpaRepository<Item, Long> {

}
