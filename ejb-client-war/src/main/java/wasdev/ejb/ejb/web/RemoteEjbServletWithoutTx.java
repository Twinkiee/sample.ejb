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
import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wasdev.ejb.api.SampleStatelessBeanRemote;

/**
 * A servlet which injects a remote stateless EJB
 */
@WebServlet({"/remoteEjbServletWithoutTx"})
public class RemoteEjbServletWithoutTx extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(RemoteEjbServletWithoutTx.class);

  private static final long serialVersionUID = 1L;

  @EJB(lookup = "sampleStatelessBeanRemote")
  SampleStatelessBeanRemote statelessBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    logger.info("Client servlet started");
    PrintWriter writer = response.getWriter();

    String input = request.getParameter("input");
    String message = "no input";
    logger.info("Invoking remote EJB");
    long time = System.nanoTime();
    // Call hello method on a stateless session bean
    message = (input != null)
        ? statelessBean.hello(input.getBytes())
        : statelessBean.hello();

    logger.info("Remote EJB invoked in [ {} ] ns", System.nanoTime() - time);

    writer.println(message);
  }
}
