package services;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.custumerOrder;
import entities.Meal;
import entities.RestEntity;
import entities.Restaurant;
import entities.Runner;
import entities.statusEnum;

@Stateless
@Path("/Customer") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class customer_Services
{

    // get the EntityManager instance
	@PersistenceContext(unitName="SecondProject")
	private EntityManager em; 
	
    //////////////////////////////////////////////////////////////////
	                        //Create Order
	@RolesAllowed("customer")
	@POST
	@Path("/AddOrder/{id}") 
	public String CreateOrder(@PathParam("id") Long restaurantId ,custumerOrder o) 
	{
	       RestEntity rest=em.find(RestEntity.class, restaurantId);
			if (rest == null) { 
	           return "restaurant id is not found";
	       }
			
			o.setFk_restaurantId(rest);
			
			em.persist(o);
			rest.getListofOrders().add(o);
			em.merge(rest);
						
         return "Order Created Successfully ";	
	 
	}
	
	@RolesAllowed("customer")
	@POST
	@Path("/AddMealToOrder/{id}") 
	public String addMeal(@PathParam("id") Long OrderId ,Meal meal) 
	{
		custumerOrder order=em.find(custumerOrder.class, OrderId);
			if (order == null) { 
	           return "Order id is not found";
	       } 
			
			
		meal.setFk_OrderID(order);	
		em.persist(meal);
			
		order.getListofMeals().add(meal);
		em.merge(order); 
        return "meal added to  order  Successfully ";	
	 
	}
    ////////////////////////////////////////////////////////////////////
	             //get order by id
	@PermitAll
	@GET
	@Path("/getOrder/{id}") 
	public String GetOrder(@PathParam("id") Long restaurantId) 
	{
	   RestEntity rest=em.find(RestEntity.class, restaurantId);
       return rest.print(); 
	} 
	   
	/////////////////////////////////////////////////////////////////////
	                           
	@PermitAll
	@POST
	@Path("/EditOrder/{orderId}/{mealId}")  
    public String EditOrder(@PathParam("orderId") long OrderId,@PathParam("mealId") long MealId,Meal m) 
	{
	       custumerOrder order=em.find(custumerOrder.class, OrderId); 
	       Meal meal=em.find(Meal.class,MealId);
	       
		   if(order.getOs().equals("canceled"))
		   {
			   return "order already canceled"; 
		   }
		   
		   if(order.getOs().equals("delivered"))
		   {
			   return "order already delivered";
		   }
		   if(!order.getOs().equals("canceled") &&  !order.getOs().equals("delivered") && !order.getOs().equals("preparing"))
		   {
			   return "wrong order status";
		   }
		   if(order.getOs().equals("preparing"))
		   {
			   meal.setName(m.getName());
			   meal.setPrice(m.getPrice());
			   em.merge(meal);
		       
	       }
		   
           return "edited successfully"; 
	}
    
    
    			/////////////////////////////////////////////////////////////////////
    
}
