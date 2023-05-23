package services;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
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

import entities.Order;
import entities.Restaurant;
import entities.Runner;
import entities.statusEnum;

@Stateless
@Path("/Customer") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"owner,customer"})
public class customer_Services
{

//    // get the EntityManager instance
//	@PersistenceContext(unitName="SecondProject")
//	private EntityManager em;  
//	
//	
//	
//    //////////////////////////////////////////////////////////////////
//	                        //Create Order
//	@POST
//	@Path("/AddOrder")
//	public String CreateOrder(Order r)
//	{
//	 em.persist(r); 
//	 return "Order is added successfully";
//	}
//    ////////////////////////////////////////////////////////////////////
//							//Find Runner
//	public void FindRunner()
//	{
//		// Find a random available runner from the database
//		TypedQuery<Runner> query = em.createQuery("SELECT r FROM Runner r WHERE r.Status = :status", Runner.class);
//		query.setParameter("status", statusEnum.available);
//		query.setMaxResults(1);
//		Runner runner = query.getSingleResult();
//	}
//	//////////////////////////////////////////////////////////////////////////////////////////////
//	// Create a new order object
//	/*Order order = new Order();
//	order.setFk_restaurantId(restaurant); // set the restaurant associated with the order
//	order.setFk_runnerId(runner); // set the runner associated with the order
//	order.setDate(new Date()); // set the order date to the current date
//	order.setOs(order_status_Enum.preparing); // set the order status to preparing*/
//	////////////////////////////////////////////////////////////////////////////////////////////////
//	
//	@GET
//	@Path("/OrderInfo")  
//	public List<Order> OrderDetails() 
//	{
//    	TypedQuery<Order> query = em.createQuery("SELECT NEW Order(r.fk_runnerId,r.total_price,r.Date) FROM Order r ",Order.class);
//    	return query.getResultList();	
//    	
//	}
//    
//    
//    			/////////////////////////////////////////////////////////////////////
//    
//    
//    
//    //////////////////////////////////////////////////////////////////////
//   /* TypedQuery<String> query = em.createQuery(
//    	    "SELECT r.name FROM Runner r " +
//    	    "JOIN Order o ON r.id = o.runner.id " +
//    	    "WHERE o.id = :orderId AND o.status = :status", String.class);
//    	query.setParameter("orderId", orderId);
//    	query.setParameter("status", OrderStatus.BUSY);
//    	String runnerName = query.getSingleResult();
//    	System.out.println("Runner name: " + runnerName);
//*/
}
