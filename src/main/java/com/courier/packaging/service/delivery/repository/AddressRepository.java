package com.courier.packaging.service.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.packaging.service.delivery.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
	
}