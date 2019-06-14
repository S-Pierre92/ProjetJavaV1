package com.wheeludrive.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.wheeludrive.exception.WheelUDriveException;
import com.wheeludrive.servlet.HomePageServlet;

public class DateUtils {
	private final static Logger log = Logger.getLogger(DateUtils.class);

	private DateUtils() {
		// Utility class
	}
	
	@SuppressWarnings("deprecation")
	public static String getStringDateFormatOne(Date date) {
		return date.getDay() + "/" + date.getMonth() + "/" + (date.getYear() + 1900);
		
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
			throw new WheelUDriveException("Waaah c'est quoi cette ann�e la?");
		}

		if (month < 1 && month > 12) {
			throw new WheelUDriveException("C'est un mois imaginaire monsieur");
		}

		if (day < 1 && day > 31) {
			throw new WheelUDriveException("Mauvais jour pour avoir son annif");
		}
		
		log.info("annee" + year + " / month " + month + " / day " + day );

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
	
	public static String getStringDateFormatCalendar(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        String strDate = dateFormat.format(date);  
        return strDate;
	}

}
