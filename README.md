# UniTunes

Arquitetura de Software 2014/2

    
## Add a Servlet

Create a file called HelloServlet.java in the src/main/java/servlet directory and put the following into it:

    :::java
    package servlet;
    
    import java.io.IOException;
    
    import javax.servlet.ServletException;
    import javax.servlet.ServletOutputStream;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    
    @WebServlet(
            name = "MyServlet", 
            urlPatterns = {"/hello"}
        )
    public class HelloServlet extends HttpServlet {
    
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            ServletOutputStream out = resp.getOutputStream();
            out.write("hello heroku".getBytes());
            out.flush();
            out.close();
        }
        
    }
    
This is simple Servlet that uses annotations to configure itself.

## Add a JSP

Create a file called index.jsp in the src/main/webapp directory:

    <html>
        <body>
            <h2>Hello Heroku!</h2>
        </body>
    </html>


# Deploy your Application to Heroku

Commit your changes to Git:

    :::term
    $ git add .
    $ git commit -m "Ready to deploy"


Deploy your code:

    :::term
    $ git push heroku master