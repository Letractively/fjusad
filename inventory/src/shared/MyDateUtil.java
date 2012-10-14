package shared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtil {
	public static Date getTodayDate(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	public static String getTodayString(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		return dateFormat.format(calendar.getTime());
	}

	public static Date parse(String s) {
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Date d = dateFormat.parse(s);
			return d;
		} catch (ParseException e) {
			return calendar.getTime();
		}
	}

	public static String format(Date d) {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String s = getTodayString();
		s = dateFormat.format(d);
		return s;

	}

}
