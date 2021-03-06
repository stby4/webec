<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="default.edit.label" args="${[message(code: 'field.title', default: 'Field')]}"/></title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col">
            <h2><g:message code="default.edit.label" args="${[message(code: 'field.title', default: 'Field')]}"/></h2>
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
                <g:hiddenField name="id" value="${field?.id}"/>
                <g:hiddenField name="version" value="${field?.version}"/>

                <g:render template="form"/>

                <g:actionSubmit class="btn btn-primary" action="update"
                                value="${message(code: 'default.button.update.label')}"/>
                <g:actionSubmit class="btn btn-secondary" action="index" formnovalidate=""
                                value="${message(code: 'default.button.cancel.label')}"/>
                <g:actionSubmit class="btn btn-secondary" action="delete"
                                value="${message(code: 'default.button.delete.label')}"
                                formnovalidate=""
                                onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
            </g:form>
        </div>
    </div>
</div>
</body>
</html>