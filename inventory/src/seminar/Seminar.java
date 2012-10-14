package seminar;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Element;

import java.util.List;
import java.util.ArrayList;

@PersistenceCapable
public class Seminar {

	@Persistent
	@PrimaryKey
	private String name;
	@Persistent
	private String date;
	@Persistent
	private int maxRegistrations;    //一個講座可容納的最大報名數

	@Persistent(mappedBy = "theSeminar")
	@Element(dependent = "true") 
	private List <Registration> register;    //報名者資料
	
	@Persistent
	private int count = 0;  //計算報名人數
	
    public Seminar(String newName, String newDate, int newNumber) {//constructor
    	name = newName;
    	date = newDate;
    	maxRegistrations = newNumber;
   	register = new ArrayList<Registration>();
   	//register.add(new Registration("ben", "12345", "12345"));
   	//count = 1;
    }
    
    public Seminar() {//constructor
    	name = "N/A";
    	date = "N/A";
    	maxRegistrations = 0;
    	register = new ArrayList<Registration>();
    }
    
    
    public String getName(){
    	return name;
    }
    
    public String getDate(){
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
 	//reserve()檢查是否額滿或報名者資料重覆


    
}
