package entities;

import java.util.ArrayList;
import java.util.List;
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
	
	@OneToMany(mappedBy="fk_OrderID",cascade = CascadeType.ALL)
	private List<Meal> Item_array; 
	
	private int total_price; 
	@ManyToOne
	@JoinColumn(name="RunnerId")
	private Runner fk_runnerId; 
	
	@ManyToOne
	@JoinColumn(name="Restid")
	private Restaurant fk_restaurantId; 
	private order_status_Enum os;
	
	
	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	/*public Set<Meal> getItem_array() {
		return Item_array;
	}

	public void setItem_array(Set<Meal> item_array) {
		Item_array = item_array;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public Runner getFk_runnerId() {
		return fk_runnerId;
	}

	public void setFk_runnerId(Runner fk_runnerId) {
		this.fk_runnerId = fk_runnerId;
	}

	public Restaurant getFk_restaurantId() {
		return fk_restaurantId;
	}

	public void setFk_restaurantId(Restaurant fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}

	public order_status_Enum getOs() {
		return os;
	}

	public void setOs(order_status_Enum os) {
		this.os = os;
	}

	*/


}
