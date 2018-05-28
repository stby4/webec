package exercise

import org.springframework.dao.DataIntegrityViolationException

/**
 * Controller for comments
 */
class CommentController {
    static allowedMethods = [save: "POST", delete: "DELETE"]

    /**
     * redirect to field/index
     * @return
     */
    def index() {
        redirect(controller: "field", action: "index")
    }

    /**
     * form to create a new comment
     * @param fieldid id of commented field
     * @return
     */
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

    /**
     * validate form and save to db
     * @return
     */
    def save() {
        def comment = new Comment(params)
        if(!comment.save(flush: true)) {
            render(view: "create", model: [comment: comment])
            return
        }
        flash.message = message(code: 'comment.created.message')
        redirect(controller: "field", action: "index", id: comment.field.id)
    }

    /**
     * delete comment
     * @param id of the comment
     * @return
     */
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
