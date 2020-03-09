package com.sample.ejb.cics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sample.ejb.bean.CicsObjectWrapper;
import com.sample.ejb.bean.CommareaWrapperHelper;

public interface CicsCommunicationHandler {

  boolean isSuitable(String wlxaxmlpDescrizione);

  CicsObjectWrapper getWrapperInstance(byte[] output);

  /**
   * Maps a Json input string into a COBOL COMMAREA Java object wrapper
   *
   * @param input a valid Json input string
   * @return the wrapped COBOL COMMAREA Java object
   * @throws JsonProcessingException when the input string is not a valid Json object
   */
  CicsObjectWrapper getWrapperInstance(String input) throws JsonProcessingException;

  void setHelper(CommareaWrapperHelper helper);
}
