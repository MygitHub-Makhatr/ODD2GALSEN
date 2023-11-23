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

@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		// TODO Auto-generated method stub
 		response.getWriter().append("Served at: ").append(request.getContextPath());
     }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des paramètres du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String typeActeur = request.getParameter("type_acteur");
        String password = request.getParameter("password");
        String nomUtilisateur = request.getParameter("nom_utilisateur");

        // Insertion dans la base de données
        if (insertUser(nom, prenom, mail, telephone, typeActeur, password, nomUtilisateur)) {
            response.sendRedirect(request.getContextPath() + "/createSuccess.jsp");
        } else {
            request.setAttribute("errorMessage", "Erreur lors de la création du compte");
            request.getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }

    private boolean insertUser(String nom, String prenom, String mail, String telephone,
            String typeActeur, String password, String nomUtilisateur) {
        try (Connection conn = SingletonConnection.getConnection()) {
            String query = "INSERT INTO users (nom, prenom, mail, tel, typeactor, motdepasse, utilisateur) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nom);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, mail);
                preparedStatement.setString(4, telephone);
                preparedStatement.setString(5, typeActeur);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, nomUtilisateur);

                int rowsAffected = preparedStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
