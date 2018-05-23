<head>
    <meta name="layout" content="main"/>
    <title>Aussenlandekatalog</title>
</head>

<body>
<div>
    <g:if test="${fields.size > 0}">
        <g:render template="field_info" collection="${fields}" var="field"/>
    </g:if>
    <g:else>
        <span class="big-error">
            <g:message code="field.none.found" default="Sorry, we could not find any landing strips"/>
        </span>
    </g:else>
</div>
</body>