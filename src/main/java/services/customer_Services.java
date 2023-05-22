package services;

import java.util.List;

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

import entities.Restaurant;

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
	
    
    
    ////////////////////////////////////////////////////////////////////
    
    
    
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

}
