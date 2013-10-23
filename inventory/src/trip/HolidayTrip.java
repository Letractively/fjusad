package trip;

public class HolidayTrip extends Trip {

	public HolidayTrip(String someName, int someDays, int someKilometers) {
		super(someName, someDays, someKilometers);
	}

	public HolidayTrip(long id, String someName, int someDays,
			int someKilometers) {
		super(id, someName, someDays, someKilometers);
	}

	private double getFixCharge() {
		return 1500.0;
	}

	private double getDaysKilometersCharge() {
		return 300 * getDays() + .5 * getKilometers();
	}

	public double getCharge() {
		if (getDaysKilometersCharge() > getFixCharge())
			return getFixCharge();
		else
			return getDaysKilometersCharge();
	}

	public String getCategory() {
		return "假日旅程";
	}

}