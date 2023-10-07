/*package com.example.springboot6.springboot6.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtDAO {
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("DevanosPU"); 	
	
	public ArtDAO() {
	}
	
	public void persist(Object object) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(object);
		em.getTransaction().commit();
		em.close();
	}

} */


// Ignore ^ this code is for hibernate