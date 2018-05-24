package exercise

import org.springframework.dao.DataIntegrityViolationException

// http://grails.asia/grails-tutorial-for-beginners-scaffolding/
class FieldController {
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def fields = Field.findAll()

        [fields: fields]
    }

    def create() {
        [field: new Field(params)]
    }

    def save() {
        def field = new Field(params)
        if (!field.save(flush: true)) {
            render(view: "create", model: [field: field])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'field.title', default: 'Field'), field.title])
        redirect(action: "index", id: field.id)
    }

    def delete(Long id) {
        def field = Field.get(id)
        if (!field) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index")
            return
        }
        try {
            field.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index", id: id)
        }
    }
}
