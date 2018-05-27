<%@ page import="org.springframework.validation.FieldError" %>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="comment.create.label" args="${comment.field.title}"/></title>
</head>

<body>
<div>
    <h2><g:message code="comment.create.label" args="${comment.field.title}"/></h2>
    <g:hasErrors bean="${comment}">
        <ul class="errors">
            <g:eachError bean="${comment}" var="error">
                <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>>
                    <g:message error="${error}"/>
                </li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="save">
        <g:render template="form"/>
        <g:submitButton name="create" value="${message(code: 'comment.button.create.label', default: 'Save comment')}"/>
    </g:form>
</div>
</body>
</html>