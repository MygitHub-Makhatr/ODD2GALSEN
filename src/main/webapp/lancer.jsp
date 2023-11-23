<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lancement de Projet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #17223b; /* Dark Blue Background */
            color: #fff; /* White Text */
            margin: 0;
            padding: 0;
        }

        /* Style pour le formulaire */
        form {
            max-width: 600px;
            margin: 20px auto;
            background: #17223b; /* Dark Blue Form Background */
            padding: 20px;
            border: 06px inset lightblue;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Style pour les étiquettes */
        label {
            display: block;
            margin-bottom: 8px;
        }

        /* Style pour les champs de saisie */
        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        /* Style pour le bouton */
        .launch-button {
            width: 75%;
            background-color: #0f4c75; /* Dark Blue Button */
            color: #fff; /* White Text */
            padding: 10px 20px;
            border: none;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 10px;
            cursor: pointer;
        }

        /* Style pour le survol du bouton */
        .launch-button:hover {
            background-color: #3282b8; /* Slightly Lighter Blue on Hover */
        }
        .navbar-container {
            background-color: gray; /* Couleur bleue sombre de la bande */
        }

        .navbar {
            padding: 15px 20px;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }

        li {
            display: inline;
            margin-right: 20px;
        }

        a {
            text-decoration: none;
            color: #fff; /* Couleur du texte blanc */
            font-weight: bold;
            font-size: 16px;
            transition: color 0.3s ease; /* Transition pour un effet de changement de couleur en douceur */
        }

        a:hover {
            color: #66a3ff; /* Couleur bleue claire au survol */
        }
        #not{
        font-size:27px;
        }
    </style>
</head>
<body>
<center>
<div class="navbar-container">
<center>
        <nav class="navbar">
            <ul>
                <li><a id=not href="inf.jsp">Accueil</a></li>
                <li><a id=not href="#">projet</a></li>
                <li><a id=not href=communaute.html>Communauté</a></li>
                <li><a id=not href=acteur.html >Acteurs</a></li>
                <li><a id=not href="data.html">Données</a></li>
            </ul>
        </nav>
        </center>
        </div>
</center>
    <center>
    
        <div>
            <br>
            <h1>Lancement de Projet</h1><br>
            <form action="lanceServlet" method="post">
                <label for="nom_projet">Nom du Projet:</label>
                <input type="text" id="nom_projet" name="nom_projet" required>

                <label for="duree">Durée du Projet (en mois):</label>
                <input type="number" id="duree" name="duree" required>

                <label for="cible">Cible du Projet:</label>
                <input type="text" id="cible" name="cible" required>

                <label for="budget">Budget du Projet:</label>
                <input type="number" id="budget" name="budget" required>

                <label for="organisation">Organisation Porteuse:</label>
                <input type="text" id="organisation" name="organisation" required>

                <br>
                <br>
                <br>
                <input type="submit" class="launch-button" value="Lancer le Projet">
            </form>
        </div>
    </center>
</body>
</html>
