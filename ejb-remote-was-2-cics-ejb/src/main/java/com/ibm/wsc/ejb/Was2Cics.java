package com.ibm.wsc.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import com.ibm.cics.CicsCaller;
import com.ibm.websphere.ola.IndexedRecordImpl;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.resource.cci.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Session Bean implementation class Was2Batch
 */
@Stateless
@Remote(Was2CicsEjb.class)
public class Was2Cics implements Was2CicsEjb {

  private static final Logger logger = LoggerFactory.getLogger(Was2Cics.class);

  // NOTE
  // EJBs cannot have parameter constructors
  @Inject
  private CicsCaller cicsCaller;

  @Override
  @TransactionAttribute(MANDATORY)
  public byte[] driveIntoCics(String registerName, String serviceName, byte[] input) {

    try {
      System.out.println("Start; input params: registerName [ "+registerName+" ], serviceName [ "+serviceName+" ], input [ "+new String(input, "Cp1047")+" ]");
    } catch (UnsupportedEncodingException e) {

      System.out.println("Start; input params: registerName [ "+registerName+" ], serviceName [ "+serviceName+" ]");
      e.printStackTrace();
    }

    try {
      logger.info("Start; input params: registerName [ {} ], serviceName [ {} ], input [ {} ]",
          registerName, serviceName, new String(input, "Cp1047"));

      Record outputRecord = cicsCaller.callCicsTransaction(registerName, serviceName, input);

      if (outputRecord instanceof IndexedRecordImpl) {
        return (byte[]) (((IndexedRecordImpl) outputRecord).get(0));
      }

      throw new EJBException("Unrecognized output record type [ " + outputRecord + " ]");
    } catch (Exception e) {
      logger.error("An error occurred while performing Saldo Inquiry cics call", e);
      throw new EJBException(e);
    }
  }
}
