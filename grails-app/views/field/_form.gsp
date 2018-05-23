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

%{--Description--}%
<div class="${hasErrors(bean: field, field: 'description', 'error')}">
    <label for="description">
        <g:message code="field.description.label" default="Description"/>
    </label>
    <g:textField name="description" required="" value="${field?.description}"/>
</div>