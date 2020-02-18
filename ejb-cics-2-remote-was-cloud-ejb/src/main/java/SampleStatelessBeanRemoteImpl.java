import static javax.ejb.TransactionAttributeType.MANDATORY;

import com.ibm.ejb.api.RemoteExecutorEjb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Remote(RemoteExecutorEjb.class)
public class SampleStatelessBeanRemoteImpl implements RemoteExecutorEjb {

  private static final Logger logger = LoggerFactory.getLogger(SampleStatelessBeanRemoteImpl.class);

  @Resource
  private DataSource dataSource;


  @Override
  @TransactionAttribute(MANDATORY)
  public byte[] execute(byte[] input) {
    logger.info("Executing remote EJB");

    try (Connection connection = dataSource.getConnection()) {
//      connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

      logger.info("Default schema [ {} ]", dataSource.getConnection().getSchema());

      long time = System.nanoTime();
      doUpdate(connection);
      logger.info("Remote EJB update executed in [ {} ] ns", System.nanoTime() - time);
//      doSelect(connection);

    } catch (SQLException e) {

      logger.error("Error while executing the remote EJB", e);
      e.printStackTrace();
    }

    return new byte[0];
  }


  private void doUpdate(Connection connection) throws SQLException {
    String sql = "insert into T99TERM1 ("
        + "cicsname"
        + ", banca)"
        + " values ("
        + "'1233', "
        + "'$999' )";

    connection.prepareStatement(sql).executeUpdate();
  }

  private void doSelect(Connection connection) throws SQLException {
    String sql = "select * from T99TERM1 where cicsname = '1233' and banca = '$999' WITH CS";

    Statement stmt = connection.createStatement();

    ResultSet rs = stmt.executeQuery(sql);

    while (rs.next()) {
      logger.info("Value 1 [ {} ]", rs.getObject(1));
      logger.info("Value 2 [ {} ]", rs.getObject(2));
    }
  }
}
