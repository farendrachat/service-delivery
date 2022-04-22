package com.courier.packaging.service.delivery.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.courier.packaging.service.delivery.entity.AddressEntity;
import com.courier.packaging.service.delivery.entity.ItemEntity;
import com.courier.packaging.service.delivery.entity.PackageEntity;
import com.courier.packaging.service.delivery.model.request.ItemAddress;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ServiceDeliveryUtil {

	public static List<PackageEntity> sortItemsByAddress1(List<ItemAddress> lstItemAddress){
		List<PackageEntity> lstPackageEntity = new ArrayList<PackageEntity>() ; 
		log.debug("Sorting of items and address into Packages for storing in database");
		
		if(lstItemAddress!=null && lstItemAddress.size()>=0) {			
			for(int count=0,packageIndex=0;count<lstItemAddress.size();count++) {
				PackageEntity packageEntity = new PackageEntity();
				AddressEntity addressEntity = new AddressEntity();
				ItemEntity item = new ItemEntity();
				List<ItemEntity> lstItemEntityTemp = new ArrayList();
				addressEntity.setLine1(lstItemAddress.get(count).getLine1());
				addressEntity.setLine2(lstItemAddress.get(count).getLine2());
				addressEntity.setCity(lstItemAddress.get(count).getCity());
				addressEntity.setState(lstItemAddress.get(count).getState());
				addressEntity.setZone(lstItemAddress.get(count).getZone());
				packageEntity.setAddressEntity(addressEntity);
					
				item.setItemId(Integer.parseInt(lstItemAddress.get(count).getItemId()));
				item.setItemName(lstItemAddress.get(count).getItemName());
				item.setQuantity(lstItemAddress.get(count).getQuantity());
				item.setPrice(lstItemAddress.get(count).getPrice());
				item.setTotal(lstItemAddress.get(count).getTotal());				
				
				
				if((lstPackageEntity.size()==0) || !(lstPackageEntity.contains(packageEntity))){		
					packageEntity.setPackageId(packageIndex);
					packageEntity.getAddressEntity().setAddressId(packageIndex);
					packageEntity.getAddressEntity().setPackageId(packageIndex);
					item.setAddressId(packageIndex++);
					lstItemEntityTemp.add(item);
					packageEntity.getAddressEntity().setLstItems(lstItemEntityTemp);					
				    lstPackageEntity.add(packageEntity);				   
				}				
				else if(lstPackageEntity.contains(packageEntity)){
		        int indexOccurance = lstPackageEntity.indexOf(packageEntity);
		        item.setAddressId(lstPackageEntity.get(indexOccurance).getAddressEntity().getAddressId());
		        lstPackageEntity.get(indexOccurance).getAddressEntity().getLstItems().add(item);   
		}	
		}
		}
		return lstPackageEntity;
	}
	





}