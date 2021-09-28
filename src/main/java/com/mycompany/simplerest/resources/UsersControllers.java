package com.mycompany.simplerest.resources;

import com.mycompany.simplerest.entities.User;
import com.mycompany.simplerest.repositories.UserRepository;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
@Path("users")
public class UsersControllers {

//  private @Context
//  UriInfo uriInfo;
//
//  private @QueryParam("name")
//  String __name;

  @GET
  public Response create(@QueryParam("name") String name, @QueryParam("age") int age, @QueryParam("sex") String sex) {
//    String name = this.uriInfo.getQueryParameters().get("name").get(0);
//    int age = Integer.parseInt(this.uriInfo.getQueryParameters().get("age").get(0));
//    String sex = this.uriInfo.getQueryParameters().get("sex").get(0);

    User user = new User();
    user.setAge(age);
    user.setName(name);
    user.setSex(sex);

    UserRepository userRepository = new UserRepository();
    try {
      userRepository.save(user);

      return Response
        .ok(user)
        .build();
    } catch (Exception e) {
      return Response
        .status(500, "Internal server error")
        .build();
    }
  }

  @GET
  @Path("{id}")
  public Response show(@PathParam("id") String id) {
    try {
      UserRepository userRepository = new UserRepository();

      return Response.ok(userRepository.findOne(id)).build();
    } catch (Exception e) {
      return Response
        .status(500, "Internal server error")
        .entity("{\"message\":\"Não foi possivel realizar o processo\"}")
        .build();
    }
  }

}
