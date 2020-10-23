package curso.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.repositorio.CursoRepo;

@WebServlet("/RemoverTopico")
public class RemoverTopico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idCurso = Long.parseLong( request.getParameter("idCurso"));
		//Long idTopico = Long.parseLong(request.getParameter("idTopico"));
		String[] idsTopico = request.getParameterValues("idsTopico[]");
		CursoRepo repo = new CursoRepo();
		for(String id : idsTopico) {
			Long data = Long.parseLong(id);
			System.out.println(data);
			repo.excluir(data);
		}
		//repo.excluir(idTopico);

		response.sendRedirect("/java-web-curso/ListarTopicos?idCurso=" + idCurso);
	}

}
