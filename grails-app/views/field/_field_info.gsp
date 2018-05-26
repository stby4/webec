<%@ page import="exercise.Coordinates" %>

<article>
    <header>
        <h2>${field.title}</h2>
        <g:form method="DELETE" class="remove">
            <g:hiddenField name="id" value="${field.id}"/>

            <button type="submit" name="_action_delete"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                <asset:image src="icons/icons8-trash-can.svg"/>
            </button>
        </g:form>
        <g:link action="edit" id="${field.id}"><asset:image src="icons/icons8-pencil-32.png"/></g:link>

        <p>${field.coordinates}, <g:message code="field.altitude.display" args="${field.msl}" default="{0} m ASL"/></p>
    </header>

    <div>
        <div>
            <img src="${field.image}" alt="${field.title}"/>
        </div>

        <div>
            <ul>
                <li>
                    <b><g:message code="field.length.display" default="Length"/></b>: <g:message
                        code="field.value.meter"
                        args="${field.length}"
                        default="{0} m"/>
                </li>
                <li>
                    <b><g:message code="field.width.display" default="Width"/></b>: <g:message code="field.value.meter"
                                                                                               args="${field.width}"
                                                                                               default="{0} m"/>
                </li>
                <li>
                    <b><g:message code="field.direction.display" default="Direction"/></b>: ${field.direction}°
                </li>
            </ul>
        </div>
    </div>

    <div>
        <p>
            ${field.description}
        </p>

        <h3><g:message code="field.rating.display" default="Average rating"/></h3>

        <div class="rating">
            <g:each in="${[0, 1, 2, 3, 4]}" var="i">
                <span class="star<g:if test="${field.getRating() <= i}">full</g:if>"></span>
            </g:each>
        </div>
    </div>

    <section>
        <h3><g:message code="comment.title.label" default="Comments"/></h3>
        <g:if test="${0 < field.comments.size()}">
            <g:render template="comment_embedded" collection="${field.comments}" var="comment"/>
        </g:if>
        <g:else>
            <span class="big-error">
                <g:message code="comment.none.found" default="Be the first to leave a comment"/>
            </span>
        </g:else>
    </section>
</article>