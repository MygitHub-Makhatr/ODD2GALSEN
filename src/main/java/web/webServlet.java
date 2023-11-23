package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/webServlet")
public class webServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        String userType = request.getParameter("type_acteur");

        if (validateUser(user, password, userType)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("acteur".equals(userType)) {
                // Redirect to lancer.jsp for actors
                response.sendRedirect(request.getContextPath() + "/lancer.jsp");
            } else if ("communaute".equals(userType)) {
                // Redirect to soumission.jsp for communities
                response.sendRedirect(request.getContextPath() + "/soumission.jsp");
            }  else {
            request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        }
    }

    private boolean validateUser(String user, String password, String userType) {
        try (Connection conn = SingletonConnection.getConnection()) {
            String query = "SELECT * FROM users WHERE utilisateur=? AND motdepasse=? AND typeactor=?";
            try (java.sql.PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, userType);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
