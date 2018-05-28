package exercise

import org.springframework.dao.DataIntegrityViolationException

/**
 * Controller for fields, the main application
 * based on http://grails.asia/grails-tutorial-for-beginners-scaffolding/
 */
class FieldController {
    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    /**
     * list all fields, sort by distance, or show individual field
     * @return
     */
    def index() {
        def fields = []
        Double lat = null
        Double lon = null

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

    /**
     * create new field, show form
     * @return
     */
    def create() {
        [field: new Field(params)]
    }

    /**
     * validate form and save to db
     * @return
     */
    def save() {
        def field = new Field(params)
        if (!field.save(flush: true)) {
            render(view: "create", model: [field: field])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'field.title', default: 'Field'), field.title])
        redirect(action: "index", id: field.id)
    }

    /**
     * show prefilled form to update existing field
     * @param id of the field
     * @return
     */
    def edit(Long id) {
        def field = Field.get(id)
        if (!field) {
            flash.error = message(code: 'default.not.found.message', args: [message(code: 'field.title', default: 'Field'), id])
            redirect(action: "index")
            return
        }
        [field: field]
    }

    /**
     * validate input and update db
     * @param id of the field
     * @param version of the field, for optimistic locking
     * @return
     */
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

    /**
     * delete field
     * @param id of the field to be deleted
     * @return
     */
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
