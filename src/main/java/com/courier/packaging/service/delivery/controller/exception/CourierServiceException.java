package com.courier.packaging.service.delivery.controller.exception;

public class CourierServiceException extends Exception{
	
	public CourierServiceException(String errMsg){
		super(errMsg);
        System.out.println("Exception ");
	}
}