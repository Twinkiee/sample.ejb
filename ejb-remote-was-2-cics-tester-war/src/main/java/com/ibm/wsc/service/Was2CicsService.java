package com.ibm.wsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Was2CicsService {

  String callCics(String registerName, String serviceName, String i) throws JsonProcessingException;
}
