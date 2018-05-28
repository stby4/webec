package exercise

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class FieldControllerSpec extends Specification implements ControllerUnitTest<FieldController>, DomainUnitTest<Field> {

    def setup() {
        new Field(
                title: "Reschenpaß",
                image: 'https://aussenlandefelder.files.wordpress.com/2008/06/reschenpass-20080608-02.jpg',
                lat: 51.1517,
                lon: 10.415,
                msl: 330,
                surface: Field.WG,
                length: 120,
                width: 35,
                direction: 340,
                bothDirections: false,
                description: 'Vergangenen Sonntag haben wir auch das Landefeld auf dem Reschenpaß besucht. Auf der Google-Maps-Seite erkennt man, daß da diverse Wassergräben quer zur Landerichtung liegen.\nDie Wiese scheint einigermaßen trocken zu sein – im Moment wachsen dort Butterblumen und die Gräser sind niedrig. Wenn darauf ein weißlich-heller Flaum zu sehen sein sollte, dann kann das schief gehen: Dann steht dort Schafgarbe und die Gräser stehen fast hüfthoch.'
        ).save(flush: true)

        new Field(
                title: "Reschenpassssss",
                image: 'https://aussenlandefelder.files.wordpress.com/2008/06/reschenpass-20080608-02.jpg',
                lat: 51.1517,
                lon: 10.415,
                msl: 330,
                surface: Field.WG,
                length: 120,
                width: 35,
                direction: 340,
                bothDirections: false,
                description: 'Vergangenen Sonntag haben wir auch das Landefeld auf dem Reschenpaß besucht. Auf der Google-Maps-Seite erkennt man, daß da diverse Wassergräben quer zur Landerichtung liegen.\nDie Wiese scheint einigermaßen trocken zu sein – im Moment wachsen dort Butterblumen und die Gräser sind niedrig. Wenn darauf ein weißlich-heller Flaum zu sehen sein sollte, dann kann das schief gehen: Dann steht dort Schafgarbe und die Gräser stehen fast hüfthoch.'
        ).save(flush: true)
    }

    def cleanup() {
    }

    void "Show existing fields"() {
        when: 'The index action is executed'
        controller.index()

        then: 'The model is correct'
        status == 200
//        model.fields
//        model.fields.size() == 2
//        model.fields.find { it.title == 'Reschenpaß' }
//        model.fields.find { it.title == 'Reschenpassssss' }
    }
}
