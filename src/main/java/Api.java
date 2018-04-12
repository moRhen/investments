import pojo.InvestInput;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/")
public class Api {

    @EJB
    private Invest invest;

    @POST
    @Path("/invest")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response locateInvestments(InvestInput investInput){
        return Response.ok(invest.investFoundsByStyle(investInput), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
