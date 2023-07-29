/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aryan Kesarwani
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CurrencyConverterServlet")
public class CurrencyConverterServlet extends HttpServlet {
    private static final double USD_TO_INR_RATE = 84.5; // Exchange rate: 1 USD = 74.5 INR

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amountStr = request.getParameter("amount");
        String currency = request.getParameter("currency");
        
        double amount = Double.parseDouble(amountStr);
        double convertedAmount = (currency.equals("usd")) ? (amount * USD_TO_INR_RATE) : (amount / USD_TO_INR_RATE);

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Converted Amount:</h2>");
        out.println("<p>" + amount + " " + ((currency.equals("usd")) ? "USD" : "INR") + " = " + convertedAmount + " " + ((currency.equals("usd")) ? "INR" : "USD") + "</p>");
        out.println("</body></html>");
    }
}

