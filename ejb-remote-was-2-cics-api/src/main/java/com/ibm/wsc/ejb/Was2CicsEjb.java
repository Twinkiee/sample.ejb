package com.ibm.wsc.ejb;

public interface Was2CicsEjb {

	byte[] driveIntoCics(String registerName, String serviceName, byte[] input);
}
