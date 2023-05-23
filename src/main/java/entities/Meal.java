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
	@Column(name="MealID")
	 private long Mealid;
	
	 private String name;
	 
	 private double price;
	 
	 @ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="restID") 
	 private Restaurant fk_restaurantId1;
	 
	 /*@ManyToOne(fetch=FetchType.EAGER)
	 @JoinColumn(name="OrderID")
	 private Order fk_OrderID;
	 */
	 ///////////////////////////////////////////////////////////////
	 public Meal()
		{
			
		}
		public Meal(long id,String n,double p)
		{
			Mealid=id;
			name=n;
			price=p;
		}
	  public long getMealid() 
	  {
		return Mealid;
	  }
	  public void setMealid(long mealid) 
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
		return fk_restaurantId1;
	  }
	  public void setFk_restaurantId(Restaurant fk_restaurantId) 
	  {
		this.fk_restaurantId1 = fk_restaurantId;
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
