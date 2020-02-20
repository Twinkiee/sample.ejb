package com.ibm.wsc.cics;

import com.ibm.wsc.bean.CommareaWrapperHelper;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfo;
import io.github.classgraph.ScanResult;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJBException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class CicsCommunicationHandlerFactory {

  private static final Logger logger = LoggerFactory
      .getLogger(CicsCommunicationHandlerFactory.class);

  @Inject
  private CommareaWrapperHelper wrapperHelper;

  private List<CicsCommunicationHandler> handlers;

  public CicsCommunicationHandler getHandlerInstance(String wlxaxmlpDescrizione) {

    logger.info("Scanning CICS communication handlers [ {} ]", handlers);

    for (CicsCommunicationHandler handler : handlers) {

      if (handler.isSuitable(wlxaxmlpDescrizione)) {
        return handler;
      }
    }

    throw new IllegalArgumentException(
        "No com.ibm.cicsdev.bean.CicsCommunicationHandler can be instantiated with params: wlxaxmlpDescrizione [ "
            + wlxaxmlpDescrizione + " ]");
  }

  @PostConstruct
  private void init() {
    try (ScanResult scanResult = new ClassGraph()
        .whitelistPackages("com.ibm.cicsdev.bean")
        .enableClassInfo().scan()) {

      handlers = new LinkedList<>();
      for (ClassInfo ci : scanResult
          .getClassesImplementing(CicsCommunicationHandler.class.getCanonicalName())) {

        logger.info("Loading CicsCommunicationHandler [ {} ]", ci);
        final CicsCommunicationHandler communicationHandler = ci
            .loadClass(CicsCommunicationHandler.class)
            .newInstance();

        communicationHandler.setHelper(wrapperHelper);
        handlers.add(communicationHandler);
      }
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error("An error occurred while instantiating CicsCommunicationHandler", e);

      throw new EJBException(e);
    }
  }
}
