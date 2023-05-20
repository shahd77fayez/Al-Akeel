package entities;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Meal 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int Mealid;
	
	 private String name;
	 
	 private double price;
	 
	 @ManyToOne
	 @JoinColumn(name="Restid")
	 private Restaurant fk_restaurantId;
	 
	 @ManyToOne
	 @JoinColumn(name="OrderId")
	 private Order fk_OrderID;

}
