package services;

import java.util.Set;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.*;
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
import entities.order_status_Enum;
import entities.statusEnum;

@Stateless
@Path("/Owner") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"runner,owner"})
public class Runner_Services
{
	@PersistenceContext(unitName="SecondProject")
	private EntityManager em;  
	/////////////////////////////////////////////////////////////////
	                     //add runner
	@POST
	@Path("/AddRunner")
	public String CreateRunner(Runner r)
	{
	em.persist(r); 
	return "Runner added successfully";
	
	}
	
	
	/////////////////////////////////////////////////////////////////
	 						//get runner info
	
	@GET 
	@Path("/getRunnerInfo/{id}")
	public String GetRestInfo(@PathParam("id") Long runnerId) 
	{
		Runner runner=em.find(Runner.class, runnerId);  
		return runner.printInfo();  
	}
	
	/////////////////////////////////////////////////////////////////
	@POST
	@Path("/RunnerOrder/{id}") 
    public String markOrderDelivered(@PathParam("id") long id ,Order order)
    {
    	Runner r= em.find(Runner.class , id);
    	 
    	if(order.getOs() == order_status_Enum.delivered || order.getOs() == order_status_Enum.canceled ){
			throw new IllegalStateException("cant not mark a delivered or canceled order as completed");
		}
		order.setOs(order_status_Enum.delivered);
		
		r.setCompletedTrips(r.getCompletedTrips()+1);
		em.persist(r);
		em.persist(order);
		
		return "Runner "+r.getName()+" Completes "+ r.getCompletedTrips();
	}
	//////////////////////////////////////////////////////////////////////////////////////
	/*@Path("/CompletedTrips/{id}")
	public int getCompletedTrips(@PathParam("id") long id)
	{
		Runner r= em.find(Runner.class , id);
		int counter = 0;
		for(Order order : r.getOrders_list())
		{
			if(order.getOs()==order_status_Enum.delivered);
			{
				counter++;
			}
		}
		return counter;
	}*/
	

}
