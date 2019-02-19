
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AltaUsuario")
public class AltaUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String nombre=request.getParameter("name");
        String apellido=request.getParameter("surname");
        String direccion=request.getParameter("street");
        String poblacion=request.getParameter("city");
        String provincia=request.getParameter("capitalcity");
        String cp=request.getParameter("cp");
        String rs=request.getParameter("rs");
        String email=request.getParameter("mail");
        String pc=request.getParameter("contact");

        PrintWriter out = response.getWriter();

        if (request.getParameter("name").isEmpty() || request.getParameter("surname").isEmpty() ||
                request.getParameter("mail").isEmpty()||!request.getParameter("mail").contains("@")||
                request.getParameter("name").length()>20 ||request.getParameter("rs").length()>20 ||
                request.getParameter("contact").length()>20 ||request.getParameter("street").length()>20 ||
                request.getParameter("city").length()>20 ||request.getParameter("capitalcity").length()>20 ||
                Integer.parseInt(cp)< 30000 || Integer.parseInt(cp)> 50000){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"ISO-8859-1\">");
            out.println("<title>Formulario Alumnado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"AltaUsuario\" method=\"get\">");
            if (request.getParameter("name").isEmpty()||request.getParameter("name").length()>20)
                out.println("<font size=2 color=\"red\" face=\"MS Sans Serif\">*Nombre:</font><input type=\"text\" name=\"name\" value="+nombre+">");
            else {
                out.println("<font size=2 face=\"MS Sans Serif\">*Nombre:</font><input type=\"text\" name=\"name\" value="+nombre+" >");
            }
            if(request.getParameter("surname").isEmpty()||request.getParameter("surname").length()>20) {
                out.println("<font size=2 color=\"red\" face=\"MS Sans Serif\">*Apellido:</font><input type=\"text\" name=\"surname\" value="+apellido+">");
            }else {
                out.println("<font size=2 face=\"MS Sans Serif\">*Apellido:</font><input type=\"text\" name=\"surname\" value="+apellido+">");
            }
            out.println("<br></br>");
            if(request.getParameter("street").length()>20) {
                out.println("<font size=2 color=\"red\"> Dirección:</font><input type=\"text\" name=\"street\" value="+direccion+">");
            }else {
                out.println("<font size=2> Dirección:</font><input type=\"text\" name=\"street\" value="+direccion+">");
            }
            if (request.getParameter("city").length()>20) {
                out.println("<font size=2 color=\"red\">Población:</font><input type=\"text\" name=\"city\" value="+poblacion+">");
            }else {
                out.println("<font size=2> Población:</font><input type=\"text\" name=\"city\" value="+poblacion+">");
            }
            out.println("<br></br>");
            if(request.getParameter("capitalcity").length()>20) {
                out.println("<font size=2 color=\"red\">Província:</font><input type=\"text\" name=\"capitalcity\" value="+provincia+">");
            }else {
                out.println("<font size=2> Província:</font><input type=\"text\" name=\"capitalcity\" value="+provincia+">");
            }
            if (!request.getParameter("cp").isEmpty()){
                if((Integer.parseInt(cp)< 30000) || (Integer.parseInt(cp)> 50000)){
                    out.println("<font size=2 color=\"red\"> C.P.:</font><input type=\"number\" name=\"cp\" value="+cp+">");
                }
                else {
                    out.println("<font size=2> C.P.:</font><input type=\"number\" name=\"cp\" value="+cp+">");
                }
            }else {
                out.println("<font size=2> C.P.:</font><input type=\"number\" name=\"cp\" value="+cp+">");
            }
            out.println("<br></br>");
            if(request.getParameter("rs").length()>20) {
                out.println("<font size=2 color=\"red\"> Razón Social:</font><input type=\"text\" name=\"rs\" value="+rs+">");
            }
            else {
                out.println("<font size=2> Razón Social:</font><input type=\"text\" name=\"rs\" value="+rs+">");
            }
            if(!request.getParameter("mail").contains("@")) {
                out.println("<font size=2 color=\"red\" face=\"MS Sans Serif\">*Email:</font><input type=\"email\" name=\"mail\" value="+email+">");
            }
            else {
                out.println("<font size=2 face=\"MS Sans Serif\">*Email:</font><input type=\"email\" name=\"mail\" value="+email+">");
            }
            out.println("<br></br>");
            if(request.getParameter("contact").length()>20) {
                out.println("<font size=2 color=\"red\">Persona de Contacto:</font><input type=\"text\" name=\"contact\" value="+pc+">");
            }
            else {
                out.println("<font size=2> Persona de Contacto:</font><input type=\"text\" name=\"contact\" value="+pc+">");
            }
            out.println("<br></br>");
            out.println("<input type=\"submit\" value=\"Enviar\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        }else{
            mostrarPagina(out,request);
        }

    }

    private void mostrarPagina(PrintWriter out,HttpServletRequest request) {

        // TODO Auto-generated method stub

        String boton="<input type=\"button\" value=\"Inicio\" onclick=\"window.location.href='./index.html'\" />";

        out.println("<html>");
        out.println("<head>");
        out.println("<body>");
        out.println("Usuario: <b>alumno</b>");
        out.println("<br></br>");
        out.println("Nombre: "+ request.getParameter("name"));
        out.println("<br></br>");
        out.println("Apellido: "+ request.getParameter("surname"));
        out.println("<br></br>");
        out.println("Mail: "+ request.getParameter("mail"));
        out.println("<br></br>");
        if (!request.getParameter("street").isEmpty()){
            out.println("Dirección: "+ request.getParameter("street"));
            out.println("<br></br>");
        }
        if (!request.getParameter("city").isEmpty()){
            out.println("Población: "+ request.getParameter("city"));
            out.println("<br></br>");
        }
        if (!request.getParameter("capitalcity").isEmpty()){
            out.println("Provincia: "+ request.getParameter("capitalcity"));
            out.println("<br></br>");
        }
        if (!request.getParameter("cp").isEmpty()){
            out.println("C.P.: "+ request.getParameter("cp"));
            out.println("<br></br>");
        }
        if (!request.getParameter("rs").isEmpty()){
            out.println("Razón social: "+ request.getParameter("rs"));
            out.println("<br></br>");
        }
        if (!request.getParameter("contact").isEmpty()){
            out.println("Persona de Contacto: "+ request.getParameter("contact"));
            out.println("<br></br>");
        }
        out.println("Datos introducidos correctamente!");
        out.println("<br></br>");
        out.println(boton);
        out.println("</body></html>");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}
