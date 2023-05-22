package services;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Stateless
@Path("/Owner") 
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Restaurant_owner_Resource 
{
	Rest_owner_Repo rep;
	
}
