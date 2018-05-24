<%@ page import="exercise.Coordinates" %>

<div>
    <header>
        <h2>${field.title}</h2>

        <p>${field.coordinates}, <g:message code="field.altitude.display" args="${field.msl}" default="{0} m ASL"/></p>
    </header>

    <div>
        <div>
            <img src="${field.image}" alt="${field.title}"/>
        </div>

        <div>
            <ul>
                <li>
                    <b><g:message code="field.length.display" default="Length"/></b>: <g:message code="field.value.meter"
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
    </div>

    <div>
        <g:each in="${field.comments}" var="comment">
            ${comment.text}
        </g:each>
    </div>

    %{--<div class="rating">--}%
    %{--<g:each in="${[0, 1, 2, 3, 4]}" var="i">--}%
    %{--<span class="star<g:if test="${field.rating <= i}">full</g:if>"></span>--}%
    %{--</g:each>--}%
    %{--</div>--}%
</div>