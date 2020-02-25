package wasdev.ejb.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import wasdev.ejb.api.SampleStatelessBean;

/**
 * <code>@Local(SampleStatelessBean.class)</code> must be used when multiple interfaces are implemented<br>
 * <code>@LocalBean</code> Can be used instead of <code>@Local</code> if the local EJB is injected by class and not by
 * implemented interface
 */
@Stateless
// Can be used without indicating a specific interface if only one interface is used
@Local
public class SampleStatelessBeanImpl implements SampleStatelessBean {

  @Override
  public String hello() {
    return "Hello LOCAL EJB World.";
  }

  @Override
  @TransactionAttribute(MANDATORY)
  public String hello(byte[] input) {
    return "Hello LOCAL EJB World. input [ " + new String(input) + " ]" ;
  }
}
