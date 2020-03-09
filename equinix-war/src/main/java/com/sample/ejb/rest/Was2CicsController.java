package wsc.rest;

import com.ibm.wsc.service.Was2CicsService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest service implementation class Was2CicsServlet
 */
@Path("/was2cics/{registerName}/{serviceName}")
public class Was2CicsController {

  private static final Logger logger = LoggerFactory.getLogger(Was2CicsController.class);

  @Inject
  private Was2CicsService was2CicsService;

  @GET
  public String callWas2CicsEjb (
      @PathParam("registerName") String registerName
      , @PathParam("serviceName") String serviceName
      , @QueryParam("i") String i) {

    logger.info("Handling request with registerName [ {} ], serviceName [ {} ] and i [ {} ]",
        registerName, serviceName, i);

    try {
      return was2CicsService.callCics(registerName, serviceName, i);
    } catch (Exception e) {
      logger.error("An error occurred while performing cics call", e);
      throw new IllegalStateException(e);
    }
  }
}
