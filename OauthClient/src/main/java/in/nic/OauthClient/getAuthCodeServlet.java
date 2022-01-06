package in.nic.OauthClient;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getAuthCodeServlet
 */

public class getAuthCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath() + "\n");
		PrintWriter out = response.getWriter();	
		out.println("Test OUT");
		
		ResourceBundle rbOauth = ResourceBundle.getBundle("oauth");
		
		
//		requests.get("http://example.com/api/params", params=payload)
		
		
//		List<NameValuePair> params = new ArrayList<>();
//		params.add(new queryParameters("clientId", "value1"));
//		params.add(new queryParameters("param2", "value2"));
//
//		String query = getQuery(params);
//		URL url = new URL("http://localhost:8080/api" + "?" + query);
//		URLConnection connection = url.openConnection();
		
		String testUrl = "clientId=" + rbOauth.getString("clientId") +
							 "redirectURI=" + rbOauth.getString("redirectURI")   +
							 "scope=" + rbOauth.getString("scope") +
							 "codeChallenge=" + rbOauth.getString("codeChallengeMethod") +
							 "codeChallengeMethod=" + rbOauth.getString("codeChallengeMethod") + 
							 "responseType=" + rbOauth.getString("responseType") +
							 "state=" + rbOauth.getString("state") ;


//		String testUrl = "v1/assets/login.html?";
		
//		String oauthParams = "clientId=OauthTestParichay";
		
//		System.out.println(rbOauth.getString("BASE_URL") + oauthParams);
//		response.sendRedirect(rbOauth.getString("BASE_URL") + oauthParams);
		response.sendRedirect(rbOauth.getString("BASE_URL") + "?" + testUrl);
		
//		getAuthCode()
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response, int isReqForParichay)
			throws ServletException, IOException {

}
}
