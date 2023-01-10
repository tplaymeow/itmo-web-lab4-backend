package com.tplaymeow.itmoweblab4backend.Rest;

import com.tplaymeow.itmoweblab4backend.Beans.ResultsBean;
import com.tplaymeow.itmoweblab4backend.Models.CheckResponse;
import com.tplaymeow.itmoweblab4backend.Models.Coordinates;
import com.tplaymeow.itmoweblab4backend.Models.Result;
import com.tplaymeow.itmoweblab4backend.Rest.AuthFilter.Secured;
import com.tplaymeow.itmoweblab4backend.Rest.AuthFilter.UserPrincipal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Stateless
@Path("/results")
public class ResultsResource {
    @EJB
    private ResultsBean resultsBean;

    @Secured
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResults(
            @Context SecurityContext securityContext
    ) {
        UserPrincipal user = (UserPrincipal) securityContext.getUserPrincipal();
        List<Result> results = resultsBean.getResults(user);
        return Response.ok().entity(results).build();
    }

    @Secured
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkCoordinates(
            @Context SecurityContext securityContext,
            Coordinates coordinates
    ) {
        UserPrincipal user = (UserPrincipal) securityContext.getUserPrincipal();
        CheckResponse response = resultsBean.check(coordinates, user);
        return Response.ok().entity(response).build();
    }
}
