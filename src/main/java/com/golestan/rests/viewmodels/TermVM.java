package com.golestan.rests.viewmodels;

import java.sql.Timestamp;


import com.golestan.enums.TermNumberEnum;

public class TermVM {

	private TermNumberEnum termNumber;

	private Timestamp year;

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
