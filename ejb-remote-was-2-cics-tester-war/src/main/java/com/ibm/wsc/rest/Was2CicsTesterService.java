package com.ibm.wsc.rest;

import com.ibm.wsc.service.Was2CicsService;
import java.io.IOException;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest service implementation class Was2CicsServlet
 */
@Path("/was2cicstester/{registerName}/{serviceName}")
public class Was2CicsTesterService {

  private static final Logger logger = LoggerFactory.getLogger(Was2CicsTesterService.class);

  @Inject
  private Was2CicsService was2CicsService;


  @GET
  @Transactional
  public String callwas2CicsEjb(
      @PathParam("registerName") String registerName
      , @PathParam("serviceName") String serviceName
      , @QueryParam("i") String i)
      throws IOException {

    logger.info("Handling request with params [ {} ]", i);

    return was2CicsService.callCics(registerName, serviceName, i);

  }
}
