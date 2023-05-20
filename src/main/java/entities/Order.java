package entities;

import java.util.ArrayList;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int OrderId;
	
	@OneToMany(mappedBy="fk_OrderID")
	private Set<Meal> Item_array; 
	
	private int total_price; 
	@ManyToOne
	@JoinColumn(name="RunnerId")
	private Runner fk_runnerId; 
	
	@ManyToOne
	@JoinColumn(name="Restid")
	private Restaurant fk_restaurantId; 
	
	private order_status_Enum os;
}
