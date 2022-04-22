package com.courier.packaging.service.delivery.service;

import java.util.List;
import com.courier.packaging.service.delivery.model.request.ItemAddress;

public interface ServiceDeliveryService{
	boolean savePackageToDb(List<ItemAddress> itemAddress) ;
}