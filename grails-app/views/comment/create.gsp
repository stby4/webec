<%@ page import="org.springframework.validation.FieldError" %>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="comment.create.label" args="${[comment.field.title]}"/></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h2><g:message code="comment.create.label" args="${[comment.field.title]}"/></h2>
            <g:hasErrors bean="${comment}">
                <ul class="errors">
                    <g:eachError bean="${comment}" var="error">
                        <li <g:if test="${error in FieldError}">data-field-id="${error.field}"</g:if>>
                            <g:message error="${error}"/>
                        </li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form method="POST">
                <g:render template="form"/>
                <g:actionSubmit name="create" action="save" class="btn btn-primary"
                                value="${message(code: 'comment.button.create.label', default: 'Save comment')}"/>
                %{--<g:actionSubmit class="btn btn-secondary" action="_field_index" formnovalidate=""--}%
                                %{--value="${message(code: 'default.button.cancel.label')}"/>--}%
            </g:form>
        </div>
    </div>
</div>
</body>
</html>