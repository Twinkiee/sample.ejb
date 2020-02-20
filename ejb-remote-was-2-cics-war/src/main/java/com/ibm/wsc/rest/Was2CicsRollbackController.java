package com.ibm.wsc.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibm.wsc.service.Was2CicsService;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest service implementation class Was2CicsServlet
 */
@Path("/was2cics-rollback/{registerName}/{serviceName}")
//@Transactional
public class Was2CicsRollbackController {

  private static final Logger logger = LoggerFactory.getLogger(Was2CicsRollbackController.class);

  @Inject
  private Was2CicsService was2CicsService;

  @Resource
  private UserTransaction tx;
  //  @Resource(lookup = "db2XaDs")
//  private DataSource dataSource;

  @GET
  public String callWas2CicsEjb(
      @PathParam("registerName") String registerName
      , @PathParam("serviceName") String serviceName
      , @QueryParam("i") String i) {

    logger.info("Handling request with registerName [ {} ], serviceName [ {} ] and i [ {} ]",
        registerName, serviceName, i);

    try /*(final Connection connection = dataSource.getConnection())*/ {

      tx.begin();

      final String returnValue = was2CicsService.callCics(registerName, serviceName, i);

      logger.info("Remote EJB returned value [ {} ]", returnValue);

      if (i.length() > 0) {
        throw new RuntimeException("Custom exception raised to test EJB rollback!\n"
            + "EJB returned object:\n"
            + returnValue);
      }

      tx.commit();
    } catch (HeuristicMixedException | HeuristicRollbackException | RollbackException | SystemException | NotSupportedException | JsonProcessingException e) {
      logger.error("Exception while invoking remote EJB", e);
    }

    return "No custom exception thrown! Maybe you forgot to insert a non-empty \"i\" query param or another handled exception was thrown. Please check the application logs.";
  }
}
