package exercise

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class FieldSpec extends Specification implements DomainUnitTest<Field> {
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

    void "test coordinates string generation"() {
        expect: "coordinates"
        "51° 9′ 6″ N 10° 24′ 53″ E" == field.getCoordinates()
    }

    void "test distance calculation"() {
        expect: "zero distance"
        0 == field.getDistance(51.1517, 10.415)
    }

    void "test another distance calculation"() {
        expect: "some distance"
        463 < field.getDistance(47, 11) && 464 > field.getDistance(47, 11)
    }

    void "test zero ratings"() {
        expect: "zero rating"
        0 == field.getRating()
    }

    void "test average rating"() {

        new Comment(
                creator: 'Quax',
                text: 'Mein absolutes Lieblingslandefeld!',
                rating: 5,
                field: field
        ).save(flush: true)

        new Comment(
                creator: 'Roter Baron',
                text: 'Die nächste Bar ist leider eine herbe Enttäuschung. Kein Aussenlandebier verfügbar 😒',
                rating: 2,
                field: field
        ).save(flush: true)

        expect: "comment length"
        4 == field.rating
    }
}
