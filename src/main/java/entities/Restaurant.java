package entities;

import java.util.ArrayList;
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
	private int Restid;
	
	private String name;
	
	private String OwnerID;
	
	@OneToMany(mappedBy="fk_restaurantId")
	private  Set<Meal> listofMeals;

	private  Set<Order> listofOrders;
}
