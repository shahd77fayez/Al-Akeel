package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-23T15:03:36.528+0200")
@StaticMetamodel(Meal.class)
public class Meal_ {
	public static volatile SingularAttribute<Meal, Long> Mealid;
	public static volatile SingularAttribute<Meal, String> name;
	public static volatile SingularAttribute<Meal, Double> price;
	public static volatile SingularAttribute<Meal, Order> fk_OrderID;
	public static volatile SingularAttribute<Meal, Restaurant> fk_restaurantId1;
}
