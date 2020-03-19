package com.ibm.cics;

import com.ibm.websphere.ola.IndexedRecordImpl;
import com.ibm.wsc.bean.WOXABC40CommareaWrapper1;
import java.math.BigDecimal;
import javax.resource.cci.Record;

//@ApplicationScoped
public class WOXABC40CicsCallerMock implements CicsCaller {

  @Override
  public Record callCicsTransaction(String registerName, String serviceName,
      /*String codIstituto,*/ byte[] input) {
    final IndexedRecordImpl indexedRecord = new IndexedRecordImpl();
    final WOXABC40CommareaWrapper1 woxabc40CommareaWrapper1 = getWoxabc40CommareaWrapper1();
    indexedRecord.add(woxabc40CommareaWrapper1.getByteBuffer());
    return indexedRecord;
  }

  public static WOXABC40CommareaWrapper1 getWoxabc40CommareaWrapper1() {
    final WOXABC40CommareaWrapper1 woxabc40CommareaWrapper1 = new WOXABC40CommareaWrapper1();
    woxabc40CommareaWrapper1.setWoxabc40NumAccordoI(23);
    woxabc40CommareaWrapper1.setWoxabc40ValoreO(5);
    woxabc40CommareaWrapper1.setWoxabc40NumCtaIntI(5);
    woxabc40CommareaWrapper1.setWoxabc40SalContO(new BigDecimal("12.8"));
    woxabc40CommareaWrapper1.setWoxabc40SalLiquidoO(new BigDecimal("13.8"));
    woxabc40CommareaWrapper1.setWoxabc40SalDispO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40SalPartIndiO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40DisponibilitaO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40PartIndAssO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40PartIndAltO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40PartAvvDareO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40PartAvvAvereO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40FidoCassaO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40FidoAssO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40FidoSbfO(new BigDecimal("14.8"));
    woxabc40CommareaWrapper1.setWoxabc40FidoPromiscuoO(new BigDecimal("14.8"));
    return woxabc40CommareaWrapper1;
  }
}
