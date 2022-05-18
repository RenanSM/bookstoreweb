<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Bookstore Website</title>
    </head>
    <body>
        <div style="text-align: center;">
            <h1 style="color: red; font-family: sans-serif">Admin Login</h1>
            <form action="login" method="post" style="color: brown; font-family: sans-serif">
                <label for="email">Email:</label>
                <input name="email" size="30" />
                <br><br>
                <label for="password">Password:</label>
                <input type="password" name="password" size="30" />
                <!--
                Esse atributo MESSAGE será utilizado como retorno de 
               mensagem ao usuário caso
                login inválido.
                -->
                <br>${message}<br><br> 
                <button type="submit">Login</button>
            </form>
                
        </div>
              
              <!---------<p a="/bsuser/new" style="color: blue">Não se registrou ainda? Clique aqui.</p>-->
    </body>
</html>