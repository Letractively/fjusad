package trip;

public abstract class Trip {
	//

	/*
	 * private final int REGULAR_TRIP = 0; private final int HOLIDAY_TRIP = 1;
	 * private int category;
	 */

	private long id;
	private String name;
	private int days;
	private int kilometers;

	public Trip(long someid, String someName, int someDays, int someKilometers) {
		id = someid;
		name = someName;
		days = someDays;
		kilometers = someKilometers;
	}

	public Trip(String someName, int someDays, int someKilometers) {
		id = 0;
		name = someName;
		days = someDays;
		kilometers = someKilometers;
	}

	public long getId() {
		return id;
	}

	/*
	 * public String getCategory(){ String result = ""; switch (category){ case
	 * REGULAR_TRIP: result = "一般旅遊"; break; case HOLIDAY_TRIP: result = "假日旅遊";
	 * break; } return result; }
	 */

	public abstract String getCategory();

	public String getName() {
		return name;
	}

	public int getDays() {
		return days;
	}

	public int getKilometers() {
		return kilometers;
	}

	public abstract double getCharge();

	/*
	 * public double getCharge(){ if (category == REGULAR_TRIP) { return 200 *
	 * getDays() + 1.5 * getKilometers(); } else { if(
	 * getDaysKilometersCharge()> getFixCharge()) return getFixCharge(); else
	 * return getDaysKilometersCharge();
	 * 
	 * } }
	 */

	public String toString() {
		return name + ": " + days + " days, " + kilometers
				+ " kilometers. Total charge is: " + getCharge();
	}
}