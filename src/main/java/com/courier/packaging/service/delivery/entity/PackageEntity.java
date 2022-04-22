package com.courier.packaging.service.delivery.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.codec.binary.StringUtils;

import lombok.Data;

@Data
@Entity
public class PackageEntity {
	@NotEmpty(message = "packageId can not be blank")
	@Column
	@Id
	private int packageId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "packageEntity")
	private AddressEntity addressEntity;

	@Override
	public boolean equals(Object obj) {
		boolean packageEqual = false;
		if (obj == null) {
			return false;
		}
		if (obj.getClass() != this.getClass()) {
			return false;
		}

		final PackageEntity other = (PackageEntity) obj;

		if (StringUtils.equals(this.getAddressEntity().getLine1(), other.getAddressEntity().getLine1())
				&& StringUtils.equals(this.getAddressEntity().getLine2(), other.getAddressEntity().getLine2())
				&& StringUtils.equals(this.getAddressEntity().getCity(), other.getAddressEntity().getCity())
				&& StringUtils.equals(this.getAddressEntity().getState(), other.getAddressEntity().getState())) {
			packageEqual = true;
		}

		return packageEqual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * (result + (((this.getAddressEntity().getLine1() == null) ? 0
				: this.getAddressEntity().getLine1().hashCode())
				+ ((this.getAddressEntity().getLine2() == null) ? 0 : this.getAddressEntity().getLine2().hashCode())
				+ ((this.getAddressEntity().getCity() == null) ? 0 : this.getAddressEntity().getCity().hashCode())
				+ ((this.getAddressEntity().getState() == null) ? 0 : this.getAddressEntity().getState().hashCode())));
		return result;
	}

}
