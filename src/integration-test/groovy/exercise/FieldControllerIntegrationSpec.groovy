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
        $('article').size() == 8
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

        $('form .btn-primary[name="create"]').click()
        then: 'form has errors'
        $('form [name="rating"]').value(5)
        $('form .btn-primary[name="create"]').click()
        then: 'new commant has been added'
        $('article article')[1].find('.text').text().contains('Fantastic field')
    }

    void "add a new field"() {
        when: 'Open homepage'
        go '/'
        $('a.add-field')[0].click()
        then: 'show field form'
        $('h2')[0].text().contains('Create new')
        then: 'form is shown'
        $('form [name="title"]').value('Tester')
        $('form [name="image"]').value('Fantastic field')
        $('form [name="lat"]').value(6)
        $('form [name="lon"]').value(6)
        $('form [name="msl"]').value(6)
        $('form [name="length"]').value(6)
        $('form [name="width"]').value(6)

        $('form .btn-primary[name="create"]').click()
        then: 'form has errors'
        $('form [name="rating"]').value(5)
        $('form .btn-primary[name="create"]').click()
        then: 'new commant has been added'
        $('article article')[1].find('.text').text().contains('Fantastic field')
    }
}
