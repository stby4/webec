<%@ page import="exercise.Coordinates" %>

<article class="container">
    <header>
        <div class="row">
            <h2>${field.title}</h2>
        </div>

<div class="row">
    <p>${field.coordinates}, <g:message code="field.altitude.display" args="${field.msl}"
                                        default="{0} m ASL"/></p>
</div>
</header>

<div class="row">
    <div class="col">
        <img class="preview rounded img-fluid" src="${field.image}" alt="${field.title}"/>
    </div>
</div>

<div class="row">
    <div class="col">
        <ul>
            <li>
                <b><g:message code="field.length.display" default="Length"/></b>: <g:message
                    code="field.value.meter"
                    args="${field.length}"
                    default="{0} m"/>
            </li>
            <li>
                <b><g:message code="field.width.display" default="Width"/></b>: <g:message
                    code="field.value.meter"
                    args="${field.width}"
                    default="{0} m"/>
            </li>
            <li>
                <b><g:message code="field.direction.display" default="Direction"/></b>: ${field.direction}°
            </li>
        </ul>
    </div>
</div>
</div>

<div class="row">
    <div class="col">
        <p>
            ${field.description}
        </p>
    </div>
</div>

<div class="row">
    <div class="col">
        <h3><g:message code="field.rating.display" default="Average rating"/></h3>
    </div>
</div>

<div class="row">
    <div class="col">
        <div class="rating">
            <g:each in="${[0, 1, 2, 3, 4]}" var="i">
                <span class="star<g:if test="${field.getRating() > i}">full</g:if>"></span>
            </g:each>
        </div>
    </div>
</div>


<div class="row">
    <div class="col btn-group" role="group">
        <g:form method="DELETE" class="remove">
            <g:hiddenField name="id" value="${field.id}"/>

            <button type="submit" name="_action_delete" class="btn btn-secondary"
                    onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">
                <g:message code="default.button.delete.label"/>
            </button>
        </g:form>
        <g:link action="edit" id="${field.id}">
            <button type="button" class="btn btn-secondary">
                <g:message code="default.button.edit.label"/>
            </button>
        </g:link>
    </div>
</div>

<section>
    <div class="row">
        <div class="col">
            <h3><g:message code="comment.title.label" default="Comments"/></h3>
        </div>
    </div>

    <div class="row">
        <article class="col card">
            <div class="card-body">
                <h3><g:message code="comment.add.title"/></h3>
                <g:link controller="comment" action="create" class="btn btn-primary btn-lg"
                        params="${[fieldid: field.id]}">
                    <g:message code="comment.text.label"/>
                </g:link>
            </div>
        </article>
    </div>

    <g:if test="${0 < field.comments.size()}">
        <g:render template="/comment/comment_embedded" collection="${field.comments}" var="comment"/>
    </g:if>
    <g:else>
        <span class="big-error">
            <g:message code="comment.none.found" default="Be the first to leave a comment"/>
        </span>
    </g:else>
</section>
</article>