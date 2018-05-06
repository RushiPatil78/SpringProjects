package com.spring.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.dto.Customer;
import com.spring.service.CustomerService;

public class CustomerAction {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springconfig.xml");
		
		CustomerService customerService = applicationContext.getBean("customerServiceImpl",CustomerService.class);
		
		List<Customer> customerList = customerService.getList();
		
		System.out.println("...List Of Customers...");
		for (Customer customer : customerList) {
			System.out.println(customer.getCustomerId()+" "+customer.getName());
		}
	}

}
