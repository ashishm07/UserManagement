package com.nkn.usermanagement.web;

import java.io.*;
import java.util.List;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import com.nkn.usermanagement.bean.User;
import com.nkn.usermanagement.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("test");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		
		if (request.getParameter("Add")!=null) 
		{
			//insertUser(request, response);
			response.sendRedirect("user-form.jsp");
		}
		else if(request.getParameter("Add User")!=null) 
		{
			insertUser(request, response);
		}
		else if (request.getParameter("Delete")!=null) 
		{
			response.sendRedirect("delUser.jsp");
		}
		else if (request.getParameter("Delete User")!=null) 
		{
			deleteUser(request, response);
		}
		else if(request.getParameter("List All Users")!=null) 
		{
			listUser(request, response);
			
		}
		
//		
//		String name = request.getParameter("Name");
//		String password = request.getParameter("Password");

      //listUser(request, response);
		}
		
//		private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		// TODO Auto-generated method stub
//			response.getWriter().println("Working"); //  custom string
//
//		
//	}

//		private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
//			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//			dispatcher.forward(request, response);
//		}

		private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			UserDao.insert(name, password);
			response.sendRedirect("user-list.jsp");
	
		} 
		
		private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
//			User delUser = new User(name);
			try {
				UserDao.remove(name, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("DELETE SUCCESS for " + name);
			response.sendRedirect("user-list.jsp");
		}
		
		private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				List<User> listUser = UserDao.retrieveAll();
				request.setAttribute("listUser", listUser);
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
				dispatcher.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
//			User delUser = new User(name);
			try {
				UserDao.updatePassword(name, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("UPDATE SUCCESS for " + name);
			response.sendRedirect("user-list.jsp");
		}
		
}
