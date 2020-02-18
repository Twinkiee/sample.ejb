package com.ibm;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

public class AutoClosableConnection implements Connection, AutoCloseable {

  private final Connection connection;

  public AutoClosableConnection(Connection connection) {
    this.connection = connection;
  }

  @Override
  public Interaction createInteraction() throws ResourceException {
    return connection.createInteraction();
  }

  @Override
  public LocalTransaction getLocalTransaction() throws ResourceException {
    return connection.getLocalTransaction();
  }

  @Override
  public ConnectionMetaData getMetaData() throws ResourceException {
    return connection.getMetaData();
  }

  @Override
  public ResultSetInfo getResultSetInfo() throws ResourceException {
    return connection.getResultSetInfo();
  }

  @Override
  public void close() throws ResourceException {
    connection.close();
  }
}
