package entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class custumerOrder 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderID")
	 private long OrderId;
	
	 private String date;
	 
	 private double price;
	 
	 private String os;
	 
	 @ManyToOne(fetch=FetchType.EAGER) 
	 @JoinColumn(name="RID") 
	 private RestEntity restaurantId1; 
	 
	 
	 @OneToMany(mappedBy="fk_Order",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 private  List<Meal> listMeals;  
	 
	 
	 
	 @ManyToOne(fetch=FetchType.EAGER) 
	 @JoinColumn(name="RunnerID") 
	 private Runner runner_id;  
	
	
	///////////////////////////////////////////////////////////
	public custumerOrder() {}
 
	public custumerOrder(int p,String d)
	{
		
		price=p;
		date=d;
	}
	
	
	public String printMeals()
	{
		String result="";
		for(int i=0;i<listMeals.size();i++)
		{
			result+="Meal name: "+listMeals.get(i).getName()+  "     price:"+listMeals.get(i).getPrice()+ "\n";
		}
		
		return result;
		
	}
	
	public long getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	/*public List<Meal> getItem_array() {
		return Item_array;
	}

	public void setItem_array(List<Meal> item_array) {
		Item_array = item_array;
	}
	*/

	public double getTotal_price() {
		return price;
	}

	public void setTotal_price(double total_price) {
	     price = total_price;
	}

	/*public Runner getFk_runnerId() {
		return fk_runnerId;
	}

	public void setFk_runnerId(Runner fk_runnerId) {
		this.fk_runnerId = fk_runnerId;
	}
	*/

	public RestEntity getFk_restaurantId() {
		return restaurantId1;
	}

	public void setFk_restaurantId(RestEntity fk_restaurantId) {
		restaurantId1 = fk_restaurantId;
	}
	

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	public String getDate() {
		return date; 
	}

	public void setDate(String d) {
		date = d;
	}
	
    public List<Meal> getListofMeals() {
		
		return listMeals;
	}

	public void setListofMeals(List<Meal> listofMeals) {
		listMeals = listofMeals; 
	}
	/*public double total() {
		for(Meal m :Item_array)
		{
			total_price+=m.getPrice();
		}
		return total_price;
	}
	public double TotalPrice() {
		    double TotalSum=total();
			TotalSum+=fk_runnerId.getDelivery_fee();
		return TotalSum;
	}
*/

}
