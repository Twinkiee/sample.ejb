package com.ibm.wsc.ejb;

public interface Was2CicsEjb {

	String driveIntoCics(String registerName, String serviceName, String input);

	String driveIntoCics(String registerName, String serviceName, byte[] input);

}
