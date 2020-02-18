package com.ibm.wsc.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.CicsCommunicationHandlerFactory;
import com.ibm.cics.CicsCaller;
import com.ibm.cicsdev.bean.CicsCommunicationHandler;
import com.ibm.websphere.ola.IndexedRecordImpl;
import java.nio.charset.StandardCharsets;
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
public class Was2Batch implements Was2CicsEjb {

  private static final Logger logger = LoggerFactory.getLogger(Was2Batch.class);

  // NOTE
  // EJBs cannot have parameter constructors
  @Inject
  private CicsCaller cicsCaller;
  @Inject
  private CicsCommunicationHandlerFactory cicsCommunicationHandlerFactory;


  @TransactionAttribute(MANDATORY)
  public String driveIntoCics(String registerName, String serviceName, String input) {

    logger.info("Start; input params: registerName [ {} ], serviceName [ {} ], input [ {} ]",
        registerName, serviceName, input);

    try {

      ObjectMapper mapper = new ObjectMapper();
      JsonNode rootNode = mapper.readTree(input);

      logger.debug("Parsed root node [ {} ]", rootNode);
      // read employee id
      JsonNode wlxaxmlpDescrizione = rootNode.path("wlxaxmlpDescrizione");
      logger.debug("Parsed wlxaxmlpDescrizione node [ {} ]", wlxaxmlpDescrizione);

      final CicsCommunicationHandler communicationHandler = cicsCommunicationHandlerFactory
          .getHandlerInstance(wlxaxmlpDescrizione.textValue());

      CicsObjectWrapper inputWrapper = communicationHandler.getWrapperInstance(input);

      Record outputRecord = cicsCaller.callCicsTransaction(registerName, serviceName, inputWrapper);

      if (outputRecord instanceof IndexedRecordImpl) {
        final byte[] output = (byte[]) (((IndexedRecordImpl) outputRecord).get(0));
        return mapper.writeValueAsString(communicationHandler.getWrapperInstance(output));
      }

      throw new EJBException("Unrecognized output record type [ " + outputRecord + " ]");
    } catch (Exception e) {
      logger.error("An error occurred while performing Saldo Inquiry cics call", e);
      throw new EJBException(e);
    }
  }

  @Override
  public String driveIntoCics(String registerName, String serviceName, byte[] input) {
    return driveIntoCics(registerName, serviceName, new String(input, StandardCharsets.UTF_8));
  }
}
