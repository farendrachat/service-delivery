package com.courier.packaging.service.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class ItemEntity {
	@NotEmpty(message = "itemId can not be blank")
	@Column
	@Id
	private int itemId;
	@Column
	private String itemName;
	@Column
	private String quantity;
	@Column
	private String price;
	@Column
	private String total;

	@Column
	private int addressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressId", insertable = false, updatable = false)
	@JsonIgnore
	private AddressEntity addressEntity;

}
