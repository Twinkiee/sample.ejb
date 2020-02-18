import com.ibm.ejb.api.RemoteExecutorEjb;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class WolaEjb {

  private static final Logger logger = LoggerFactory.getLogger(WolaEjb.class);

  @EJB(lookup = "remoteExecutorEjb")
  private RemoteExecutorEjb remoteExecutor;

  public byte[] execute(byte[] arg0) {

    return remoteExecutor.execute(arg0);
  }
}
