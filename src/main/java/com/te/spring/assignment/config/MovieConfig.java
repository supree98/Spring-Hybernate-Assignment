package com.te.spring.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.te.spring.assignment.bean.Movie;

@Configuration
public class MovieConfig {

	@Bean
	public Movie getMovie() {
		return new Movie(50, "Shutter Island", "Excellent", 4.9);
	}
}
