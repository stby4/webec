<div>
    <h2>${field.title}</h2>

    <div>
        <asset:image src="${field.image}" alt="${field.title}"/>
    </div>

    <div>
        <p>
            ${field.description}
        </p>
    </div>

    <div class="rating">
        <g:each in="${[0, 1, 2, 3, 4]}" var="i">
            <span class="star<g:if test="${field.rating <= i}">full</g:if>"></span>
        </g:each>
    </div>
</div>