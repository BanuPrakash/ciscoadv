package com.cisco.prj.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cisco.prj.entity.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// i18n
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required", "Name is required");
		Product p = (Product) target;
		if(p.getPrice() <= 0) {
			errors.rejectValue("price", "price.invalid", "Price should be greater than zero");
		}
		if(p.getQuantity() <= 0) {
			errors.rejectValue("quantity", "quantity.invalid", "Quantity should be greater than zero");
		}
	}

}
