package com.courier.packaging.service.delivery.model.request;

import javax.validation.constraints.NotEmpty;

import org.apache.commons.codec.binary.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Item", description = "item details that need to be couriered")

public class ItemAddress {
	
	@NotEmpty(message = "itemId can not be blank")
	@Schema(description ="unique item id")
	private String itemId;
	@Schema(description ="name of the item")
	private String itemName	;
	@Schema(description ="quantity of the item to deliver")
	private String quantity;
	@Schema(description ="price of the item")
	private String price;
	@Schema(description ="total payment to be done")
	private String total;

	@NotEmpty(message = "addressId can not be blank")
	@Schema(description ="unique address id")
	private String addressId;
	@Schema(description ="line 1 in the address")
	private String line1;
	@Schema(description ="line 2 in the address")
	private String line2;	
	@Schema(description ="city in the address")
	private String city;
	@Schema(description ="state in the address")
	private String state;
	@Schema(description ="warehouse in this zone will do the courier")
	private String zone;
	
		
	 @Override
	    public boolean equals(Object obj) {
		 boolean itemEqual = false;
	        if (obj == null) {
	            return false;
	        }
	        if (obj.getClass() != this.getClass()) {
	            return false;
	        }

	        final ItemAddress other = (ItemAddress) obj;
	        
	        if(StringUtils.equals(this.itemId, other.itemId) && StringUtils.equals(this.addressId, other.addressId)) {
	        	itemEqual = true; 
	        }	        
	       return itemEqual;
	    }		

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * (result +				
			(
			 ((this.itemId == null) ? 0 : itemId.hashCode()) +
			 ((this.addressId == null) ? 0 : addressId.hashCode())
			));
		return result;
	}
	
	
}
