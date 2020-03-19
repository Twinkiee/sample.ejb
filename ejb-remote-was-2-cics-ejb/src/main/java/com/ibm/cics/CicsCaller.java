package com.ibm.cics;

import javax.resource.ResourceException;
import javax.resource.cci.Record;

public interface CicsCaller {

  Record callCicsTransaction(String registerName, String serviceName,
      /*String codIstituto,*/ byte[] input) throws ResourceException;
}
