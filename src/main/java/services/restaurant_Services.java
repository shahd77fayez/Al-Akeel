package services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import entities.*;


@Stateless
@Path("/Owner") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed({"owner,customer"})
public class restaurant_Services 
{
	            // get the EntityManager instance
				@PersistenceContext(unitName="SecondProject")
				private EntityManager em;  
							
			    /////////////////////////////////////////////////////////////////////////////////////////////////
					                                  //adds restaurant 
				@POST
				@Path("/AddRest")
				public String CreateRestaurant(Restaurant r)
				{
				em.persist(r); 
				return "Restuarant added successfully";
				}
			    /////////////////////////////////////////////////////////////////////////////////////////////////
			    									//get Restaurant Info by ID 
			    @GET
				@Path("/getRestInfo/{id}")
				public String GetRestInfo(@PathParam("id") Long restaurantId) 
				{
					Restaurant rest=em.find(Restaurant.class, restaurantId); 
					//TypedQuery<Meal> query = em.createQuery("SELECT NEW Meal(m.Mealid, m.name,m.price)  FROM Meal m ",Meal.class);
			    	
					return rest.printInfo(); //query.getResultList();  
				}
			    //----------------------------------------------------------------------------------------------------------------
			    					////get All Restaurant Info 
			    @GET
				@Path("/getALLRests")  
				public List<Restaurant> GetallRests() 
				{
			    	TypedQuery<Restaurant> query = em.createQuery("SELECT NEW Restaurant(r.Restid, r.name)  FROM Restaurant r ",Restaurant.class);
			    	
					return query.getResultList(); 	
				}
			    
			    ///////////////////////////////////////////////////////////////////////////////////////////////////
			    							//add restaurant's meal to Rest list (Create restaurant menu)
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
					em.merge(rest);
					
		            return "menu added Successfully ";	
				}
			    ///////////////////////////////////////////////////////////////////////////////////////////////////
											//delete restaurant's meal
				@DELETE
				@Path("/deleteMeal/{id}") 
				public String removeMeal(@PathParam("id") Long restaurantId,Meal meal) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId); 
					
					rest.getListofMeals().remove(meal.getMealid());
					
					
				   // em.remove(em.merge(meal));
					rest.getListofMeals().remove(meal);
				    em.flush(); 
				    
				    System.out.println("Rest Meals:"+rest.getListofMeals().get(0));
				    
                   return "meal deleted Successfully ";	
				}
				//////////////////////////////////////////////////////////////////////////////////
										//delete restaurant's menu
				@POST
				@Path("/deleteMenu/{id}") 
				public String removeMenu(@PathParam("id") Long restaurantId) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId);
					rest.getListofMeals().clear();
					em.flush(); 
					em.persist(rest);
                   return "menu deleted Successfully ";	
				}
				
				
				////////////////////////////////////////////////////////////////////////////////
									//gets Menu by restaurant id
				
				@GET
				@Path("/getMenu/{id}")
				public String GetMenu(@PathParam("id") Long restaurantId) 
				{
				   Restaurant rest=em.find(Restaurant.class, restaurantId);
			       return rest.print(); 
				}
			    
				////////////////////////////////////////////////////////////////////////////
			    
}
