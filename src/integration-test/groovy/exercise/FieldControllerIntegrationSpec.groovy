package exercise

import geb.spock.GebSpec
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.Specification

@Integration
@Rollback
class FieldControllerIntegrationSpec extends GebSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "visit homepage"() {
        go '/'
        expect: "Find articles"
        $('article').size() == 10
    }

    void "add a comment"() {
        when: 'Open homepage'
        go '/'
        $('a.add-comment')[0].click()
        then: 'show comment form'
        $('h2')[0].text().contains('Add a comment to')
        then: 'form is shown'
        $('form [name="creator"]').value('Tester')
        $('form [name="text"]').value('Fantastic field')
        $('form [name="rating"]').value(6)

        $('form .btn-primary').click()
        then: 'form has errors'
        $('form [name="rating"]').value(5)
        $('form .btn-primary').click()
        then: 'new comment has been added'
        $('article article')[1].find('.text').text().contains('Fantastic field')
    }

    void "add a new field"() {
        when: 'Open homepage'
        go '/'
        $('a.add-field')[0].click()
        then: 'show field form'
        $('h2')[0].text().contains('New Field')
        then: 'form is shown'
        $('form [name="title"]').value('Fantastic field')
        $('form [name="image"]').value('https://preview.ibb.co/jnKLtJ/wehr.png')
        $('form [name="lat"]').value(47)
        $('form [name="lon"]').value(11)
        $('form [name="msl"]').value(123)
        $('form [name="length"]').value(456)
        $('form [name="width"]').value(78)
        $('form [name="description"]').value('"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.')
        $('form .btn-primary').click()
        then: 'new field has been added'
        $('.alert-info').size() > 0
    }
}
