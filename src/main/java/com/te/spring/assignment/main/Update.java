package com.te.spring.assignment.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.te.spring.assignment.bean.Movie;
import com.te.spring.assignment.config.MovieConfig;

public class Update {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MovieConfig.class);
		Movie movie = context.getBean(Movie.class);
		int mid = movie.getMid();
		String mname = movie.getMname();
		String mreview = movie.getMreview();
		double mrating = movie.getMratings();
		((AbstractApplicationContext) context).close();

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;

		entityManagerFactory = Persistence.createEntityManagerFactory("Movie");
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();

		String query = "update Movie set  mname = '" + mname + "', mreview = '" + mreview + "' , mratings = " + mrating
				+ " where id = " + mid;
		Query q = entityManager.createQuery(query);

		int count = q.executeUpdate();

		transaction.commit();
		System.out.println(count + " rows updated....");

	}

}
