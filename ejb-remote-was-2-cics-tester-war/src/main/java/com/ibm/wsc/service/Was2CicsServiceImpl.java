package com.ibm.wsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.wsc.bean.CicsObjectWrapper;
import com.ibm.wsc.cics.CicsCommunicationHandler;
import com.ibm.wsc.cics.CicsCommunicationHandlerFactory;
import com.ibm.wsc.ejb.Was2CicsEjb;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class Was2CicsServiceImpl implements Was2CicsService {

  private static final Logger logger = LoggerFactory.getLogger(Was2CicsServiceImpl.class);

  @EJB(lookup = "was2CicsEjb")
  private Was2CicsEjb was2Cics;

  @Inject
  private CicsCommunicationHandlerFactory cicsCommunicationHandlerFactory;

  @Override
  public String callCics(String registerName, String serviceName, String i)
      throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(i);

    logger.debug("Parsed root node [ {} ]", rootNode);
    JsonNode wlxaxmlpDescrizione = rootNode.path("wlxaxmlpDescrizione");
    logger.debug("Parsed wlxaxmlpDescrizione node [ {} ]", wlxaxmlpDescrizione);

    final CicsCommunicationHandler communicationHandler = cicsCommunicationHandlerFactory
        .getHandlerInstance(wlxaxmlpDescrizione.textValue());

    CicsObjectWrapper inputWrapper = communicationHandler.getWrapperInstance(i);

    final byte[] bytes = was2Cics
        .driveIntoCics(registerName, serviceName, inputWrapper.getByteBuffer());
    return mapper.writeValueAsString(communicationHandler.getWrapperInstance(bytes));
  }
}
