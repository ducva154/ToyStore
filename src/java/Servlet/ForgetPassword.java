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
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANHDUC
 */
@WebServlet(name = "ForgetPassword", urlPatterns = {"/ForgetPassword"})
public class ForgetPassword extends HttpServlet {

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
        request.setAttribute("title", "Forget password");
        request.setAttribute("hmCategory", hmCategory);
        request.setAttribute("hmQuestion", hmQuestion);
        request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
        
        String username = request.getParameter("username");
        int quesID = Integer.parseInt(request.getParameter("question"));
        String ans = request.getParameter("answer");
        String password = request.getParameter("password");
        String confirmpass = request.getParameter("confirmpass");
        
        DAO dao = new DAO();
        Account acc = dao.getAccountbyUsername(username);
        if (acc==null) {
            request.setAttribute("message", "Account does not exist!");
            processRequest(request, response);
        } else {
            if (acc.getQuestion()==quesID && acc.getAnswer().equalsIgnoreCase(ans)) {
                if (password.equals(confirmpass)) {
                    dao.updateAccount(username, password);
                    response.sendRedirect("LoginControl");
                } else {
                request.setAttribute("message", "Confirm new password is wrong!");
                processRequest(request, response);
                }   
            } else {
                request.setAttribute("message", "Wrong security question or answer!");
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
