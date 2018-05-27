<%@ page import="exercise.Comment" %>

%{--Creator--}%
<div class="${hasErrors(bean: comment, field: 'creator', 'error')}">
    <label for="creator">
        <g:message code="comment.creator.label" default="Your name"/>
    </label>
    <g:textField name="creator" required="" value="${comment?.creator}"/>
</div>

%{--Text--}%
<div class="${hasErrors(bean: comment, field: 'text', 'error')}">
    <label for="text">
        <g:message code="comment.text.label" default="Your comment"/>
    </label>
    <g:textField name="text" required="" value="${comment?.text}"/>
</div>

%{--Rating--}%
<div class="${hasErrors(bean: comment, field: 'rating', 'error')}">
    <label for="rating">
        <g:message code="comment.rating.label" default="Rate this field"/>
    </label>
    <g:field type="number" name="rating" required="" value="${comment?.rating}" min="0" max="5"/>
</div>

<g:hiddenField name="field" value="${comment?.field.id}"/>