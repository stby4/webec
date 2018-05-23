package exercise

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
}
