package com.courier.packaging.service.delivery.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
public class AddressEntity {

	@NotEmpty(message = "addressId can not be blank")
	@Column
	@Id
	private int addressId;
	@Column
	private String line1;
	@Column
	private String line2;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zone;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "addressEntity")
	private List<ItemEntity> lstItems;

	@Column
	private int packageId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private PackageEntity packageEntity;

}
