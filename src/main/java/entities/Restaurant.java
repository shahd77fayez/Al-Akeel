package entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Restaurant 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Restid; 
	
	private String name;
	/*
	@OneToOne
	@JoinColumn(name="UserId")
	private User OwnerID;
	*/
	@OneToMany(mappedBy="fk_restaurant",fetch = FetchType.EAGER)
	private  List<Meal> listofMeals;
	/*
	@OneToMany(mappedBy="fk_restaurantId")
	private  Set<Order> listofOrders;
	*/
	public Restaurant()
	{
		
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

	/*public User getOwnerID() {
		return OwnerID;
	}

	public void setOwnerID(User ownerID) {
		OwnerID = ownerID;
	}
*/
	public List<Meal> getListofMeals() {
		return listofMeals;
	}

	public void setListofMeals(List<Meal> listofMeals) {
		this.listofMeals = listofMeals;
	}
/*
	public Set<Order> getListofOrders() {
		return listofOrders;
	}

	public void setListofOrders(Set<Order> listofOrders) {
		this.listofOrders = listofOrders;
	}

*/	
}
