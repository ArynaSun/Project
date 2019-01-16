<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4" id="_header">
    <a class="navbar-brand" href="http://localhost:8080/controller?command=DISPLAY_WELCOME_PAGE">COURSES</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
            aria-controls="navbarCollapse" aria-expanded="true" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse show" id="navbarCollapse" style="">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <div id="change_language">
                        <jsp:include page="forms/change_language.jsp"/>
                        <hr>
                    </div>
                    <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">
                    <div id="server_message">
                        <jsp:include page="views/server_message.jsp"/>
                    </div></a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
    </div>
    <c:if test="${sessionScope.user != null}">
        <div id="logout">
            <jsp:include page="forms/logout.jsp"/>
            <hr>
        </div>
    </c:if>

    <c:if test="${false}">
        <div id="back">
            <jsp:include page="forms/back.jsp"/>
            <hr>
        </div>
    </c:if>
</nav>
