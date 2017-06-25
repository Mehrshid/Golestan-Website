package com.golestan.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.golestan.enums.TermNumberEnum;

@Entity(name="golestan_term")
public class Term {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long Id;

	@Column(name = "term_number")
	private TermNumberEnum termNumber;

	@Column(name = "year")
	private Timestamp year;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public TermNumberEnum getTermNumber() {
		return termNumber;
	}

	public void setTermNumber(TermNumberEnum termNumber) {
		this.termNumber = termNumber;
	}

	public Timestamp getYear() {
		return year;
	}

	public void setYear(Timestamp year) {
		this.year = year;
	}

}
