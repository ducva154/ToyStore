/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAO;
import Entity.Account;
import Entity.Category;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANHDUC
 */
@WebServlet(name = "SignupControl", urlPatterns = {"/SignupControl"})
public class SignupControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        DAO dao = new DAO();
        HashMap<Integer, Category> hmCategory = dao.getCategoryFromDB();
        HashMap<Integer, String> hmQuestion = dao.getQuestionFromDB();
        request.setAttribute("title", "Sign Up");
        request.setAttribute("hmCategory", hmCategory);
        request.setAttribute("hmQuestion", hmQuestion);
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("confirmpass");
        boolean gender = request.getParameter("gender").equals("male");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int quesID = Integer.parseInt(request.getParameter("question"));
        String ans = request.getParameter("answer");
        if (!password.equals(confirmpass)) {
            request.setAttribute("message", "Confirm password wrong!");
//            request.getRequestDispatcher("SignupControl").forward(request, response);
            processRequest(request, response);
        } else {
            DAO dao = new DAO();
            Account acc = dao.getAccountbyUsername(username);
            if (acc == null) {
                dao.signUp(username, password, gender, dob, address, email, phone, quesID, ans);
                response.sendRedirect("LoginControl");
            } else {
                request.setAttribute("message", "Username was already used!");
//                request.getRequestDispatcher("SignupControl").forward(request, response);
                processRequest(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
