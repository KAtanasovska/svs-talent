package WebCalculator.webCalculator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calculate")
public class WebCalculator extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.seavus.hellowebworld.HelloWebWorldServlet.doGet");
		calculateNumbers(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("com.seavus.hellowebworld.HelloWebWorldServlet.doPost");
		calculateNumbers(req, resp);
	}

	private void calculateNumbers(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		final String first = req.getParameter("firstNumber");
		final String second = req.getParameter("secondNumber");
		final String operator = req.getParameter("operator");
		//resp.setContentType("text/html");
		int firstNumber = Integer.parseInt(first);
		int secondNumber = Integer.parseInt(second);
		int result;
		HttpSession httpSession = req.getSession();
		if(operator.equals("+")){
			result=firstNumber+secondNumber;
			resp.getWriter().println("the result is:  " + result);
			Transaction transaction = new Transaction(firstNumber, secondNumber, operator, result);
			httpSession.setAttribute("", transaction);
		}
		else if (operator.equals("-")){
			result=firstNumber-secondNumber;
			resp.getWriter().println("the result is:  " + result);
			Transaction transaction = new Transaction(firstNumber, secondNumber, operator, result);
			httpSession.setAttribute("", transaction);
		}
		else {
			resp.getWriter().println("Operacijata ne e poddrzana");
		}
		
		
		
	}
	
	

}
