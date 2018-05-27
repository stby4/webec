<head>
    <meta name="layout" content="main"/>
    <title><g:message code="app.title"/></title>
</head>

<body>
<g:if test="${fields.size > 0}">
    <g:render template="field_info" collection="${fields}" var="field"/>
</g:if>
<g:else>
    <div class="container">
        <span class="big-error">
            <g:message code="field.none.found" default="Sorry, we could not find any landing strips"/>
        </span>
    </div>
</g:else>
</body>