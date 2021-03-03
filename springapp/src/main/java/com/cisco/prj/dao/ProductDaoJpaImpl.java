package com.cisco.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Product;

@Repository
public class ProductDaoJpaImpl implements ProductDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Product addProduct(Product p) {
		 em.persist(p);
		 return p;
	}

	@Override
	public List<Product> getProducts() {
		TypedQuery<Product> query = em.createQuery("from Product", Product.class); // JPQL
		return query.getResultList();
	}

	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public void deleteProduct(int id) {
		em.remove(getProduct(id));
	}

}
