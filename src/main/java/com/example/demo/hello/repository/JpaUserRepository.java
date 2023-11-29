package com.example.demo.hello.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.hello.domain.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class JpaUserRepository implements UserRepository{

	private final EntityManager em;
	
	@Autowired
	public JpaUserRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public User save(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public Optional<User> findById(String id) {
		User user = em.find(User.class, id);
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<User> findByName(String name) {
		List<User> result = em.createQuery("select u from User u where u.name = :name",User.class)
				.setParameter("name", name)
				.getResultList();
		return result.stream().findAny();
	}

	// ??????
	@Override
	public List<User> findAll() {
		List<User> result = em.createQuery("select u from User u",User.class)
				.getResultList();
		return result;
	}
	
	@Override
	public User login(User user) {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.id = :id AND u.password = :password",User.class);
		query.setParameter("id", user.getId());
		query.setParameter("password", user.getPassword());
		
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	    	System.out.println("왜에러?");
	        return null;
	    }
	}
	

}
