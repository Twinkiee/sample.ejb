package ejb;

import com.ibm.ejb.api.RemoteExecutorEjb;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Remote(SampleWolaRemoteEjbExecutor.class)
public class SampleWolaRemoteEjbExecutor implements RemoteExecutorEjb {

  private static final Logger logger = LoggerFactory.getLogger(SampleWolaRemoteEjbExecutor.class);

  @Override
  public byte[] execute(byte[] input) {

    logger.info("Executing remote EJB");
    final byte[] bytes = new byte[2];
    bytes[0] = 1;
    bytes[1] = 2;

    logger.info("Executed remote EJB; return value [ {} ]", bytes);
    return bytes;
  }
}
