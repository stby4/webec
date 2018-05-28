package exercise

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CommentControllerSpec extends Specification implements ControllerUnitTest<CommentController>, DomainUnitTest<Comment> {
    Field field

    def setup() {
        field = new Field(
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
    }

    def cleanup() {
        field = null
    }

    void "test save comment"() {
        when:
        request.method = 'POST'
        request.contentType = FORM_CONTENT_TYPE
        params['creator'] = 'Eve'
        params['text'] = 'Lorem ipsum'
        params['rating'] = 1
        params['field'] = 1
        controller.save()

        then: 'flash message that comment has been saved'
        flash.message

        and: 'the user is redirected to show the student'
        response.redirectedUrl.startsWith('/?id=1')

        and: 'a found response code is used'
        response.status == 302

    }
}
