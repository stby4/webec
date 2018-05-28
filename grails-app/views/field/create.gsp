<%@ page import="org.springframework.validation.FieldError" %>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="default.new.label" args="${[message(code: 'field.title', default: 'Field')]}"/></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h2><g:message code="default.new.label" args="${[message(code: 'field.title', default: 'Field')]}"/></h2>
            <g:hasErrors bean="${field}">
                <ul class="errors">
                    <g:eachError bean="${field}" var="error">
                        <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form method="POST">
                <g:render template="form"/>
                <g:actionSubmit name="create" action="save" value="${message(code: 'default.button.create.label')}"
                                class="btn btn-primary"/>
                <g:actionSubmit class="btn btn-secondary" action="index" formnovalidate=""
                                value="${message(code: 'default.button.cancel.label')}"/>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>