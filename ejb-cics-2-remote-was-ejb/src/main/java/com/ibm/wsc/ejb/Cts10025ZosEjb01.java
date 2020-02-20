package com.ibm.wsc.ejb;

import com.ibm.ejb.api.RemoteExecutorEjb;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class Cts10025ZosEjb01 {

  private static final Logger logger = LoggerFactory.getLogger(Cts10025ZosEjb01.class);

  @EJB(lookup = "cts10025ZosEjb01")
  private RemoteExecutorEjb remoteExecutor;

  public byte[] execute(byte[] arg0) {

    logger.info("Calling remote Cts10025ZosEjb01 EJB");
    long start = System.nanoTime();
    final byte[] returnValue = remoteExecutor.execute(arg0);

    logger.info("Remote Cts10025ZosEjb01 EJB call executed in [ {} ] ns", System.nanoTime() - start);
    return returnValue;
  }
}
