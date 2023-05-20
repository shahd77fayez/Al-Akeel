package entities;

import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Runner 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int RunnerId;
	private String name;
	private statusEnum  Status;
	private double delivery_fee;
	private Set<Order> Orders_list;

}
