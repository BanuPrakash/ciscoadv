package com.cisco.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cisco.prj.entity.Customer;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Customer addCustomer(Customer c) {
		em.persist(c);
		return c;
	}

	@Override
	public List<Customer> getCustomers() {
		TypedQuery<Customer> query = em.createQuery("from Customer", Customer.class);
		return query.getResultList();
	}

	@Override
	public Customer getCustomer(String email) {
		return em.find(Customer.class, email);
	}

}
