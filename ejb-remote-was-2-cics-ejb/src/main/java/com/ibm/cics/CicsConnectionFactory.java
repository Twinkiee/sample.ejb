package com.ibm.cics;

import com.ibm.AutoClosableConnection;
import com.ibm.websphere.ola.ConnectionSpecImpl;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.resource.ResourceException;
import javax.resource.cci.ConnectionFactory;

@ApplicationScoped
public class CicsConnectionFactory {


  @Resource(lookup = "eis/ola_0019", type = ConnectionFactory.class)
  private ConnectionFactory cf0019;
  @Resource(lookup = "is/ola_0062", type = ConnectionFactory.class)
  private ConnectionFactory cf0062;

  public AutoClosableConnection getConnection(String codIstituto, String registerName) throws ResourceException {
    ConnectionSpecImpl csi = new ConnectionSpecImpl();

    csi.setRegisterName(registerName);

    csi.setConnectionWaitTimeout(20);

    ConnectionFactory cf;

    switch (codIstituto) {
      case "0019":
        cf = cf0019;
        break;
      case "0062":
        cf = cf0062;
        break;
      default:
        throw new IllegalArgumentException("Unrecognized codIstituto [ " + codIstituto + " ]");

    }

    return new AutoClosableConnection(cf.getConnection(csi));
  }
}