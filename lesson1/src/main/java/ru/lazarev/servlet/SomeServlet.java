package ru.lazarev.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SomeServlet", urlPatterns = "/some_servlet")
public class SomeServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(SomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New Get request with includes");

        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        resp.getWriter().println("<p>Response body from servlet</p>");
        getServletContext().getRequestDispatcher("SomeServlet").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");

        resp.getWriter().printf("<h1>New POST request</h1>");
    }
}