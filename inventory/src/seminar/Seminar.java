package seminar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Element;
import com.google.appengine.api.datastore.Key;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@PersistenceCapable
public class Seminar {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

	@Persistent
	private String name;
	@Persistent
	private Date date;
	@Persistent
	private int maxRegistrations;    //報名人數上限

	//make it bi-directional association 
	//theSeminar is in the Registration
	@Persistent(mappedBy = "theSeminar")
	@Element(dependent = "true") 
	private List <Registration> register;    //報名者資料
	
	@Persistent
	private int count = 0;  //目前報名人數
	
    public Seminar(String newName, Date newDate, int newNumber) {//constructor
    	name = newName;
    	date = newDate;
    	maxRegistrations = newNumber;
   	register = new ArrayList<Registration>();
   	//register.add(new Registration("ben", "12345", "12345"));
   	//count = 1;
    }
    
    public Seminar() {//constructor
    	name = "N/A";
        Calendar calendar = Calendar.getInstance(); 
    	date = calendar.getTime(); //get current time
    	maxRegistrations = 0;
    	register = new ArrayList<Registration>();
    }
    
    public Long getId(){
    	return key.getId();
    }
    
    public String getName(){
    	return name;
    }
    
    public Date getDate(){
    	return date;
    }

 	public int getMaxRegistrations(){
 		return maxRegistrations;
 	}
 	
 	public int getCount(){
 		return count;
 	}

 	public void removeRegistration(int n){
 		register.remove(n);
 	}
 	public void removeAllRegistrations(){
 		register=new ArrayList<Registration>();
 		//register.remove(1);
 	}
 		
 	public String toString(){
 		String allTheRegistration=" ";
 		for(Registration r : register){
 			//allTheRegistration += r.getId()+"\n";
 			allTheRegistration += r+"\n";
 		}
 			
 		return "Seminar: " + name + ", Date: " + date + ", Number of Registrations: " + count + "\n" + allTheRegistration;  
 	}
 	
 	 public List<Registration> getAllRegistrations(){
 		List<Registration> temp = new ArrayList<Registration>();
 		for(Registration r : register){
 			temp.add(r);
 		}
 		return temp;
 	}

  	public boolean checkRegistration(String someName){
  		boolean flag = false;
  		for (Registration r: register){
  			if (someName.equals(r.getName())){
  				flag = true;
  			} 				
  		}
 		return flag;
 	}
 	
 	public boolean reserve(String someName){
 		if (count < maxRegistrations && !checkRegistration(someName)){
 			register.add( new Registration(someName, this));
 			count ++;
 			return true;
 		}
 		else
 			return false;
 	}
 	//reserve() 報名


    
}
