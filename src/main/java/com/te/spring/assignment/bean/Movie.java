package com.te.spring.assignment.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class Movie implements Serializable {

	@Id
	@Column
	private int mid;
	@Column
	private String mname;
	@Column
	private String mreview;
	@Column
	private double mratings;

	public Movie(int mid, String mname, String mreview, double mratings) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mreview = mreview;
		this.mratings = mratings;
	}

}
