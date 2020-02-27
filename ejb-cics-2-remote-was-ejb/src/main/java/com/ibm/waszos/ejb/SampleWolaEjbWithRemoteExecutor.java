package com.ibm.waszos.ejb;

import com.ibm.ejb.api.RemoteExecutorEjb;
import com.ibm.websphere.ola.ExecuteHome;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.RemoteHome;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@RemoteHome(ExecuteHome.class)
public class SampleWolaEjbWithRemoteExecutor {

  private static final Logger logger = LoggerFactory.getLogger(SampleWolaEjbWithRemoteExecutor.class);

  @EJB(lookup = "sampleWolaRemoteEjbExecutor")
  private RemoteExecutorEjb remoteExecutor;

  public byte[] execute(byte[] arg0) {

    final String input;
    try {
      input = new String(arg0, "Cp1047");
      logger.info("Executing SampleWolaEjbWithRemoteExecutor EJB with input param [ {} ]", input);

      final byte[] returnValue = remoteExecutor.execute(arg0);

      logger.info("SampleWolaEjbWithRemoteExecutor EJB executed; return value [ {} ]", input);
      return returnValue;
    } catch (UnsupportedEncodingException e) {
      logger.error("An error occurred while parsing the SampleWolaEjb input", e);
    }

    throw new EJBException("Invalid input");
  }
}
