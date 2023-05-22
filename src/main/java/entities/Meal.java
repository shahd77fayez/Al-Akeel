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
	 
	 /*@Column(name = "restaurant_id")
	 private Long restaurantId;
	 */
	 @ManyToOne
	 @JoinColumn(name="restaurant_id" , referencedColumnName = "Restid", insertable = false, updatable = false)
	 private Restaurant fk_restaurant;
	 
	 @ManyToOne
	 @JoinColumn(name="OrderId")
	 private Order fk_OrderID;
	 
	  public int getMealid() 
	  {
		return Mealid;
	  }
	  public void setMealid(int mealid) 
	  {
		Mealid = mealid;
	  }
	  public String getName() 
	  {
		return name;
	  }
	  public void setName(String name) 
	  {
		this.name = name;
	  }
	  public double getPrice() 
	  {
		return price;
	  }
	  public void setPrice(double price) 
	  {
		this.price = price;
	  }
	  public Restaurant getFk_restaurantId() 
	  {
		return fk_restaurant;
	  }
	  public void setFk_restaurantId(Restaurant fk_restaurantId) 
	  {
		this.fk_restaurant = fk_restaurantId;
	  }
	  /*public Order getFk_OrderID() 
	  {
		 return fk_OrderID;
	  }
	  public void setFk_OrderID(Order fk_OrderID) 
	  {
		this.fk_OrderID = fk_OrderID;
	  }
	  */
}
