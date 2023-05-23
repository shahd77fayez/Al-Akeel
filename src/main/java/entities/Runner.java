package entities;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
@Entity
@Table(schema = "public") 
public class Runner 
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RunnerID")
	private int RunnerId;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private statusEnum  Status;

	private int completedTrips;
	
	//////////////////////////////////////////////////////

	
	private double delivery_fee;
	
	/*@OneToMany(mappedBy="fk_runnerId")
	private List<Order> Orders_list;
	*/
	public Runner(){
	}

	public Runner(String name){
		this.name = name;
		this.completedTrips = 0;
		this.Status = statusEnum.available;

	}
	public int getCompletedTrips() {
		return completedTrips;
	}

	public void setCompletedTrips(int completedTrips) {
		this.completedTrips = completedTrips;
	}
	public String printInfo()
	{
		String result="";
		
		result+="name: "+getName()+ "     Runner ID:"+getRunnerId()+"\n";
		
		
		return result;
		
	}

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

	/*public List<Order> getOrders_list() {
		return Orders_list;
	}

	public void setOrders_list(List<Order> orders_list) {
		Orders_list = orders_list;
	}
	*/
	public void setStatusAvailable(){
		this.Status = statusEnum.available;
	}

}
