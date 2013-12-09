package com.guangbo.web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.guangbo.web.ejb.UserBean;
import com.guangbo.web.model.User;

@Path("/users")
public class UserRESTService {

	@EJB
	private UserBean us;
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response findAll(@Context UriInfo uriInfo) {
	    List<User> users = null;
		MultivaluedMap<String, String> queryParameters =uriInfo.getQueryParameters();
    	if(queryParameters.containsKey("index") && queryParameters.containsKey("max"))
    	{
    		Integer index = Integer.parseInt(queryParameters.getFirst("index"))-1;
    		Integer max = Integer.parseInt(queryParameters.getFirst("max"));
    		users = us.findAllInPagin(index, max);
    	}
    	else
    	{
	    	users = us.findAll();
    	}
    	return Response.ok(users).build();
    }
    
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response lookupUserById(@PathParam("id") long id) {
        User user = us.findById(id);
        if (user == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(user).build();
    }
    
    /**
     * Creates a new member from the values provided. Performs validation, and will return a JAX-RS response with either 200 ok,
     * or with a map of fields, and related errors.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user) {

        Response.ResponseBuilder builder = null;
//
//        try {
//            // Validates member using bean validation
//            validateMember(member);
//
//            registration.register(member);
//
//            // Create an "ok" response
//            builder = Response.ok();
//        } catch (ConstraintViolationException ce) {
//            // Handle bean validation issues
//            builder = createViolationResponse(ce.getConstraintViolations());
//        } catch (ValidationException e) {
//            // Handle the unique constrain violation
//            Map<String, String> responseObj = new HashMap<String, String>();
//            responseObj.put("email", "Email taken");
//            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
//        } catch (Exception e) {
//            // Handle generic exceptions
//            Map<String, String> responseObj = new HashMap<String, String>();
//            responseObj.put("error", e.getMessage());
//            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
//        }

        return builder.build();
    }
    
    /**
     * Checks if a member with the same email address is already registered.
     * @param email The email to check
     * @return True if the email already exists, and false otherwise
     */
    public boolean emailAlreadyExists(String email) {
        User user = null;
        try {
            user = us.findByEmail(email);
        } catch (NoResultException e) {
            // ignore
        }
        return user != null;
    }
}
