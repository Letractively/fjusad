package seminar;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PrimaryKey;



@PersistenceCapable
public class Registration {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent
	private String username;
	@Persistent
	private Seminar theSeminar;

    public Registration(String newName, Seminar s) {
    	username = newName;
    	theSeminar = s;
	}
	
    public Long getId() {
    	return id;
    }
    public void setId(Long i) {
    	id = i;
    }
    
	public String getName(){
	   	return username;
	}
	    
	public Seminar getSeminar(){
	   	return theSeminar;
	}
	
	public String toString(){
	   	return "Faculty:" + username + "Seminar:"+theSeminar.getName();
	}
	    
}//Registration
