package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.net.ssl.Status;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.Meal;
import entities.Order;
import entities.Restaurant;
import entities.order_status_Enum;

@Stateless
@Path("/Customer") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class customer_Services
{

    // get the EntityManager instance
	@PersistenceContext(unitName="SecondProject")
	private EntityManager em;  
	
	@POST
	public void createOrder(Restaurant restaurant, Order order){
		
		order.setFk_restaurantId(restaurant);
		order.setItem_array(items_List);
		order.getDate();
		order.TotalPrice();

		Runner runner= getAvailableRunner();
		runner.setStatus(Status.busy);
		em.persist(runner);

		order.setFk_runnerId(runner);
		order.setOs(order_status_Enum.preparing);
		em.persist(order);
		

	}

	public Runner getAvailableRunner(){
		for(Runner runner : runners){
			if(runner.getStatus() == Status.available){
				return runner;
			}
		}
		return null;
	}

	public void editOrder(Order order, Meal newMeal){
		if(order.getOs() == order_status_Enum.canceled){
			throw newRuntimeException("Order is canceled so it can not be edited");
		}
		if(order.getOs() != order_status_Enum.preparing){
			throw newRuntimeException("Order is not in the preparing state so it can not be edited");
		}
		order.getItem_array().add(newMeal);
		em.merge(order);
	}

	public order listOrdersByCustomerId(int UserId){
		User user=em.find(User.class, UserId);
		return user.print();
		
	}


    
    //get all restaurants with their info
    @GET
	@Path("/getALLRests")  
	public List<Restaurant> GetallRests() 
	{
    	TypedQuery<Restaurant> query = em.createQuery("SELECT r FROM Restaurant r ",Restaurant.class);
		return query.getResultList();	
	}
    
    
    //////////////////////////////////////////////////////////////////////

}
