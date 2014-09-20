<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<tiles:insertDefinition name="template" >
    <tiles:putAttribute name="body" >
        <div class="container">
            <h2>Welcome</h2>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>