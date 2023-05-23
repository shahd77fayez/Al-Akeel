package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-23T15:03:36.604+0200")
@StaticMetamodel(Restaurant.class)
public class Restaurant_ { 
	public static volatile SingularAttribute<Restaurant, Long> Restid;
	public static volatile SingularAttribute<Restaurant, String> name;
	public static volatile SingularAttribute<Restaurant, User> OwnerID;
	public static volatile ListAttribute<Restaurant, Meal> listofMeals;
	public static volatile ListAttribute<Restaurant, Order> listofOrders;
}
