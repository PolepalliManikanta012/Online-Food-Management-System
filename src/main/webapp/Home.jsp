
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

  <head>

    <meta charset="UTF-8" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">




    <title>Home</title>
    <style>
  .homeslides{
    width:80%;
    height:550px;
    position :absolute;
    left: 10%;
    right:10%;
    top:15%;
    transform :translate (-50%,-50%);
    background-color : white;
    background-size :100% 100%;
    box-shadow:1px 2px 10px 5px gray;
    animation : slider 10s infinite linear;
    background-image : url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Zm9vZHxlbnwwfDB8MHx8&auto=format&fit=crop&w=600&q=60');
    }
    @keyframes slider{ 
        0%{ background-image : url('https://images.unsplash.com/photo-1455619452474-d2be8b1e70cd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTZ8fGZvb2R8ZW58MHwwfDB8fA%3D%3D&auto=format&fit=crop&w=600&q=60');
       }
      35%{background-image :url('https://images.unsplash.com/photo-1657299156653-d3c0147ba3ee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxzZWFyY2h8MXx8ZWF0fGVufDB8MHwwfGdyZWVufA%3D%3D&auto=format&fit=crop&w=600&q=60')}
      75%{background-image :url('https://images.unsplash.com/photo-1568031813264-d394c5d474b9?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8bWVudXxlbnwwfDB8MHx8&auto=format&fit=crop&w=600&q=60')}
    }
    
    
 
</style>
 
  </head>

  <body>

  
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">KL FOOD COURT</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarColor01">
      <ul class="navbar-nav me-auto my-2 my-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="Login.jsp">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="Admin/AdminLogin.jsp"> Admin Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Register.jsp">Register</a>
        </li>
        </ul>
     </div>
  </div>
</nav>    

<div class="homeslides">
 </div>
  </body>

</html>