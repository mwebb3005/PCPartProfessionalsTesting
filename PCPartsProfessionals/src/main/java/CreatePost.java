import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

import util.ForumUtil;
import util.Info;

@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public CreatePost() {
      super();
   }

   
   
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String user = request.getParameter("user").trim();
      String titlePost = request.getParameter("title").trim();
      String body = request.getParameter("body").trim();
      String dateString = java.time.LocalDateTime.now().toString();
      String parent = request.getParameter("parent").trim();
      
        
      
      ForumUtil.createforumsTable(user, titlePost, body, dateString, parent);

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      out.println("<li> User: " + user);
      out.println("<li> title: " + titlePost);
      out.println("<li> body: " + body);
      out.println("<li> Date: " + dateString);
      out.println("<li> parent: " + parent);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + createListingsName + ">Create Forum Post</a> <br>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
