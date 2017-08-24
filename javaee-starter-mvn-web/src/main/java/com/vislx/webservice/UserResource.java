/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vislx.webservice;


import com.vislx.javaee.starter.mvn.classlib.entity.UserEntity;
import com.vislx.javaee.starter.mvn.classlib.local_interface.UserSessionBeanLocal;
import com.vislx.webservice.util.ResponseBodyBuilder;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author victor
 */
@Path("user")
@RequestScoped
public class UserResource {

    @Context
    private UriInfo context;
    
    @Inject
    private UserSessionBeanLocal user_sb;

    public UserResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUser() {
        try{
            List<UserEntity> resultList = user_sb.getAllUser();
            return Response.ok(ResponseBodyBuilder.buildList(resultList)).build();
        } catch (Exception ex){
            return Response.ok(ResponseBodyBuilder.buildMessage(400, "find all user failed")).build();
        }
    }
    
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByUsername(@PathParam("username") String username) {
        try{
            UserEntity result = user_sb.getUserByUsername(username);
            return Response.ok(ResponseBodyBuilder.buildObject(result)).build();
        } catch (Exception ex){
            return Response.ok(ResponseBodyBuilder.buildMessage(400, "find user failed")).build();
        }
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser() {
        try{
            String time = String.valueOf(new Date().getTime());
            String username = "random" + time;
            String email = time + "@random.com";
            UserEntity u = user_sb.createUser(username, email);
            return Response.ok(ResponseBodyBuilder.buildObject(u)).build();
        } catch (Exception ex){
            ex.printStackTrace();
            return Response.ok(ResponseBodyBuilder.buildMessage(400, "create user failed")).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(String content) {
        return Response.ok(ResponseBodyBuilder.buildMessage(400, "not support yet")).build();
    }
    
    @DELETE
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserbyUsername(@PathParam("username") String usernam) {
        try{
            user_sb.deleteUserByUsername(usernam);
            return Response.ok("delete successfully!").build();
        }catch (Exception ex){
            return Response.ok(ResponseBodyBuilder.buildMessage(400, "delete user failed")).build();
        }
    }
}
