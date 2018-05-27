<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="cleartype" content="on"/>

    <title>
        <g:layoutTitle code="app.title"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<div class="jumbotron">
    <div class="container">
        <h1 class="display-4"><g:message code="app.title"/></h1>

        <p class="lead"><g:message code="app.lead"/></p>
        <hr class="my-4">
        <a href="/field/index" id="locate" class="btn btn-primary btn-lg" role="button"><g:message
                code="field.start.search.label"/></a>
    </div>
</div>


<g:if test="${flash.message}">
    <div class="alert alert-info"><div class="container">${flash.message}</div></div>
</g:if>
<g:if test="${flash.success}">
    <div class="alert alert-success"><div class="container">${flash.success}</div></div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-warning"><div class="container">${flash.error}</div></div>
</g:if>

<g:layoutBody/>

<asset:javascript src="application.js"/>
</body>
</html>
