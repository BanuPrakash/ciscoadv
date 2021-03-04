package com.cisco.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cisco.prj.entity.Product;
import com.cisco.prj.service.OrderService;

@Controller
public class ProductController {
	@Autowired
	private OrderService service;
	
	@RequestMapping("listProducts.do")
	public ModelAndView getProducts() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("products", service.fetchProducts());
		mav.setViewName("list.jsp");
		return mav;
	}
	
	@RequestMapping("productForm.do")
	public ModelAndView getProductForm() {
		Product p = new Product();
		ModelAndView mav = new ModelAndView();
		mav.addObject("product", p);
		mav.setViewName("addProduct.jsp");
		return mav;
	}
	
	@RequestMapping("addProduct.do")
	public ModelAndView addProduct(@ModelAttribute("product") Product p) {
		service.insertProduct(p);
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Product added!!!");
		mav.setViewName("index.jsp");
		return mav;
	}
}
