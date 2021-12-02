package service;

import model.Card;
import provider.CardProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Stateless
@Path("cards")
public class CardService {

    private final CardProvider provider;

    public CardService(){
        provider = new CardProvider();
    }

    @GET
    @Path("echo")
    public String echo(){
        return "echo";
    }

    @GET
    @Path("")
    @Produces("application/json")
    public Response getList(){
        try {
            ArrayList<Card> res = provider.getData();
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .entity(res).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .entity(e).build();
        }
    }

    @POST
    @Path("")
    @Consumes("application/json")
    public Response addUser(Card card){
        try {
            String o = provider.insert(card);
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(o).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(e).build();
        }
    }
    
    @PUT
    @Path("")
    @Consumes("application/json")
    public Response updateUser(Card card){
        try {
            String o = provider.update(card);
            return Response.status(200)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(o).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(e).build();
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") String id){
        try {
            String o = provider.delete(id+"");
            return Response.status(200).header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(o).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500)
                    .header("access-control-allow-origin", "*")
                    .header("access-control-allow-methods", "*")
                    .header("access-control-allow-headers", "*")
                    .entity(e).build();
        }
    }

    @OPTIONS
    @Path("{id}")
    public Response options(@PathParam("id") String id){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }

    @OPTIONS
    @Path("")
    public Response options(Card card){
        return Response.status(200)
                .header("access-control-allow-origin", "*")
                .header("access-control-allow-methods", "*")
                .header("access-control-allow-headers", "*")
                .build();
    }
}
