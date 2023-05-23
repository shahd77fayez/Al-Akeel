package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-23T15:03:36.607+0200")
@StaticMetamodel(Runner.class)
public class Runner_ {
	public static volatile SingularAttribute<Runner, Integer> RunnerId;
	public static volatile SingularAttribute<Runner, String> name;
	public static volatile SingularAttribute<Runner, Double> delivery_fee;
	public static volatile SingularAttribute<Runner, Integer> completedTrips;
	public static volatile SingularAttribute<Runner, statusEnum> Status;
	public static volatile ListAttribute<Runner, Order> Orders_list;
}
