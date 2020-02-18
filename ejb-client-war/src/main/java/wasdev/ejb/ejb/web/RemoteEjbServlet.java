/*******************************************************************************
 * (c) Copyright IBM Corporation 2017.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package wasdev.ejb.ejb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wasdev.ejb.api.SampleStatelessBeanRemote;

/**
 * A servlet which injects a remote stateless EJB
 */
@WebServlet({"/remoteEjbServlet"})
public class RemoteEjbServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(RemoteEjbServlet.class);

  private static final long serialVersionUID = 1L;

  @EJB(lookup = "sampleStatelessBeanRemote")
  SampleStatelessBeanRemote statelessBean;

  @Resource
  UserTransaction tx;

  @Resource
  DataSource dataSource;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    logger.info("Client servlet started");
    PrintWriter writer = response.getWriter();

    try (final Connection connection = dataSource.getConnection()) {
      logger.info("Client connection opened");
      tx.begin();
      logger.info("User transaction started");
//      connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

//      doUpdate(connection);

      String sql = "select * from T99TERM1 where cicsname = '1234' and banca = '$999'";
      Statement stmt = connection.createStatement();
      ResultSet rs = stmt.executeQuery(sql);

      logger.info("Performed select statement");
      rs.next();
      logger.info("Value 1 [ {} ]", rs.getObject(1));
      logger.info("Value 2 [ {} ]", rs.getObject(2));

      logger.info("Invoking remote EJB");
      long time = System.nanoTime();
      // Call hello method on a stateless session bean
      String message = statelessBean.hello();
      logger.info("Remote EJB invoked in [ {} ] ns", System.nanoTime() - time);

      while (rs.next()) {
        logger.info("Value 1 [ {} ]", rs.getObject(1));
        logger.info("Value 2 [ {} ]", rs.getObject(2));
      }

//      doSelect(connection);

      writer.println(message);
      tx.commit();
    } catch (HeuristicMixedException | HeuristicRollbackException | RollbackException | NotSupportedException | SystemException | SQLException e) {
      logger.error("Exception while invoking remote EJB", e);
    }

  }

  private void doUpdate(Connection connection) throws SQLException {
    String sql = "insert into T99TERM1 ("
        + "cicsname"
        + ", banca)"
        + " values ("
        + "'1234', "
        + "'$999' )";

    connection
        .prepareStatement(sql)
        .executeUpdate();
  }

  private void doSelect(Connection connection) throws SQLException {
    String sql = "select * from T99TERM1 where cicsname = '1234' and banca = '$999'";

    Statement stmt = connection.createStatement();

    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      logger.info("Value 1 [ {} ]", rs.getObject(1));
      logger.info("Value 2 [ {} ]", rs.getObject(2));
    }
  }
}
