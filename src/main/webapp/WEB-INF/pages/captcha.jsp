<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>403</title>
  <meta name="msapplication-TileColor" content="#5bc0de" />
  <meta name="msapplication-TileImage" content="assets/img/metis-tile.png" />

  <!-- Bootstrap -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.1/css/bootstrap.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.min.css">

  <!-- Metis core stylesheet -->
  <link rel="stylesheet" href="assets/css/main.min.css">
</head>
<body class="error">
<div class="container">
  <div class="col-lg-8 col-lg-offset-2 text-center">
    <div class="logo">
      <h1>Captcha</h1>
    </div>
    <p class="lead text-muted">Please enter captcha</p>
    <div class="clearfix"></div>
    <div class="col-lg-6 col-lg-offset-3">
      <form action="<c:url value='/verify_captcha' />" method="post">
        <div class="input-group">
          <label>Captcha: ${random} - ${random - answer} = </label>
          <input type="text" placeholder="captcha ..." class="form-control" name="captcha" required>
              <span class="input-group-btn">
              <button class="btn btn-default" type="submit"><i class="fa fa-caret-right"></i></button>
            </span>
        </div>
      </form>
    </div>
    <div class="clearfix"></div>
    <br>
  </div><!-- /.col-lg-8 col-offset-2 -->
</div>
</body>
</html>