package com.ibm.cics;

import com.ibm.AutoClosableConnection;
import com.ibm.AutoClosableInteraction;
import com.ibm.websphere.ola.IndexedRecordImpl;
import com.ibm.websphere.ola.InteractionSpecImpl;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.Record;

@ApplicationScoped
public class CicsCallerImpl implements CicsCaller {

  private final CicsConnectionFactory cicsConnectionFactory;

  @Inject
  public CicsCallerImpl(CicsConnectionFactory cicsConnectionFactory) {
    this.cicsConnectionFactory = cicsConnectionFactory;
  }

  @Override
  public Record callCicsTransaction(String registerName, String serviceName,
      String codIstituto, byte[] input)
      throws ResourceException {

    try (AutoClosableConnection connection = cicsConnectionFactory.getConnection(codIstituto, registerName)
        ; AutoClosableInteraction interaction = getInteraction(connection)) {

      InteractionSpecImpl interactionSpec = getInteractionSpec(serviceName);

      IndexedRecordImpl indexedRecord = getIndexedRecord(input);

      return interaction.execute(interactionSpec, indexedRecord);
    }
  }

  private IndexedRecordImpl getIndexedRecord(byte[] input) {
    IndexedRecordImpl iri = new IndexedRecordImpl();
    iri.add(input);
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

}
