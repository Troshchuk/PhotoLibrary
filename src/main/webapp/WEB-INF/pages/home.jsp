<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<tiles:insertDefinition name="template">
    <tiles:putAttribute name="head"><link href="/resources/css/signin.css" rel="stylesheet"> </tiles:putAttribute>
    <tiles:putAttribute name="body">



        <div class="container">

            <form class="form-signin" role="form">
                <h2 class="form-signin-heading">Please sign in</h2>
                <input type="email" class="form-control" placeholder="Email address" required="" autofocus="">
                <input type="password" class="form-control" placeholder="Password" required="">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->



    </tiles:putAttribute>
</tiles:insertDefinition>