package in.nic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nic.entity.LoginMap;
import in.nic.service.LoginService;

/**
 * Servlet implementation class PluggableServlet
 */
@WebServlet("/P1")
public class PluggableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static LoginService userServiceObj = new LoginService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String userid = "";
		boolean res = false;

		if (name != null) {
			
			if (isValidPanCardNo(name)) {
				System.out.println("userid is PAN No");
				LoginMap loginMap = new LoginMap();
				loginMap.setLoginType("PAN");
				loginMap.setLoginID(name);
				userid = userServiceObj.getUserIdByLoginType(loginMap);
				System.out.println(userid);
				res = validateUser(userid, password);
				
			} else if (isValidMobileNo(name)) {
				System.out.println("userid is Mobile No");
				LoginMap loginMap = new LoginMap();
				loginMap.setLoginType("Mobile");
				loginMap.setLoginID(name);
				userid = userServiceObj.getUserIdByLoginType(loginMap);
				res = validateUser(userid, password);
				
			} else if (isValidAadharNo(name)) {
				System.out.println("userid is Aadhar No");
				LoginMap loginMap = new LoginMap();
				loginMap.setLoginType("Aadhar");
				loginMap.setLoginID(name);
				userid = userServiceObj.getUserIdByLoginType(loginMap);
				res = validateUser(userid, password);
				
			} else {
				
				res = validateUser(name, password);
				
				if (!res) {
					System.out.println("Invalid Input");				}
				}
		}

			if (res) {
				Cookie cookie = new Cookie("uname", name + "");
				Cookie cookiepass = new Cookie("upass", password + "");
				response.addCookie(cookie);
				response.addCookie(cookiepass);
				
				LoginMap loginMap = new LoginMap();
				userid = userServiceObj.getUserIdByLoginType(loginMap);

				out.print(name + " does exist");
				System.out.println("LOGIN SUCCESS for " + userid);
				response.sendRedirect("user-list.jsp");
			} else {
				System.out.println("Login failed for " + name);
				response.sendRedirect("userLogin.jsp");
			}
		}

	public static boolean isValidPanCardNo(String panCardNo) {
		String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
		Pattern p = Pattern.compile(regex);
		if (panCardNo == null) {
			return false;
		}
		Matcher m = p.matcher(panCardNo);
		return m.matches();
	}

	public static boolean isValidMobileNo(String mobile) {
		String regex = "[0-9]{10}";
		Pattern p = Pattern.compile(regex);
		if (mobile == null) {
			return false;
		}
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

	public static boolean isValidAadharNo(String aadhar) {
		String regex = "[0-9]{12}";
		Pattern p = Pattern.compile(regex);
		if (aadhar == null) {
			return false;
		}
		Matcher m = p.matcher(aadhar);
		return m.matches();
	}

	public static boolean validateUser(String userid, String password) {
		return userServiceObj.checkUser(userid, password);
	}
	
	
//	private void insertUser(HttpServletRequest request, HttpServletResponse response)
//	throws ServletException, IOException {
//
//String name = request.getParameter("name");
//String password = request.getParameter("password");
//
//request.getSession();
//response.getWriter();		
//
//String username = "";
//
//Cookie cookie[] = request.getCookies();
//for (Cookie c : cookie) {
//	if (c.getName().equals("uname")) {
//
//		username = c.getValue();
//		System.out.println("User added by " + username);
//
//		if (username.equals("admin"))
//			UserDao.insert(name, password);
//		else {
//			System.out.println("Only admin can add users");
//		}
//	}
//}
//
////System.out.println( "New user added by "+ session.getAttribute("uname").toString() );
////JOptionPane.showMessageDialog(null, "" + name +" added successfully");
////out.print("New user added by "+ session.getAttribute("uname").toString());
//
//response.sendRedirect("user-list.jsp");
//}

}
