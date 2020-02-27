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
@WebServlet({"/sampleCicsCallEjbServlet"})
@Transactional
public class SampleCicsCallEjbServlet extends HttpServlet {

  private static final Logger logger = LoggerFactory.getLogger(SampleCicsCallEjbServlet.class);

  private static final long serialVersionUID = 1L;

  @EJB(lookup = "sampleStatelessBeanRemote")
  private SampleStatelessBeanRemote statelessBean;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    logger.info("Client servlet started");
    PrintWriter writer = response.getWriter();

    String input = request.getParameter("input");
    logger.info("Invoking remote Sample CICS Call EJB");
    long time = System.nanoTime();
    // Call hello method on a stateless session bean
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("An input URL parameter must be provided");
    }

    final String returnValue = statelessBean.callCicsSample(new String(input.getBytes(), "Cp1047").getBytes());

    logger.info("Remote Sample CICS Call EJB invoked in [ {} ] ns", System.nanoTime() - time);

    writer.println(returnValue);
  }
}
