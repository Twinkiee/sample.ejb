package com.ibm.cics;

import com.ibm.AutoClosableConnection;
import com.ibm.AutoClosableInteraction;
import com.ibm.websphere.ola.ConnectionSpecImpl;
import com.ibm.websphere.ola.IndexedRecordImpl;
import com.ibm.websphere.ola.InteractionSpecImpl;
import com.ibm.wsc.ejb.CicsObjectWrapper;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Record;

//@ApplicationScoped
public class CicsCallerImpl implements CicsCaller {

  @Resource(name = "eis/ola", type = ConnectionFactory.class)
  private ConnectionFactory cf;

  @Override
  public Record callCicsTransaction(String registerName, String serviceName,
      CicsObjectWrapper inputWrapper)
      throws ResourceException {

    try (AutoClosableConnection connection = getConnection(registerName)
        ; AutoClosableInteraction interaction = getInteraction(connection)) {

      InteractionSpecImpl interactionSpec = getInteractionSpec(serviceName);

      IndexedRecordImpl indexedRecord = getIndexedRecord(inputWrapper);

      return interaction.execute(interactionSpec, indexedRecord);
    }
  }

  private IndexedRecordImpl getIndexedRecord(CicsObjectWrapper inputWrapper) {
    IndexedRecordImpl iri = new IndexedRecordImpl();
    iri.add(inputWrapper.getByteBuffer());
    return iri;
  }

  private AutoClosableInteraction getInteraction(Connection connection) throws ResourceException {
    return new AutoClosableInteraction(connection.createInteraction());
  }

  private InteractionSpecImpl getInteractionSpec(String serviceName) {
    InteractionSpecImpl isi = new InteractionSpecImpl();
    isi.setServiceName(serviceName);
    return isi;
  }

  private AutoClosableConnection getConnection(String registerName) throws ResourceException {
    ConnectionSpecImpl csi = new ConnectionSpecImpl();

    csi.setRegisterName(registerName);

    csi.setConnectionWaitTimeout(20);

    return new AutoClosableConnection(cf.getConnection(csi));
  }
}
