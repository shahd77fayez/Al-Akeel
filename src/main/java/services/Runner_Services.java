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

import entities.custumerOrder;
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
	@RolesAllowed("owner")
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
	
	//////////////////////////////////////////////////////////////////
	
	@POST
	@Path("/RunnerOrder/{id}/{orderId}")     
    public String markOrderDelivered(@PathParam("id") long id , @PathParam("orderId") long orderID ,custumerOrder order) 
    {
    	Runner r= em.find(Runner.class,id);
    	custumerOrder o= em.find(custumerOrder.class,id);
    	
    
    	if(o.getOs().equals("delivered") || o.getOs().equals("canceled"))
    	{
			return "cant not mark a delivered or canceled order as completed";
		}
    	
		o.setOs("delivered");
		
		r.setCompletedTrips(r.getCompletedTrips()+1);
		r.getOrders_list().add(o);
		r.setStatus("available");
		em.merge(r);
		
		em.merge(o);  
		
		return "Runner:"+r.getName()+"   Completes:"+ r.getCompletedTrips();
	}

	

	
	/*
	

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
