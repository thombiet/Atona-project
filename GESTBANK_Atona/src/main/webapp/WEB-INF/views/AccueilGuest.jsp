<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style_Accueil_guest.css" />
    <title>GestBank - Acceuil/Guest</title>
    <script src="jquery-3.1.0.js"></script>

</head>

<body>
    <div id="bloc_page">
        <header>
         <div id="Presentation">
            <h1>Bienvenue chez 
                <br>Gest Bank</h1>
            </div>
            <div id"logo">
                <img src="GestBank logo.png" alt="Logo GestBank" height="100px" /> </div>
                <div id="Identification" style="text-align: right">
                    <form>
                         <p><input type="text" id="Identifiant" placeholder="Identifiant" />
                        <input type="text" id="mdp" placeholder="Mot de Passe"/>
                       <a href="#" class="myButton">Connexion</a></p>
                    </form>
                    <p>Pas encore de compte?  &nbsp   <a href="#" class="myButton">Insrivez-vous</a></p>
                </div>
               
            </header>
            <div id="contact">
              <div id="aide"><p><a href="#" class="myButton">Nous contacter</a>
             <a href="#" class="myButton">?</a> </p></div>
             <div id="social"><p><a href="https://facebook.com" ><img src="facebook.png" alt="Facebook" /></a> 
             <a href="https://plus.google.com" ><img src="google+.png" alt="Google+"/></a>
             <a href="https://twitter.com" ><img src="twitter.png" alt="Twitter" /></a></p></div>
         </div>
         <br>
         <br>
         <br>
         <div id="convertisseur"> 
            <div id="convertisseur_banniere"><h2>Convertisseur en Ligne</h2></div>
        </div>

        <footer>
            <div id="infoBank">
                <h1>Actu Gest Bank</h1>
                <p>blabla</p>
                <p>blabla</p>
            </div>
            <div id="Offres">
                <h1>Offres Promotionnelles</h1>
                <p><img src="images/photo1.jpg" alt="Photographie" /><img src="images/photo2.jpg" alt="Photographie" /><img src="images/photo3.jpg" alt="Photographie" /></p>
            </div>
            <div id="Pub">
                <h1>Publicités</h1>
            </div>
        </footer>
    </div>


<jsp:include page="PiedDePage.jsp"></jsp:include>
</body>
<script src="explorationDOM.js"></script>

</html>
