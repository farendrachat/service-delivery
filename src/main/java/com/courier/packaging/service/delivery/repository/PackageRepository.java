package com.courier.packaging.service.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.courier.packaging.service.delivery.entity.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {
	
}
