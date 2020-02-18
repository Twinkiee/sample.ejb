package com.ibm.cics;

import com.ibm.wsc.ejb.CicsObjectWrapper;
import javax.resource.ResourceException;
import javax.resource.cci.Record;

public interface CicsCaller {

  Record callCicsTransaction(String registerName, String serviceName,
      CicsObjectWrapper inputWrapper) throws ResourceException;
}
