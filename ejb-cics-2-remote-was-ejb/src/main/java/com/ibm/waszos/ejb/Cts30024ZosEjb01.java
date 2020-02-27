package com.ibm.waszos.ejb;

import com.ibm.ejb.api.RemoteExecutorEjb;
import com.ibm.websphere.ola.ExecuteHome;
import javax.ejb.EJB;
import javax.ejb.RemoteHome;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@RemoteHome(ExecuteHome.class)
public class Cts30024ZosEjb01 {

  private static final Logger logger = LoggerFactory.getLogger(Cts30024ZosEjb01.class);

  @EJB(lookup = "equinixCts30024Ejb01")
  private RemoteExecutorEjb remoteExecutor;

  public byte[] execute(byte[] arg0) {

    logger.info("Calling remote EquinixCts30024Ejb01 EJB");
    long start = System.nanoTime();
    final byte[] returnValue = remoteExecutor.execute(arg0);

    logger.info("Remote EquinixCts30024Ejb01 EJB call executed in [ {} ] ns", System.nanoTime() - start);
    return returnValue;
  }
}
