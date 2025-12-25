package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SimpleStatusServlet extends HttpServlet {

    // MUST be public (already fixed earlier)
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // ✅ FIX 1: set content type
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();

        writer.write("Cold Chain Temperature Breach Alert System is running");

        // ✅ FIX 2: flush writer
        writer.flush();
    }
}
