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

@WebServlet("/soumServlet")
public class soumServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String nomCommunaute = request.getParameter("nom_communaute");
        String region = request.getParameter("region");
        String typeBesoin = request.getParameter("type_besoin");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        String dateDemande = request.getParameter("date");


        // Insertion dans la base de données
        if (insertDemande(nomCommunaute, region, typeBesoin, quantite, dateDemande)) {
            response.sendRedirect(request.getContextPath() + "/demandeSuccess.jsp");
            System.out.println("c bon");   
        } else {
            request.setAttribute("errorMessage", "Erreur lors de la soumission de la demande");
            request.getRequestDispatcher("/soumission.jsp").forward(request, response);
            System.out.println("c op bon");  
        }
    }

    private boolean insertDemande(String nomCommunaute, String region, String typeBesoin, int quantite,
            String dateDemande) {
        try (Connection conn = SingletonConnection.getConnection()) {
            String query = "INSERT INTO demande_besoin_alimentaire (nom_communaute, region, type_besoin, quantite, date_demande) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomCommunaute);
                preparedStatement.setString(2, region);
                preparedStatement.setString(3, typeBesoin);
                preparedStatement.setInt(4, quantite);
                preparedStatement.setString(5, dateDemande);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
                   }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
