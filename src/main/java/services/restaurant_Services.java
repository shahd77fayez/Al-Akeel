package services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import entities.*;


@Stateless
@Path("/Owner") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class restaurant_Services 
{
	             // get the EntityManager instance
				@PersistenceContext(unitName="SecondProject")
				private EntityManager em;  
							
			    //////////////////////////////////////////////////////////////////
				
			    //adds restaurant
			    @POST
				@Path("/AddRest")
				public String CreateRestaurant(Restaurant r)
				{
					em.persist(r); 
					return "Restuarant added successfully";
				}
			    
	            ////////////////////////////////////////////////////////////////////
			    
			    //get Restaurant Info by ID 
			    @GET
				@Path("/getRestInfo/{id}")
				public Restaurant GetRestInfo(@PathParam("id") Long restaurantId) 
				{
					Restaurant rest=em.find(Restaurant.class, restaurantId); 
					return rest;
				}
			    
			    /////////////////////////////////////////////////////////////////////
			    
			    //get all restaurants with their info
			    @GET
				@Path("/getALLRests")  
				public List<Restaurant> GetallRests() 
				{
			    	TypedQuery<Restaurant> query = em.createQuery("SELECT r FROM Restaurant r ",Restaurant.class);
					return query.getResultList();	
				}
			    
			    
			    //////////////////////////////////////////////////////////////////////
			    
			    //add restaurant's meal
				@POST
				@Path("/restMeal/{id}")
				public String AddMeal(@PathParam("id") Long restaurantId,Meal meal) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId);
					if (rest == null) {
			            return "restaurant id is not found";
			        }
					
					meal.setFk_restaurantId(rest);
					
					em.persist(meal);
					rest.getListofMeals().add(meal);
					
                   return "menu added Successfully ";	
				}
				
				/////////////////////////////////////////////////////////////////////////////
				
				//delete restaurant's meal
				@POST
				@Path("/deleteMenu/{id}")
				public String removeMenu(@PathParam("id") Long restaurantId,Meal meal) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId);
					meal.setFk_restaurantId(rest);
					
					rest.getListofMeals().clear();
					
                   return "menu deleted Successfully ";	
				}
				////////////////////////////////////////////////////////////////////////////
				@GET
				@Path("/getMenuu/{id}")
				public List<Meal> GetMenuByid(@PathParam("id") Long restaurantId) 
				{
			    	TypedQuery<Meal> query =em.createQuery("SELECT m from Meal m where m.fk_restaurant.Restid=:rest", Meal.class); 
			        query.setParameter("rest", restaurantId);
			        return query.getResultList();
				}
				
				
				////////////////////////////////////////////////////////////////////////////
				
				 //gets Menu by restaurant id
			    @GET
				@Path("/getMenu/{id}")
				public List<Meal> GetMenuByID(@PathParam("id") Long restaurantId) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId);
				    
			       return rest.getListofMeals(); 
				}
			    ////////////////////////////////////////////////////////////////////////////
			    @GET
				@Path("/getMenu/{id}")
			    public double restaurantReport(@PathParam("id") Long restId) 
			    {
			    	Order r=em.find(Order.class, restId);
			    	double Total=1000;
			    	return Total;
			    }
			    
			    
			    
	
	
	
	
	
	
	
	

			    
			    
			    
	
	
	
//	            // get the EntityManager instance
//				@PersistenceContext(unitName="SecondProject")
//				private EntityManager em;  
//							
//			    //////////////////////////////////////////////////////////////////
//				
//			    //adds restaurant
//			    @POST
//				@Path("/AddRest")
//				public String CreateRestaurant(Restaurant r)
//				{
//					em.persist(r); 
//					return "Restuarant added successfully";
//				}
//			    
//	            ////////////////////////////////////////////////////////////////////
//			    
//			    //get Restaurant Info by ID 
//			    @GET
//				@Path("/getRestInfo/{id}")
//				public Restaurant GetRestInfo(@PathParam("id") Long restaurantId) 
//				{
//					Restaurant rest=em.find(Restaurant.class, restaurantId); 
//					return rest;
//				}
//			    
//			    /////////////////////////////////////////////////////////////////////
//			    
//			    //get all restaurants with their info
//			    @GET
//				@Path("/getALLRests")  
//				public List<Restaurant> GetallRests() 
//				{
//			    	TypedQuery<Restaurant> query = em.createQuery("SELECT r FROM Restaurant r ",Restaurant.class);
//					return query.getResultList();	
//				}
//			    
//			    
//			    //////////////////////////////////////////////////////////////////////
//			    
////			    //add restaurant's meal
////				@POST
////				@Path("/restMeal/{id}")
////				public String AddMeal(@PathParam("id") Long restaurantId,Meal meal) 
////				{
////				    Restaurant rest=em.find(Restaurant.class, restaurantId);
////					if (rest == null) {
////			            return "restaurant id is not found";
////			        }
////					
////					meal.setFk_restaurantId(rest);
////					
////					em.persist(meal);
////					rest.getListofMeals().add(meal);
////					
////		            return "menu added Successfully ";	
////				}
//			    
//			    
//			    
//			   
//			    
//			  //add restaurant's meal
//				@POST
//				@Path("/restMeal")
//				public String AddMeal(Meal meal) 
//				{
//					em.persist(meal);
//		            return "menu added Successfully ";	
//				}
//				
//				
//				@GET
//				@Path("/restMealAll")
//			    @Produces(MediaType.APPLICATION_JSON) 
//			    public List<Meal> getAllMeals() {
//			        TypedQuery<Meal> query = em.createQuery("SELECT m FROM Meal m JOIN FETCH m.fk_restaurant", Meal.class);
//			        List<Meal> meals = query.getResultList();
//			        return meals;
//			    }
//				
//				/////////////////////////////////////////////////////////////////////////
//			    
////			    //gets Menu by restaurant id
////			    @GET
////				@Path("/getMenuu/{id}")
////				public List<Meal> GetMenuByID(@PathParam("id") Long restaurantId) 
////				{
////			    	TypedQuery<Meal> query =em.createQuery("SELECT m from Meal m where m.fk_restaurant.Restid=:rest", Meal.class); 
////			        query.setParameter("rest", restaurantId);
////			        return query.getResultList();
////				}
//			    
//				
//				////////////////////////////////////////////////////////////////////////////
//				
//				 //gets Menu by restaurant id
//			    @GET
//				@Path("/getMenu/{id}")
//				public List<Meal> GetMenuByID(@PathParam("id") Long restaurantId) 
//				{
//				    Restaurant rest=em.find(Restaurant.class, restaurantId);
//				    
//			       return rest.getListofMeals(); 
//				}
//			    
//			
}
