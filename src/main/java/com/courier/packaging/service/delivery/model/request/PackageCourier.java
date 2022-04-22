package com.courier.packaging.service.delivery.model.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import org.apache.commons.codec.binary.StringUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Package", description = "package to club the items to be delivered to an address")
public class PackageCourier {

	@NotEmpty(message = "packageId can not be blank")
	@Schema(description = "unique packageId of the courier")
	private int packageId;
	@Schema(description = "List of items for the unique address")
	private List<Item> lstItem;
	@NotEmpty(message = "addressId can not be blank")
	@Schema(description = "unique address id")
	private String addressId;
	@Schema(description = "line 1 in the address")
	private String line1;
	@Schema(description = "line 2 in the address")
	private String line2;
	@Schema(description = "city in the address")
	private String city;
	@Schema(description = "state in the address")
	private String state;
	@Schema(description = "warehouse in this zone will do the courier")
	private String zone;

	@Override
	public boolean equals(Object obj) {
		boolean packageEqual = false;
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		final PackageCourier other = (PackageCourier) obj;

		if (StringUtils.equals(this.line1, other.line1) && StringUtils.equals(this.line2, other.line2)
				&& StringUtils.equals(this.city, other.city) && StringUtils.equals(this.state, other.state)) {
			packageEqual = true;
		}

		return packageEqual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * (result
				+ (((this.line1 == null) ? 0 : line1.hashCode()) + ((this.line2 == null) ? 0 : line2.hashCode())
						+ ((this.city == null) ? 0 : city.hashCode()) + ((this.state == null) ? 0 : state.hashCode())));
		return result;
	}

}
