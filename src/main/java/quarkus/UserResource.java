package quarkus;

import io.github.BielGG9.quarkus.domain.model.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    public Response createUser(@Valid CreateUserRequest userRequest){

        User user = new User();
        user.setAge(userRequest.getAge());
        user.setName(userRequest.getname());

        user.persist();

       return Response.ok().build();
    }
    @GET
    public Response listAllUsers(){
        PanacheQuery<User> query = User.findAll();
        return Response.ok(query.list()).build();
    }
    @DELETE
    @Path("{idUser}")
    @Transactional
    public Response deleteUser(@PathParam("idUser") Long id) {
        User user = User.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            user.delete();
            return Response.ok().build();
        }
    }

    @PUT
    @Path("{idUser}")
    @Transactional
    public Response updateUser(@PathParam("idUser") Long id, CreateUserRequest userData) {
        User user = User.findById(id);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            user.setAge(userData.getAge());
            user.setName(userData.getname());
            return Response.ok().build();
        }
    }
}
