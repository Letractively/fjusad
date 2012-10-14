package trip;

public abstract class Trip {
	
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
    
	public long getId(){
		return id;
	}

	public abstract String getCategory();

	
    public String getName(){
    	return name;
    }
    
    public int getDays(){
    	return days;
    }
    
    public int getKilometers(){
    	return kilometers;
    }
    
    public abstract double getCharge();
    
    public String toString(){
    	return name + ": " + days + " days, " + kilometers + " kilometers. Total charge is: " + getCharge();
    }   
}