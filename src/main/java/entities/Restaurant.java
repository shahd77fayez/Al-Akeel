package entities;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Restaurant 
{
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restID")
	private long Restid; 
	
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="UserID")
	private User OwnerID;
	
	
	@OneToMany(mappedBy="fk_restaurantId1",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private  List<Meal> listofMeals;
	
	
	////////////////////////////////////////////////////////////////////////
	public Restaurant()
	{
		
	}
	public Restaurant(long id,String n)
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
		for(int i=0;i<listofMeals.size();i++)
		{
			result+="Meal name: "+listofMeals.get(i).getName()+  "     price:"+listofMeals.get(i).getPrice()+ "     RestaurantID:"+getRestid()+"\n";
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

	public User getOwnerID() {
		return OwnerID;
	}

	public void setOwnerID(User ownerID) {
		OwnerID = ownerID;
	}

	public List<Meal> getListofMeals() {
		
		return listofMeals;
	}

	public void setListofMeals(List<Meal> listofMeals) {
		this.listofMeals = listofMeals;
	}
}
