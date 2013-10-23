package trip;

public class RegularTrip extends Trip {

	public RegularTrip(long id, String someName, int someDays,
			int someKilometers) {
		super(id, someName, someDays, someKilometers);
	}

	public RegularTrip(String someName, int someDays, int someKilometers) {
		super(someName, someDays, someKilometers);
	}

	public double getCharge() {
		return (200 * super.getDays() + 1.5 * super.getKilometers());
	}

	public String getCategory() {
		return "一般旅程";
	}

}