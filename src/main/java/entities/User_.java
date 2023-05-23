package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-05-23T15:03:36.610+0200")
@StaticMetamodel(User.class)
public class User_ {
	public static volatile SingularAttribute<User, Integer> UserId;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, RolesEnum> role;
	public static volatile SingularAttribute<User, Restaurant> RestOwner;
}
