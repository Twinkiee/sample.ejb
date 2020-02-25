package wasdev.ejb.cics;

import com.ibm.websphere.ola.ConnectionSpecImpl;
import com.ibm.websphere.ola.IndexedRecordImpl;
import com.ibm.websphere.ola.InteractionSpecImpl;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.Record;
import wasdev.ejb.cci.AutoClosableConnection;
import wasdev.ejb.cci.AutoClosableInteraction;

@ApplicationScoped
public class CicsCallerImpl implements CicsCaller {

  @Resource(name = "eis/ola", type = ConnectionFactory.class)
  private ConnectionFactory cf;

  @Override
  public Record callCicsTransaction(String registerName, String serviceName,
      byte[] input)
      throws ResourceException {

    try (AutoClosableConnection connection = getConnection(registerName)
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

  private AutoClosableConnection getConnection(String registerName) throws ResourceException {
    ConnectionSpecImpl csi = new ConnectionSpecImpl();

    csi.setRegisterName(registerName);

    csi.setConnectionWaitTimeout(20);

    return new AutoClosableConnection(cf.getConnection(csi));
  }
}
