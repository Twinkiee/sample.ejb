package wasdev.ejb.ejb;

import static javax.ejb.TransactionAttributeType.MANDATORY;

import com.ibm.websphere.ola.IndexedRecordImpl;
import java.io.UnsupportedEncodingException;
import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Inject;
import javax.resource.cci.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wasdev.ejb.api.SampleStatelessBeanRemote;
import wasdev.ejb.cics.CicsCaller;

@Stateless
@Remote(SampleStatelessBeanRemote.class)
public class SampleStatelessBeanRemoteImpl implements SampleStatelessBeanRemote {

  private static final Logger logger = LoggerFactory.getLogger(SampleStatelessBeanRemoteImpl.class);

  @Inject
  private CicsCaller cicsCaller;

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


  @Override
  @TransactionAttribute(MANDATORY)
  public String callCicsSample(byte[] input) {
    final String inputString = new String(input);

    try {
      logger.info("Start; input params: registerName [  ], serviceName [  ], input [ {} ]",
           new String(input, "Cp1047"));

      Record outputRecord = cicsCaller.callCicsTransaction("registerName", "serviceName", input);

      if (outputRecord instanceof IndexedRecordImpl) {
        final byte[] bytes = (byte[]) (((IndexedRecordImpl) outputRecord).get(0));

        final String returnValue = new String(bytes, "Cp1047");
        logger.info("Returning commarea [ {} ]",
            returnValue);
        return returnValue;
      }

//      final WOXABC40CommareaWrapper1 woxabc40CommareaWrapper1 = WOXABC40CicsCallerMock
//          .getWoxabc40CommareaWrapper1();
//      final byte[] byteBuffer = woxabc40CommareaWrapper1.getByteBuffer();
//
//      logger.info("Returning mocked Woxabc40CommareaWrapper1 instance [ {} ]",
//          new String(byteBuffer, "Cp1047"));
//
//      return byteBuffer;
      throw new EJBException("Unrecognized output record type [ " + outputRecord + " ]");
    } catch (Exception e) {
      logger.error("An error occurred while performing Saldo Inquiry cics call", e);
      throw new EJBException(e);
    }
  }
}
