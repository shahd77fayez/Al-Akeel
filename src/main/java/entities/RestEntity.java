package entities;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Stateless
@Entity
@Table(schema = "public") 
public class RestEntity 
{

	
   private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RID")
	private long Rid; 
	
	
	@OneToMany(mappedBy="restaurantId1",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private  List<custumerOrder> listofOrders;   
	
	////////////////////////////////////////////////////////////////////////
	public RestEntity()
	{
		
	}
	public RestEntity(long id,String n)
	{
		Rid=id;
		name=n;
	}
	
	public String printOrderById(int id) 
	{
		String result="";
		
		result+= "Order Date:"+listofOrders.get(id).getDate()+"      Order Status:"+listofOrders.get(id).getOs()+"      Meals:"+listofOrders.get(id).printMeals()+"     RestaurantName :"+getName()+"\n";
		
		return result;
	}
	
	
	public String print()
	{
		String result="";
		for(int i=0;i<listofOrders.size();i++)
		{
			result+= "Order Date:"+listofOrders.get(i).getDate()+"      Order Status:"+listofOrders.get(i).getOs()+"      Meals:"+listofOrders.get(i).printMeals()+"     RestaurantName :"+getName()+"\n";
		}
		return result;
	}
	
	public long getRestid() {
		return Rid;
	}

	public void setRestid(long restid) {
		Rid = restid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<custumerOrder> getListofOrders() {
		return listofOrders;
	}

	public void setListofOrders(List<custumerOrder> Orders) {
	    listofOrders =Orders;
	}
}
