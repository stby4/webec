package exercise

import org.springframework.dao.DataIntegrityViolationException

// http://grails.asia/grails-tutorial-for-beginners-scaffolding/
class FieldController {
    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        def fields = []
        Long lat = null
        Long lon = null

        fields.sort()

        if (params.containsKey('lat') && params.containsKey('lon')) {
            lat = params.double('lat')
            lon = params.double('lon')

            fields = Field.findAll()

            fields.sort({ a, b -> a.getDistance(lat, lon) <=> b.getDistance(lat, lon) } as Comparator)
        } else if (params.id) {
            def field = Field.get(params.long('id'))


            if (field) {
                fields.add(field)
            }
        }

        if (1 > fields.size()) {
            fields = Field.findAll()
        }

        [fields: fields, lat: lat, lon: lon]
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

    def edit(Long id) {
        def field = Field.get(id)
        if (!field) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index")
            return
        }
        [field: field]
    }

    def update(Long id, Long version) {
        def field = Field.get(id)
        if (!field) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index")
            return
        }

        if (null != version) {
            if (field.version > version) {
                fields.errors.rejectValue("version", "default.optimistic.locking.failure",
                        [message(code: 'field.title', default: 'Field')] as Object[],
                        'Another user has updated this Field while you were editing)')
                render(view: 'edit', model: [field: field])
                return
            }
        }

        field.properties = params
        if (!field.save(flush: true)) {
            render(view: 'edit', model: [field: field])
            return
        }
        flash.success = message(code: 'default.updated.message', args: [message(code: 'field.title'), field.title])
        redirect(action: 'index', id: field.id)
    }

    def delete(Long id) {
        def field = Field.get(id)
        if (!field) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), field.title])
            redirect(action: "index")
            return
        }
        try {
            field.delete(flush: true)
            flash.success = message(code: 'default.deleted.message', args: [message(code: 'field.title', default: 'Field'), field.title])
            redirect(action: "index")
        }
        catch (DataIntegrityViolationException e) {
            flash.error = message(code: 'default.not.deleted.message', args: [message(code: 'field.title', default: 'Field'), field.title])
            redirect(action: "index", id: id)
        }
    }
}
