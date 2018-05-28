<%@ page import="exercise.Coordinates" %>

<article class="container field-info">
    <header>
        <div class="row">
            <div class="col">
                <h2>${field.title} <g:if
        test="${null != lat && null != lon}">(${Math.round(field.getDistance(lat, lon))} km)</g:if></h2>

<p>
    %{--point.latitude_longitude_titleString_notesString_linkURL_photoURL--}%
    <a href="https://bing.com/maps/default.aspx?sp=point.${field.lat}_${field.lon}_${field.title}_${field.description}_${link(controller: 'field', action: 'index', id: field.id)}_${field.image}"
       target="_blank">${field.coordinates}</a>,
<g:message code="field.altitude.display" args="${field.msl}" default="{0} m ASL"/>
</p>
</div>
</div>
</header>

<div class="row">
    <div class="col">
        <div class="image-container preview rounded">
            <img class="img-fluid" src="${field.image}" alt="${field.title}"/>
        </div>
    </div>
</div>

<div class="row">
    <div class="col">
        <table class="table">
            <thead>
            <tr>
                <th>
                    <g:message code="field.length.display" default="Length"/>
                </th>
                <th>
                    <g:message code="field.width.display" default="Width"/>
                </th>
                <th>
                    <g:message code="field.direction.display" default="Direction"/>
                </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>
                    <g:message
                            code="field.value.meter"
                            args="${field.length}"
                            default="{0} m"/>
                </th>
                <th>
                    <g:message
                            code="field.value.meter"
                            args="${field.width}"
                            default="{0} m"/>
                </th>
                <th>
                    ${field.direction}° <g:if test="${field.bothDirections}">/ ${(field.direction + 180) % 360}</g:if>
                </th>
            </tr>
            </tbody>
        </table>
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
        <article class="col">
            <div class="card">
                <div class="card-body">
                    <h3><g:message code="comment.add.title"/></h3>
                    <g:link controller="comment" action="create" class="btn btn-primary btn-lg add-comment"
                            params="${[fieldid: field.id]}">
                        <g:message code="comment.text.label"/>
                    </g:link>
                </div>
            </div>
        </article>

        <g:if test="${0 < field.comments.size()}">
            <g:render template="/comment/comment_embedded" collection="${field.comments}" var="comment"/>
        </g:if>

    </div>
    %{--<g:else>--}%
    %{--<span class="big-error">--}%
    %{--<g:message code="comment.none.found" default="Be the first to leave a comment"/>--}%
    %{--</span>--}%
    %{--</g:else>--}%
</section>
</article>