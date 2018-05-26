<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="cleartype" content="on"/>

    <title>
        <g:layoutTitle default="Aussenlandekatalog"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>
<g:if test="${flash.message}">
    <div class="alert alert-info">${flash.message}</div>
</g:if>
<g:if test="${flash.success}">
    <div class="alert alert-success">${flash.success}</div>
</g:if>
<g:if test="${flash.error}">
    <div class="alert alert-warning">${flash.error}</div>
</g:if>
<g:layoutBody/>

<asset:javascript src="application.js"/>
</body>
</html>
