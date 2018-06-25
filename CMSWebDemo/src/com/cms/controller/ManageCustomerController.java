package com.cms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.perc.PercSerializationInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.dto.Customer;
import com.cms.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class ManageCustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Customer customer, BindingResult bindingResult, ModelMap map) {
		if (bindingResult.hasErrors()) {
			return "customer/detail";
		} else {
			try {
				Customer tempCustomer = customerService.get(customer.getCustomerId());
				int result = customerService.update(customer);
				if (result > 0) {
					map.addAttribute("msg", "Customer Successfully Updated.");
				} else {
					map.addAttribute("msg", "Problem in update Customer Details.");
				}
			} catch (Exception e) {
				int result = customerService.save(customer);
				if (result > 0) {
					map.addAttribute("msg", "Customer Successfully Saved.");
				} else {
					map.addAttribute("msg", "Problem in save Customer Details.");
				}
			}
			return "customer/detail";
		}		
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getCustomerList(ModelMap map) {
		List<Customer> customerList = customerService.getList();
		map.put("customerList", customerList);
		return "customer/list";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String create(ModelMap map) {
		Customer customer = new Customer();
		map.addAttribute("customer", customer);
		return "customer/detail";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@RequestParam String id, ModelMap map) {
		Customer customer = customerService.get(Long.parseLong(id));
		map.addAttribute("customer", customer);
		return "customer/detail";
	}

}
