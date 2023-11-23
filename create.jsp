<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/login.css"/>
    <style>
        /* Add styling for the "Sign Up" button */
        .signup-button {
        
            width: 75%;    
            background-color: lightblue;
            color: black;
            padding: 10px 20px;
            border: none;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 10px;
            cursor: pointer;
        }

        /* Add styling for the form */
        .signup-form {
            margin-top: 20px; /* Add some space between the login form and signup form */
        }

        /* Add styling for the form inputs */
        .signup-form input {
            padding: 8px; /* Add padding to the input fields */
            margin-bottom: 10px; /* Add space between the input fields */
        }
       
    /* Style pour la liste déroulante */
    .signup-form select {
        padding: 8px; /* Ajoutez du padding à la liste déroulante */
        margin-bottom: 10px; /* Ajoutez de l'espace en dessous de la liste déroulante */
        width: 100%; /* Faites en sorte que la liste déroulante prenne la largeur complète */
        box-sizing: border-box; /* Gardez la largeur totale incluant les bordures et les rembourrages */
    }
</style>
    <title>CONNECTION</title>
</head>
<body>
    <center>
        <br>
        <br>
            <!-- Signup Form -->
            <div class="signup-form"><br>
            <br>
            <h1>Creation de compte</h1>
            
                <form action="insertServlet" method="post">
                    <input name="nom" type="text" placeholder="Nom"><br>
                    <input name="prenom" type="text" placeholder="Prenom"><br>
                    <input name="mail" type="text" placeholder="Mail"><br>
                    <input name="telephone" type="text" placeholder="Telephone"><br>
       <select name="type_acteur" class="signup-dropdown">
    <option value="communaute">Communauté</option>
    <option value="acteur">Acteur</option>
</select><br><br>
                    <input name="password" type="password" placeholder="Mot_de_Passe"><br>
                    <input name="nom_utilisateur" type="text" placeholder="Nom_Utilisateur"><br>
                    <br>
                      <input type="submit" class="signup-button" value="Créer compte">
                </form>
        </div>
    </center>
</body>
</html>
    