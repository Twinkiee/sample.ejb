package com.ibm.cics;

import com.ibm.websphere.ola.IndexedRecordImpl;
import com.ibm.wsc.bean.CT30X015CommareaWrapper1;
import java.math.BigDecimal;
import javax.resource.cci.Record;

//@ApplicationScoped
public class CT30X015CicsCallerMock implements CicsCaller {

  @Override
  public Record callCicsTransaction(String registerName, String serviceName,
      /*String codIstituto,*/ byte[] input) {
    final IndexedRecordImpl indexedRecord = new IndexedRecordImpl();
    final CT30X015CommareaWrapper1 ct30x015CommareaWrapper1 = new CT30X015CommareaWrapper1();
    ct30x015CommareaWrapper1.setCt30x015CmTotaleEuroI(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015CodcatsecI(57);
    ct30x015CommareaWrapper1.setCt30x015CodErrO(0);
    ct30x015CommareaWrapper1.setCt30x015CodfilsecI(6);
    ct30x015CommareaWrapper1.setCt30x015CodsrvsecI(6);
    ct30x015CommareaWrapper1.setCt30x015IsTotaleEuroO(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015NumCtaIntI(0);
    ct30x015CommareaWrapper1.setCt30x015NumMessaggioI(0);
    ct30x015CommareaWrapper1.setCt30x015NumOperacionO(123L);
    ct30x015CommareaWrapper1.setCt30x015NumpartsecI(9010980);
    ct30x015CommareaWrapper1.setCt30x015NumUtlMovO(432);
    ct30x015CommareaWrapper1.setCt30x015PostazioneI(0);
    ct30x015CommareaWrapper1.setCt30x015ScTotaleEuroO(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015SnTotaleEuroO(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015SpTotaleEuroI(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015SrTotaleEuroI(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015TotaleEuroI(new BigDecimal("12.8"));
    ct30x015CommareaWrapper1.setCt30x015ValoreI(43);

    indexedRecord.add(ct30x015CommareaWrapper1.getByteBuffer());
    return indexedRecord;
  }
}
