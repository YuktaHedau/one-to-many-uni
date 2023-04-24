package com.jsp.hospital.branch;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("yuki");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		
		Hospital hospital = new Hospital();
		hospital.setGstNumber("123abcd");
		hospital.setName("Appolo");
		
		Branch b1 = new Branch();
		b1.setLocation("Thane");
		b1.setName("Appolo-1");
		
		Branch b2 = new Branch();
		b2.setLocation("Vashi");
		b2.setName("Appolo-2");
		
		Branch b3 = new Branch();
		b3.setLocation("Panvel");
		b3.setName("Appolo-3");
		
		Branch b4 = new Branch();
		b4.setLocation("Mumbai");
		b4.setName("Appolo-4");
		
		List<Branch> branch = new ArrayList<Branch>();
		branch.add(b1);
		branch.add(b2);
		branch.add(b3);
		branch.add(b4);
		//uni-direction
		hospital.setBranches(branch);
		
		et.begin();
		em.persist(hospital);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		et.commit();
		
	}

}
