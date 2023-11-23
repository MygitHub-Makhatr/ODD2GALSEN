package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lanceServlet")
public class lanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String nomProjet = request.getParameter("nom_projet");
        int duree = Integer.parseInt(request.getParameter("duree"));
        String cible = request.getParameter("cible");
        int budget = Integer.parseInt(request.getParameter("budget"));
        String organisation = request.getParameter("organisation");

        // Insertion dans la base de données
        if (insertProjet(nomProjet, duree, cible, budget, organisation)) {
            response.sendRedirect(request.getContextPath() + "/projetSuccess.jsp");
            System.out.println("C'est bon");
        } else {
            request.setAttribute("errorMessage", "Erreur lors du lancement du projet");
            request.getRequestDispatcher("/lancementProjet.jsp").forward(request, response);
            System.out.println("C'est pas bon");
        }
    }

    private boolean insertProjet(String nomProjet, int duree, String cible, int budget, String organisation) {
        try (Connection conn = SingletonConnection.getConnection()) {
            String query = "INSERT INTO projets (nom_projet, duree, cible, budget, organisation) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomProjet);
                preparedStatement.setInt(2, duree);
                preparedStatement.setString(3, cible);
                preparedStatement.setInt(4, budget);
                preparedStatement.setString(5, organisation);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
