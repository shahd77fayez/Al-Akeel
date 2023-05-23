package entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Order 
{
	private int total_price; 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="OrderID")
	private int OrderId;
	
	private int Date;

	@Enumerated(EnumType.STRING)
	private order_status_Enum os;
	
	/*@OneToMany(mappedBy="fk_OrderID",fetch=FetchType.EAGER)
	private List<Meal> Item_array;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RunnerID")
	private Runner fk_runnerId;   
	*/
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="restIDD")
	private Restaurant fk_restaurantId2; 
	
	///////////////////////////////////////////////////////////
	public Order() {}
 
	public Order(int p,int date)
	{
		
		total_price=p;
		Date=date;
	}
	
	
	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	/*public List<Meal> getItem_array() {
		return Item_array;
	}

	public void setItem_array(List<Meal> item_array) {
		Item_array = item_array;
	}
	*/

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	/*public Runner getFk_runnerId() {
		return fk_runnerId;
	}

	public void setFk_runnerId(Runner fk_runnerId) {
		this.fk_runnerId = fk_runnerId;
	}
	*/

	public Restaurant getFk_restaurantId() {
		return fk_restaurantId2;
	}

	public void setFk_restaurantId(Restaurant fk_restaurantId) {
		this.fk_restaurantId2 = fk_restaurantId;
	}

	public order_status_Enum getOs() {
		return os;
	}

	public void setOs(order_status_Enum os) {
		this.os = os;
	}
	public int getDate() {
		return Date;
	}

	public void setDate(int date) {
		Date = date;
	}
	/*public double total() {
		for(Meal m :Item_array)
		{
			total_price+=m.getPrice();
		}
		return total_price;
	}
	public double TotalPrice() {
		    double TotalSum=total();
			TotalSum+=fk_runnerId.getDelivery_fee();
		return TotalSum;
	}
*/

}
