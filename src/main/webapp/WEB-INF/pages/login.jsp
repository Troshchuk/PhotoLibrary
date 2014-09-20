<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">


        <div class="container">

            <form class="form-signin" role="form" action="<c:url value='/j_spring_security_check' />" method="post">
                <h2 class="f1orm-signin-heading">Please sign in</h2>
                <input name="j_username" type="email" class="form-control"
                       placeholder="Email address" required="" autofocus="">
                <input name="j_password" type="password" class="form-control"
                       placeholder="Password" required="">

                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">
                    Sign in
                </button>

            </form>
            <form class="form-registration" action="/registration" role="form">
                <button class="btn btn-lg btn-block btn-success" type="submit">Registration</button>
            </form>

        </div>
        <!-- /container -->


    </tiles:putAttribute>
</tiles:insertDefinition>