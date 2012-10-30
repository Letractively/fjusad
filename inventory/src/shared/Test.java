package shared;
import seminar.Seminar;
import javax.jdo.PersistenceManager;

public class Test {
	private PersistenceManager pm;
	public Test(){
		pm = PMF.get().getPersistenceManager();
		Seminar a = new Seminar();
		pm.makePersistent(a);
	}

}
