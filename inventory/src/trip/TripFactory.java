package trip;

public class TripFactory {
	public static Trip get(String category, String name, int kilometers,
			int days) {
		if (category.endsWith("HolidayTrip"))
			return new HolidayTrip(name, kilometers, days);
		return new RegularTrip(name, kilometers, days);
	}

	public static Trip get(long id, String category, String name,
			int kilometers, int days) {
		if (category.endsWith("HolidayTrip"))
			return new HolidayTrip(id, name, kilometers, days);
		return new RegularTrip(id, name, kilometers, days);
	}

}
