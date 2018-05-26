package exercise

import org.springframework.dao.DataIntegrityViolationException

class CommentController {
    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index() {
        def comments = Comment.findAll()

        [comments: comments]
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
