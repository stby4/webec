package exercise

import org.springframework.dao.DataIntegrityViolationException

class CommentController {
    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        def comments = Comment.findAll()

        [comments: comments]
    }

    def create(Long fieldid) {
        def field = Field.get(fieldid)
        def comment = new Comment(params)

        if(!field && !comment.field) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), fieldid])
            redirect(controller: "field", action: "index")
            return
        } else {
            comment.field = field
        }

        [comment: comment]
    }

    def save() {
        def comment = new Comment(params)
        if(!comment.save(flush: true)) {
            render(view: "create", model: [comment: comment])
            return
        }
        flash.message = message(code: 'comment.created.message')
        redirect(controller: "field", action: "index", id: comment.field.id)
    }

    def delete(Long id) {
        def comment = Comment.get(id)
        if (!comment) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'comment.title', default: 'Comment'), comment.id])
            redirect(controller: "field", action: "index")
            return
        }
        try {
            comment.delete(flush: true)
            flash.success = message(code: 'default.deleted.message', args: [message(code: 'comment.title', default: 'Comment'), comment.id])
            redirect(controller: "field", action: "index")
        }
        catch (DataIntegrityViolationException e) {
            flash.error = message(code: 'default.not.deleted.message', args: [message(code: 'comment.title', default: 'Comment'), comment.id])
            redirect(controller: "field", action: "index")
        }
    }
}
