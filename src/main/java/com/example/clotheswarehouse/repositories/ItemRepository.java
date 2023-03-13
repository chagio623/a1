package com.example.clotheswarehouse.repositories;

import com.example.clotheswarehouse.ClothesWarehouseApplication.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
    <S extends Item> S save(S item);
}
