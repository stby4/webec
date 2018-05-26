<article>
    <header>
        <span class="creator">${comment.creator}</span>
        <span class="created"><g:formatDate type="datetime" style="MEDIUM" timeStyle="SHORT"
                                            date="${comment.dateCreated}"/></span>

        <g:form method="DELETE" class="remove">
            <g:hiddenField name="id" value="${comment.id}"/>

            <button type="submit" name="_action_delete"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                <asset:image src="icons/icons8-trash-can.svg"/>
            </button>
        </g:form>
    </header>

    <div class="rating">
        <g:each in="${[0, 1, 2, 3, 4]}" var="i">
            <span class="star<g:if test="${comment.rating <= i}">full</g:if>"></span>
        </g:each>
    </div>

    <p>
        ${comment.text}
    </p>
</article>