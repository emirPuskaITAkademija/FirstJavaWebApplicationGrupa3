import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Nećemo mi pozivati konstruktor te klase nego će to raditi ServletContainer
 * <p>
 * Servlet kontejner vodi računa o ŽIVOTNOM VIJEKU objekata.
 * <p>
 * <li> 1. init()-> poziva kada se kreira ovaj Servlet
 * POZIVA SE TAČNO JEDNOM. Jedan je FirstServlet objekat koji opslužuje mnoštvo klijenata.
 * <li> 2. doGet() -> GET Http request -> processRequest
 * <li> 3. doPost() -> POST Http request -> processRequest
 * <li> 4. destroy() -> prilikom uništavanja objekta iz memorije tj. connection.close()
 * @author grupa 1
 */
public class FirstServlet extends HttpServlet {

    //HTTP zahtjevu -> HttpServletRequest request
    //HTTP odgovor -> HttpServletResponse response -> browseru 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //SUŠTINA postojanja servleta je upravo pisanje ove metode koja radi request/response
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter();){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Web sajt generisan iz servleta</title>");
            out.println("</head>");
            out.println("<body>");
            LocalDateTime currentTime = LocalDateTime.now();
            out.println("<h1> Trenutno vrijeme: " + currentTime+"</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //GET /docs.html Http1.0
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    //POST /docs.html HTTP/1.0
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
