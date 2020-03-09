package com.ibm.waszos.ejb;

public interface Was2CicsEjb {

	byte[] driveIntoCics(String registerName, String serviceName, String codIstituto,
      byte[] input);
}
