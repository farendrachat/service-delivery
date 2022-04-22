package com.courier.packaging.service.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RestController;

import com.courier.packaging.service.delivery.model.request.ItemAddress;
import com.courier.packaging.service.delivery.service.ServiceDeliveryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ServiceDeliveryController {

	@Autowired
	ServiceDeliveryService serviceDeliveryService;

	@Operation(summary = "Delivery service for packaging the orders")
	@SqsListener("sqs-queue")
	public void loadMessagesFromQueue(List<ItemAddress> lstItemAddress) {
		try {
			log.debug("Message received in consumer side: " + lstItemAddress);
			serviceDeliveryService.savePackageToDb(lstItemAddress);
		} catch (Exception ex) {
			log.error("Exception caught in consumer is :" + ex);
		}
	}

}
