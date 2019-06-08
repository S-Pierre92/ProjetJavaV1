package com.wheeludrive.tools;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;

import com.wheeludrive.exception.WheelUDriveException;

public class DateUtils {

	private DateUtils() {
		// Utility class
	}

	public static Date dateCreator(int year, int month, int day) throws WheelUDriveException {

		validateDate(year, month, day);

		Calendar calendar = Calendar.getInstance();
		calendar.setLenient(false);
		calendar.set(year, month, day);

		Date date = calendar.getTime();
		return date;
	}

	public static boolean validateDate(int year, int month, int day) throws WheelUDriveException {
		
		if (year < 1900) {
			throw new WheelUDriveException("Waaah c'est quoi cette année la?");
		}

		if (month < 1 && month > 12) {
			throw new WheelUDriveException("C'est un mois imaginaire monsieur");
		}

		if (day < 1 && day > 31) {
			throw new WheelUDriveException("Mauvais jour pour avoir son annif");
		}

		String d = day > 9 ? ""+day : "0"+day;
		String m = month > 9 ? ""+ month : "0" + month;
		
		String input = d + "/" + m + "/" + year;
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		f = f.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate.parse(input, f);
			return true;
		} catch (Exception e) {
			throw new WheelUDriveException(input+": L'application pense que ce jour n'existe pas...", e);
		}
	}

}
