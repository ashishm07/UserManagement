package com.nkn.usermanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.http.Cookie;

import com.nkn.usermanagement.bean.User;
import com.nkn.usermanagement.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		PrintWriter out = response.getWriter();
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//
//		if (validateUser(request, response)) {
//
//			HttpSession session = request.getSession();
//			session.putValue("uname", name);
//
//			response.sendRedirect("user-form.jsp");
//			out.print(name + " does exist");
//		}
//
//		else {
//
//			out.print(name + " does not exist");
//		}
//
//		User u1 = new User(name, password);
//		HttpSession session = request.getSession();
//		session.setAttribute("User", u1);
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		request.getParameter("password");

		if (request.getParameter("Login") != null) {
			// insertUser(request, response);

			// List<User> listUser = UserDao.retrieveAll();

			if ((name.equals("admin")) && (password.equals("admin123"))) {
				insertUser(request, response);
			}

			else {
				if (validateUser(request, response)) {
//	      		HttpSession session = request.getSession();
//					session.setAttribute("uname", name);

					Cookie cookie = new Cookie("uname", name + "");
					Cookie cookiepass = new Cookie("upass", password + "");

					response.addCookie(cookie);
					response.addCookie(cookiepass);

					out.print(name + " does exist");
//					request.setAttribute("alertMsg", "Login Success");

					System.out.println("LOGIN SUCCESS for " + name);
					response.sendRedirect("user-list.jsp");
				} else {

//				if (listUser.isEmpty()) {
//					System.out.println("No user present, redirecting to add user page");
//					response.sendRedirect("user-form.jsp");
//				}

					out.print(name + " does not exist");
//					JOptionPane.showMessageDialog(null, "User does not exist");
//					request.setAttribute("alertMsg", "Login failed");
					System.out.println("Login failed for " + name);
					response.sendRedirect("userLogin.jsp");
				}
			}
		}

		if (request.getParameter("LogOut") != null) {
			// insertUser(request, response);

//			JOptionPane.showMessageDialog(null, "User has logged out");

//			HttpSession session = request.getSession();
//			session.removeAttribute("uname");
//			session.invalidate();

			Cookie cookie[] = request.getCookies();
			for (Cookie c : cookie) {
				out.print(" " + c.getName() + " " + c.getValue());// printing name and value of cookie
			}
//			out.print(name + " does not exist");

			Cookie cookie1 = new Cookie("uname", "");
			cookie1.setMaxAge(0);
			response.addCookie(cookie1);
			response.sendRedirect("userLogin.jsp");
		}

		if (request.getParameter("Add") != null) {
			// insertUser(request, response);
			response.sendRedirect("user-form.jsp");
		} else if (request.getParameter("Add User") != null) {
			insertUser(request, response);
		} else if (request.getParameter("Delete") != null) {
			response.sendRedirect("delUser.jsp");
		} else if (request.getParameter("Delete User") != null) {
			deleteUser(request, response);
		} else if (request.getParameter("Update") != null) {
			response.sendRedirect("updateUser.jsp");
		} else if (request.getParameter("Update User") != null) {
			updateUser(request, response);
		} else if (request.getParameter("List All Users") != null) {
			listUser(request, response);
		}

//		String name = request.getParameter("Name");
//		String password = request.getParameter("Password");

		// listUser(request, response);
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

	private boolean validateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		return UserDao.userDoesExist(name, password);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		request.getSession();
		response.getWriter();

		String username = "";

		Cookie cookie[] = request.getCookies();
		for (Cookie c : cookie) {
			if (c.getName().equals("uname")) {

				username = c.getValue();
				System.out.println("User added by " + username);

				if (username.equals("admin"))
					UserDao.insert(name, password);
				else {
					System.out.println("Only admin can add users");
				}

			}
		}

//		System.out.println( "New user added by "+ session.getAttribute("uname").toString() );
//		JOptionPane.showMessageDialog(null, "" + name +" added successfully");
//		out.print("New user added by "+ session.getAttribute("uname").toString());

		response.sendRedirect("user-list.jsp");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getSession();
		response.getWriter();

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		String username = "";
		String pass = "";

		Cookie cookie[] = request.getCookies();
		Cookie cookiepass[] = request.getCookies();
		for (Cookie c : cookie) {
			for (Cookie c1 : cookiepass) {
				if ((c.getName().equals("uname")) && (c1.getName().equals("upass"))) {

					username = c.getValue();
					pass = c1.getValue();

					if ((validateUser(request, response))
							&& ((username.equals(name) && (pass.equals(password))) || (username.equals("admin")))) {
						try {

							UserDao.remove(name, password);
							System.out.println("User deleted by " + username);
							break;
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

					else {
						System.out.println("Only " + username + " and ADMIN can delete this record OR " + name
								+ " does not exist.");
					}
				}
			}
		}
//		try {
//			UserDao.remove(name, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		String username="";
//		
//		Cookie cookie[]=request.getCookies();  
//		for(Cookie c : cookie){  
//			if (c.getName().equals("uname") ) {
//				
//				username=c.getValue();
//				System.out.println( "User deleted by "+ username);
//
//			}
//		}  

//		System.out.println( "User deleted by "+ session.getAttribute("uname").toString() );
//		JOptionPane.showMessageDialog(null, "" + name +" removed successfully");
		response.sendRedirect("user-list.jsp");
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<User> listUser = UserDao.retrieveAll();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		String username = "";
//		String pass="";

		Cookie cookie[] = request.getCookies();
		Cookie cookiepass[] = request.getCookies();
		for (Cookie c : cookie) {
			for (Cookie c1 : cookiepass) {
				if ((c.getName().equals("uname")) && (c1.getName().equals("upass"))) {

					username = c.getValue();
//				pass=c1.getValue();

					if (username.equals(name)) {
						try {
							UserDao.updatePassword(name, password);
							System.out.println("User updated by " + username + " with session ID : "
									+ c.getName().equals("JSESSIONID"));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
//		JOptionPane.showMessageDialog(null, "" + name +" updated successfully");
		response.sendRedirect("user-list.jsp");
	}

}