package com.ibm.wsc.rest;

import com.ibm.wsc.ejb.Was2CicsEjb;
import java.io.IOException;
import javax.ejb.EJB;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
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
@Transactional
public class Was2CicsService {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(Was2CicsService.class);

  @EJB(lookup = "was2CicsEjb")
  private Was2CicsEjb was2Cics;


  @GET
  public String callWas2CicsEjb(
      @PathParam("registerName") String registerName
      , @PathParam("serviceName") String serviceName
      , @QueryParam("i") String i)
      throws IOException {

    logger.info("Handling request with registerName [ {} ], serviceName [ {} ] and i [ {} ]", registerName,  serviceName, i);

    return was2Cics.driveIntoCics(registerName, serviceName, i);

  }
}
