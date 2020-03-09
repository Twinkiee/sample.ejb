package com.ibm.wsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.waszos.ejb.Was2CicsEjb;
import com.ibm.wsc.bean.CicsObjectWrapper;
import com.ibm.wsc.cics.CicsCommunicationHandler;
import com.ibm.wsc.cics.CicsCommunicationHandlerFactory;
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
//  @Transactional
  public String callCics(String registerName, String serviceName, String i)
      throws JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode rootNode = mapper.readTree(i);

    logger.debug("Parsed root node [ {} ]", rootNode);
    JsonNode wlxaxmlpDescrizione = rootNode.path("wlxaxmlpDescrizione");
    logger.debug("Parsed wlxaxmlpDescrizione node [ {} ]", wlxaxmlpDescrizione);
    JsonNode wlxaxmlpIstituto = rootNode.path("wlxaxmlpIstituto");
    logger.debug("Parsed wlxaxmlpIstituto node [ {} ]", wlxaxmlpDescrizione);

    final CicsCommunicationHandler communicationHandler = cicsCommunicationHandlerFactory
        .getHandlerInstance(wlxaxmlpDescrizione.textValue());

    CicsObjectWrapper inputWrapper = communicationHandler.getWrapperInstance(i);

    logger.info("Calling remote EJB with input [ {} ]", inputWrapper);
    long start = System.nanoTime();
    final byte[] bytes = was2Cics
        .driveIntoCics(registerName, serviceName, wlxaxmlpIstituto.textValue(),
            inputWrapper.getByteBuffer());
    logger.info("Remote EJB call executed in [ {} ] ns", System.nanoTime() - start);
    return getResponse(mapper, communicationHandler, bytes);
  }

  private String getResponse(ObjectMapper mapper, CicsCommunicationHandler communicationHandler,
      byte[] bytes) throws JsonProcessingException {
    return mapper.writeValueAsString(communicationHandler.getWrapperInstance(bytes));
  }
}
