package org.bbva.kidsbankingapp.utils;

public class MyStringUtils {

	public static final boolean isBlank(String id) {
		if (id==null) {return true;}
		if (id.strip().equals("")) {return true;}
		return false;
	}

}
