<%@ page import="exercise.Field" %>

%{--Title--}%
<div class="${hasErrors(bean: field, field: 'title', 'error')}">
    <label for="title">
        <g:message code="field.title.label" default="Title"/>
    </label>
    <g:textField name="title" required="" value="${field?.title}"/>
</div>

%{--Image--}%
<div class="${hasErrors(bean: field, field: 'image', 'error')}">
    <label for="image">
        <g:message code="field.image.label" default="Image URL"/>
    </label>
    <g:textField name="image" required="" value="${field?.image}"/>
</div>

%{--Latitude--}%
<div class="${hasErrors(bean: field, field: 'lat', 'error')}">
    <label for="lat">
        <g:message code="field.lat.label" default="Latitude"/>
    </label>
    <g:field type="number" step="0.000000000001" name="lat" required="" value="${field?.lat}"/>
</div>

%{--Longitude--}%
<div class="${hasErrors(bean: field, field: 'lon', 'error')}">
    <label for="lon">
        <g:message code="field.lon.label" default="Longitude"/>
    </label>
    <g:field type="number" step="0.000000000001" name="lon" required="" value="${field?.lon}"/>
</div>

%{--Altitude--}%
<div class="${hasErrors(bean: field, field: 'msl', 'error')}">
    <label for="msl">
        <g:message code="field.msl.label" default="Altitude above mean sea level [m]"/>
    </label>
    <g:field type="number" name="msl" required="" value="${field?.msl}"/>
</div>

%{--Surface--}%
<div class="${hasErrors(bean: field, field: 'surface', 'error')}">
    <label for="surface">
        <g:message code="field.surface.label" default="Surface"/>
    </label>
    <g:select name="surface" from="${[Field.WG, Field.FF]}"/>
</div>

%{--Length--}%
<div class="${hasErrors(bean: field, field: 'length', 'error')}">
    <label for="length">
        <g:message code="field.length.label" default="Length [m]"/>
    </label>
    <g:field type="number" name="length" value="${field?.length}"/>
</div>

%{--Width--}%
<div class="${hasErrors(bean: field, field: 'width', 'error')}">
    <label for="width">
        <g:message code="field.width.label" default="Width [m]"/>
    </label>
    <g:field type="number" name="width" value="${field?.width}"/>
</div>

%{--Direction--}%
<div class="${hasErrors(bean: field, field: 'direction', 'error')}">
    <label for="direction">
        <g:message code="field.direction.label" default="Direction [°]"/>
    </label>
    <g:field type="number" name="direction" required="" min="0" max="360" value="${field?.direction}"/>
</div>

%{--Description--}%
<div class="${hasErrors(bean: field, field: 'description', 'error')}">
    <label for="description">
        <g:message code="field.description.label" default="Description"/>
    </label>
    <g:textField name="description" required="" value="${field?.description}"/>
</div>