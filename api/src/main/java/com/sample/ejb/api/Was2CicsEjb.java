package com.sample.ejb.api;

public interface Was2CicsEjb {

	byte[] driveIntoCics(String registerName, String serviceName, byte[] input);
}
