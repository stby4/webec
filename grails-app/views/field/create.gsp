<%@ page import="org.springframework.validation.FieldError" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>
<div>
    <h2><g:message code="field.create.label"/></h2>
    <g:if test="${flash.message}">
        <div class="flash-message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${field}">
        <ul class="errors">
            <g:eachError bean="${field}" var="error">
                <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="save">
        <g:render template="form"/>
        <g:submitButton name="create" value="${message(code: 'default.button.create.label')}"/>
    </g:form>
</div>
</body>
</html>