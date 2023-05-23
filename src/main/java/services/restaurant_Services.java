package services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
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
public class restaurant_Services 
{
	            // get the EntityManager instance
				@PersistenceContext(unitName="SecondProject")
				private EntityManager em;  
							
			    /////////////////////////////////////////////////////////////////////////////////////////////////
					                                  //adds restaurant 
				@RolesAllowed("owner")
				@POST
				@Path("/AddRest")
				public String CreateRestaurant(Restaurant r)
				{
					RestEntity restE=new RestEntity();
					restE.setName(r.getName());
					restE.setRestid(r.getRestid());
					
						em.persist(r); 
						em.persist(restE);
						return "Restuarant added successfully"; 
				}
			    /////////////////////////////////////////////////////////////////////////////////////////////////
			    									//get Restaurant Info by ID 
				@PermitAll
			    @GET
				@Path("/getRestInfo/{id}")
				public String GetRestInfo(@PathParam("id") Long restaurantId) 
				{
					Restaurant rest=em.find(Restaurant.class, restaurantId); 
					if(rest==null) {
						 return "restaurant id is not found";
					}
					//TypedQuery<Meal> query = em.createQuery("SELECT NEW Meal(m.Mealid, m.name,m.price)  FROM Meal m ",Meal.class);
			    	
					return rest.printInfo(); //query.getResultList();  
				}
			    //----------------------------------------------------------------------------------------------------------------
			    					////get All Restaurant Info 
				@RolesAllowed("customer") 
			    @GET 
				@Path("/getALLRests")  
				public List<Restaurant> GetallRests() 
				{
			    	TypedQuery<Restaurant> query = em.createQuery("SELECT NEW Restaurant(r.Restid, r.name)  FROM Restaurant r ",Restaurant.class);
			    	
					return query.getResultList(); 	
				}
			    
			    ///////////////////////////////////////////////////////////////////////////////////////////////////
			    							//add restaurant's meal to Rest list (Create restaurant menu)
				@RolesAllowed("owner")
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
				@RolesAllowed("owner")
				@POST
				@Path("/deleteMeal/{id}/{Mealid}") 
				public String removeMeal(@PathParam("id") Long restaurantId,@PathParam("Mealid") Long MealId,Meal meal) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId); 
				    Meal m=em.find(Meal.class, MealId);
					
					//rest.getListofMeals().remove(meal.getMealid());
				    //rest.getListofMeals().remove(m);
					//em.remove(m);
					//em.flush(); 
				    m.setName("");
				    m.setPrice(0.0);
				    em.merge(m);
					
					//em.persist(rest);
				   // em.remove(em.merge(meal));
					//
				   // 
				    
				    
                   return "meal deleted Successfully ";	
				}
				///////////////////////////////////////////////////////////////////////////////////
				                          //edit meal in restaurant
				@RolesAllowed("owner")
				@POST
				@Path("/editMealForRest/{id}/{Mealid}") 
				public String editMeal(@PathParam("id") Long restaurantId,@PathParam("Mealid") Long MealId,Meal meal) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId); 
				    Meal m=em.find(Meal.class, MealId);
					
				    m.setName(meal.getName());
				    m.setPrice(meal.getPrice());
				    em.merge(m);
					
                   return "meal edited Successfully ";	
				}
				
				//////////////////////////////////////////////////////////////////////////////////
										//delete restaurant's menu
				@RolesAllowed("owner")
				@POST
				@Path("/deleteMenu/{id}") 
				public String removeMenu(@PathParam("id") Long restaurantId) 
				{
				    Restaurant rest=em.find(Restaurant.class, restaurantId);
					//rest.getListofMeals().clear();
					//em.flush(); 
					//em.persist(rest);
				    em.remove(rest);
                   return "menu deleted Successfully ";	
				}
				
				
				////////////////////////////////////////////////////////////////////////////////
									//gets Menu by restaurant id
				
				@PermitAll
				@GET
				@Path("/getMenu/{id}") 
				public String GetMenu(@PathParam("id") Long restaurantId) 
				{
				   Restaurant rest=em.find(Restaurant.class, restaurantId);
			       return rest.print(); 
				}
				
				////////////////////////////////////////////////////////////////////////////
			    
}
