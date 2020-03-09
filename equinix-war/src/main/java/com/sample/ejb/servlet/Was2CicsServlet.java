package com.sample.ejb.servlet;

import com.sample.ejb.service.Was2CicsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
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

  @Inject
  private Was2CicsService was2CicsService;

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
    String i = request.getParameter("params");

    logger.info("Handling request with params [ {} ]", request.getParameterMap());
    PrintWriter writer = response.getWriter();

    final String returnValue = was2CicsService.callCics(registerName, serviceName, i);

    writer.println(returnValue);
  }

}
