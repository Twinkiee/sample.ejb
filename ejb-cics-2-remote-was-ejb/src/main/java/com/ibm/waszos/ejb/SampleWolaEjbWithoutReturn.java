package com.ibm.waszos.ejb;

import com.ibm.websphere.ola.ExecuteHome;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJBException;
import javax.ejb.RemoteHome;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@RemoteHome(ExecuteHome.class)
public class SampleWolaEjbWithoutReturn {

  private static final Logger logger = LoggerFactory.getLogger(SampleWolaEjbWithoutReturn.class);

  public byte[] execute(byte[] arg0) {

    final String input;
    try {
      input = new String(arg0, "Cp1047");
      logger.info("Executing SampleWolaEjb EJB with input param [ {} ]", input);
      return new byte[0];
    } catch (UnsupportedEncodingException e) {
      logger.error("An error occurred while parsing the SampleWolaEjb input", e);
    }

    throw new EJBException("Invalid input");
  }
}
