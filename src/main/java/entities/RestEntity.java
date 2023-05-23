package entities;

import java.util.List;

import javax.ejb.Stateless;
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
	@Column(name = "restIDD")
	private long Restid; 

	
	@OneToMany(mappedBy="fk_restaurantId2",fetch = FetchType.EAGER)
	private  List<Order> listofOrders;
	
	////////////////////////////////////////////////////////////////////////
	public RestEntity()
	{
		
	}
	public RestEntity(long id,String n)
	{
		Restid=id;
		name=n;
	}
	
	public String printInfo()
	{
		String result="";
		
		result+="name: "+getName()+ "     RestaurantID:"+getRestid()+"Meals:"+print()+"\n";
		
		
		return result;
		
	}
	
	public String print()
	{
		String result="";
		for(int i=0;i<listofOrders.size();i++)
		{
			result+="Order id: "+listofOrders.get(i).getOrderId()+ "     Date:"+listofOrders.get(i).getDate()+ "     RestaurantID:"+getRestid()+"\n";
		}
		
		return result;
		
	}
	
	public long getRestid() {
		return Restid;
	}

	public void setRestid(long restid) {
		Restid = restid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	public List<Order> getListofOrders() {
		return listofOrders;
	}

	public void setListofOrders(List<Order> listofOrders) {
		this.listofOrders = listofOrders;
	}


}
