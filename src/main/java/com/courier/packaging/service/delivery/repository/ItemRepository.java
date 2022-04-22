package com.courier.packaging.service.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.packaging.service.delivery.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}