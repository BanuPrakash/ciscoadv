package com.cisco.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cisco.prj.dao.DaoException;
import com.cisco.prj.dao.ProductDao;
import com.cisco.prj.dao.ProductDaoJdbcImpl;
import com.cisco.prj.entity.Product;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			List<Product> products = productDao.getProducts();
			request.setAttribute("products", products);
			// server side redirection
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("quantity"));
		ProductDao productDao = new ProductDaoJdbcImpl();
		try {
			productDao.addProduct(new Product(0, name, price, qty));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		// client side redirection
		response.sendRedirect("index.html");
	}

}
