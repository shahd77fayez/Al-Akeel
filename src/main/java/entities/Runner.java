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
	
	/*@OneToMany(mappedBy="fk_runnerId")
	private Set<Order> Orders_list;
	
	*/
	public int getRunnerId() {
		return RunnerId;
	}

	public void setRunnerId(int runnerId) {
		RunnerId = runnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public statusEnum getStatus() {
		return Status;
	}

	public void setStatus(statusEnum status) {
		Status = status;
	}

	public double getDelivery_fee() {
		return delivery_fee;
	}

	public void setDelivery_fee(double delivery_fee) {
		this.delivery_fee = delivery_fee;
	}

	/*public Set<Order> getOrders_list() {
		return Orders_list;
	}

	public void setOrders_list(Set<Order> orders_list) {
		Orders_list = orders_list;
	}
*/

}
