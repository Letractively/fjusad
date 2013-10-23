package trip;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Key;

public class PersistenceTrip {
	public static boolean save(String category, String name, int days,
			int kilometers) {
		// use TripFactory to deal with HolidayTrip and RegularTrip
		Trip t = TripFactory.get(category, name, days, kilometers);
		boolean ok = save(t);
		// return false if there is a problem
		// implementation is needed
		return ok;
	}

	public static boolean save(Trip t) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		Entity trip = new Entity("Trip");
		// store the class name into the datastore
		trip.setProperty("category", t.getClass().getName());
		trip.setProperty("name", t.getName());
		trip.setProperty("days", t.getDays());
		trip.setProperty("kilometers", t.getKilometers());
		datastore.put(trip);
		// return false if there is a problem
		// implementation is needed
		return true;
	}

	public static List<Trip> getAllTrips() {
		List<Trip> alltrips = new ArrayList<Trip>();
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();
		// Use class Query to assemble a query
		Query q = new Query("Trip");
		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			Key k = result.getKey();
			long id = k.getId();
			String category = (String) result.getProperty("category");
			String name = (String) result.getProperty("name");
			// Datastore store int as long
			int days = ((Long) result.getProperty("days")).intValue();
			int kilometers = ((Long) result.getProperty("kilometers"))
					.intValue();
			alltrips.add(TripFactory.get(id, category, name, days, kilometers));
		}
		return alltrips;
	}
}
