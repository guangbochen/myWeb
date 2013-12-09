package com.guangbo.web.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.guangbo.web.model.User;

@Stateless
public class UserBean {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = null;
		try {
			users = em.createNamedQuery("user.findAll")
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAllInPagin(int index, int max) {
		List<User> users = null;
		try {
			users = em.createNamedQuery("user.findAll")
					.setFirstResult(index)
					.setMaxResults(max)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public User findById(long id){
		User user = null;
		try {
			user = em.find(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User findByEmail(String email){
		User user = null;
		try {
			user = em.find(User.class, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
