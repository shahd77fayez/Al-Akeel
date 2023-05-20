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
	 private Restaurant fk_restaurantId;
	 private Order fk_OrderID;

}
