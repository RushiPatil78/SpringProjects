
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.rushikesh.dto.Book;
import com.rushikesh.service.BookService;
import com.rushikesh.util.SpringUtil;

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		ApplicationContext applicationContext = SpringUtil.getApplicationContext();
		BookService bookService = applicationContext.getBean("bookServiceImpl", BookService.class);
		Book book=new Book();
		book.setId(1);
		book.setName(request.getParameter("name"));
		book.setCode(request.getParameter("code"));
		int i=bookService.save(book);
		if(i>0)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			out.println("Error");
		}
	}

}
