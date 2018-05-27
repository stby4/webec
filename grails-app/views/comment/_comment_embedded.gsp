<div class="row">
<article class="col card">
    <div class="card-body">
        <header>
            <span class="creator">${comment.creator}</span>
            <span class="created"><g:formatDate type="datetime" style="MEDIUM" timeStyle="SHORT"
                                                date="${comment.dateCreated}"/></span>
        </header>

        <div class="rating">
            <g:each in="${[0, 1, 2, 3, 4]}" var="i">
                <span class="star<g:if test="${comment.rating > i}">full</g:if>"></span>
            </g:each>
        </div>

        <p>
            ${comment.text}
        </p>

        <g:form method="DELETE" class="remove" controller="comment" action="delete">
            <g:hiddenField name="id" value="${comment.id}"/>

            <button type="submit" name="_action_delete" class="btn btn-secondary"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                <g:message code="default.button.delete.label"/>
            </button>
        </g:form>
    </div>
</article>
</div>