package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-23T15:03:36.601+0200")
@StaticMetamodel(Order.class)
public class Order_ {
	public static volatile SingularAttribute<Order, Integer> OrderId;
	public static volatile SingularAttribute<Order, Integer> total_price;
	public static volatile SingularAttribute<Order, order_status_Enum> os;
	public static volatile SingularAttribute<Order, Runner> fk_runnerId;
	public static volatile ListAttribute<Order, Meal> Item_array;
	public static volatile SingularAttribute<Order, Integer> Date;
	public static volatile SingularAttribute<Order, Restaurant> fk_restaurantId2;
}
