package wasdev.ejb.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import java.io.UnsupportedEncodingException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wasdev.ejb.api.SampleStatelessBeanRemote;

@Stateless
@Remote(SampleStatelessBeanRemote.class)
public class SampleStatelessBeanRemoteImpl implements SampleStatelessBeanRemote {

  private static final Logger logger = LoggerFactory.getLogger(SampleStatelessBeanRemoteImpl.class);

  @Override
  public String hello() {

    logger.info("Executing remote EJB");
    return "Hello REMOTE EJB World.";
  }

  @Override
  @TransactionAttribute(MANDATORY)
  public String hello(byte[] input) {
    final String inputString = new String(input);

    try {
      logger.info(new String("Executing remote EJB with param [ {} ]".getBytes(), "Cp1047"), inputString);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return "Hello REMOTE EJB World. input [ " + inputString + " ]";
  }
}
