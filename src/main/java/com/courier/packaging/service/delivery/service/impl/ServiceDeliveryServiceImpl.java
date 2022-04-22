package com.courier.packaging.service.delivery.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courier.packaging.service.delivery.entity.PackageEntity;
import com.courier.packaging.service.delivery.model.request.ItemAddress;
import com.courier.packaging.service.delivery.repository.PackageRepository;
import com.courier.packaging.service.delivery.service.ServiceDeliveryService;
import com.courier.packaging.service.delivery.util.ServiceDeliveryUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceDeliveryServiceImpl implements ServiceDeliveryService {
	
	@Autowired
	PackageRepository packageRepository;
	
	public boolean savePackageToDb(List<ItemAddress> lstItemAddress) {
		List<PackageEntity> lstPackageEntity = ServiceDeliveryUtil.sortItemsByAddress1(lstItemAddress);
		for(PackageEntity packageEntity : lstPackageEntity) {			
			packageRepository.save(packageEntity);			
		}	
		log.debug("package Entity saved in db");
	return true;
	}
	
}