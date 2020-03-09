package ejb;

import com.sample.ejb.api.RemoteExecutorEjb;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Remote(EquinixCts10002Ejb01.class)
public class EquinixCts10002Ejb01 implements RemoteExecutorEjb {

  private static final Logger logger = LoggerFactory.getLogger(EquinixCts10002Ejb01.class);

  @Override
  public byte[] execute(byte[] input) {
    return new byte[0];
  }
}
