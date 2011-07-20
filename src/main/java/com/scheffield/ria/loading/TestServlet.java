package com.scheffield.ria.loading;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final PrintWriter writer = resp.getWriter();
		
		writer.write("<html><head><title>test</title></head><body><p>Hello, World!</p></body></html>");
		
	}
	
}
