<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
.gradient-custom {
/* fallback for old browsers */
background: #6a11cb;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(176,224,230, 1), rgba(37, 117, 252, 1))
}

.mb-md-5 {
    margin-bottom: -4rem!important;
}
.vh-100 {
    height: 135vh!important;
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
          <a class="nav-link " aria-current="page" href="Home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link " href="Login.jsp">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="Register.jsp">Register</a>
        </li>
        
        </ul>
     </div>
  </div>
</nav>    

<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
			<%@include file="alerts/register.jsp" %>
            <div class="mb-md-5 mt-md-4 pb-5">
			<form action="Register">
              <h2 class="fw-bold mb-2 text-uppercase">user registration</h2>
              <br>
			<div class="form-outline form-white mb-4">
                <label class="form-label" for="name">Name</label>
                <input type="text" name="name" class="form-control form-control-lg" />
              </div>
              	
              <div class="form-outline form-white mb-4">
                <label class="form-label" for="uname">User Name</label>
                <input type="text" name="uname" class="form-control form-control-lg" />
              </div>
			
                <div class="form-outline form-white mb-4">
                <label class="form-label" for="mobile">Mobile Number</label>
                <input type="text" name="mobile" class="form-control form-control-lg" />
              </div>
              <div class="form-outline form-white mb-4">
                <label class="form-label" for="password">Password</label>
                <input type="password" name="password" class="form-control form-control-lg" />
              </div>

             <div class="form-outline form-white mb-4">
                <label class="form-label" for="gender">Gender</label><br>
                <input class="form-check-input" type="radio" name="gender" value="Male">Male&emsp;&emsp;&emsp;&emsp;
                <input class="form-check-input" type="radio" name="gender" value="Female">Female
                </div>

              <button class="btn btn-outline-light btn-lg px-5" type="submit" >Register</button>

            </form>
            <br>
			<div>
              <p class="mb-0">Already have an account? <a href="Login.jsp" class="text-white-50 fw-bold">Sign In</a>
              </p>
            </div>
            </div>

            

          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>