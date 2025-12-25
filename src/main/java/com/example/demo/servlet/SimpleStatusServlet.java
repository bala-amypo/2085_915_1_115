package com.example.demo.servlet;

import jakarta.servlet.http.*;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    // ✅ MUST BE PUBLIC
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        resp.getWriter().write("Cold Chain Temperature Breach Alert System is running");
    }
}
