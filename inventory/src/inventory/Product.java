package inventory;

//import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.IdGeneratorStrategy;


@PersistenceCapable
public class Product{
	//Key is created by Datastore
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
    
	@Persistent
    private int category;
	@Persistent
    private String desc;
	@Persistent
    private int inventory;
	@Persistent
    private int reorderPoint;

	public Product(int category, String desc, int inventory, int reorderPoint){
            this.category = category;
            this.desc = desc;
            this.inventory = inventory;
            this.reorderPoint = reorderPoint;             
        }
        public Product(){
            this.category = 0;
            this.desc = "NA";
            this.inventory = 0;
            this.reorderPoint = 0;             
        }
   
        public Long getId(){
            return id;
        }

        public int getCategory(){
            return category;
        }
        public String getDesc(){
            return desc;
        }
        public int getInventory(){
        		return inventory;
        }
        public int getReorderPoint(){
        		return reorderPoint;
        }
        public boolean stock(int amt){
        	if (amt >=0 ){
        		inventory+=amt;
        		return true;
        	}
        	else
        		return false;
        }
        public boolean sell(int amt){
        	if (inventory -amt >= 0 && amt >= 0){
        		inventory-=amt;
        		return true;
        	}
        	else
        		return false;
        }
        
} // Product
