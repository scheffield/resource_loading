package com.scheffield.ria.loading;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SlowServingServlet extends HttpServlet {
	
	private static final Logger LOG = LoggerFactory.getLogger(SlowServingServlet.class);

	private static final String TIME_TO_WAIT_PARAM = "t";
	private static final String RESOURCE_TO_LOAD = "r";

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		final Integer timeToWait = Integer.valueOf(req.getParameter(TIME_TO_WAIT_PARAM));
		final String resource = req.getParameter(RESOURCE_TO_LOAD);
		
		try {
			Thread.sleep(timeToWait * 1000);
		} catch (InterruptedException e) {
			throw new ServletException(e);
		}
		
		FileInputStream fileInputStream = null;
		ServletOutputStream os = null;
		
		try {
			fileInputStream = new FileInputStream(getServletContext().getRealPath(resource));
			os = resp.getOutputStream();
			IOUtils.copy(fileInputStream, os);
		} finally {
			IOUtils.closeQuietly(fileInputStream);
			IOUtils.closeQuietly(os);
		}
	}
	
}
