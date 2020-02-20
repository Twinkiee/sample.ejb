package com.ibm.wsc.ejb;

import com.ibm.ejb.api.RemoteExecutorEjb;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class Cts30024ZosEjb01 {

  private static final Logger logger = LoggerFactory.getLogger(Cts30024ZosEjb01.class);

  @EJB(lookup = "cts30024Ejb01")
  private RemoteExecutorEjb remoteExecutor;

  public byte[] execute(byte[] arg0) {

    logger.info("Calling remote Cts30024Ejb01 EJB");
    long start = System.nanoTime();
    final byte[] returnValue = remoteExecutor.execute(arg0);

    logger.info("Remote Cts30024Ejb01 EJB call executed in [ {} ] ns", System.nanoTime() - start);
    return returnValue;
  }
}
