package com.ibm.wsc.servlet;

import com.ibm.wsc.ejb.Was2CicsEjb;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class InvokeWas2BatchServlet
 */
@WebServlet({"/was2Cics"})
public class Was2CicsServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(Was2CicsServlet.class);

  @EJB(lookup = "was2CicsEjb")
  private Was2CicsEjb was2Cics;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Was2CicsServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    doPost(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String registerName = request.getParameter("reg_name").trim();
    String serviceName = request.getParameter("service_name").trim();
    String params = request.getParameter("params");

    logger.info("Handling request with params [ {} ]", request.getParameterMap());
    PrintWriter writer = response.getWriter();

//    String output = was2Cics.driveIntoCics(registerName, serviceName, params);
    String output = was2Cics.driveIntoCics(registerName, serviceName, params.getBytes(
        StandardCharsets.UTF_8));

    writer.println(output);
  }

}
