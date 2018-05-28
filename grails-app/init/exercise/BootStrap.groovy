package exercise

class BootStrap {

    def init = { servletContext ->

// https://aussenlandefelder.wordpress.com/2008/06/12/reschenpas/
        Field field1 = new Field(
                title: "Reschenpaß",
                image: 'https://aussenlandefelder.files.wordpress.com/2008/06/reschenpass-20080608-02.jpg',
                lat: 51.1517,
                lon: 10.511218,
                msl: 330,
                surface: Field.WG,
                length: 120,
                width: 35,
                direction: 340,
                bothDirections: false,
                description: 'Vergangenen Sonntag haben wir auch das Landefeld auf dem Reschenpaß besucht. Auf der Google-Maps-Seite erkennt man, daß da diverse Wassergräben quer zur Landerichtung liegen.\nDie Wiese scheint einigermaßen trocken zu sein – im Moment wachsen dort Butterblumen und die Gräser sind niedrig. Wenn darauf ein weißlich-heller Flaum zu sehen sein sollte, dann kann das schief gehen: Dann steht dort Schafgarbe und die Gräser stehen fast hüfthoch.'
        ).save(failOnError: true)

        new Comment(
                creator: 'Quax',
                text: 'Mein absolutes Lieblingslandefeld!',
                rating: 5,
                field: field1
        ).save(failOnError: true)

        new Comment(
                creator: 'Roter Baron',
                text: 'Die nächste Bar ist leider eine herbe Enttäuschung. Kein Aussenlandebier verfügbar 😒',
                rating: 2,
                field: field1
        ).save(failOnError: true)

// https://aussenlandefelder.wordpress.com/2008/06/10/st-maria/
        Field field2 = new Field(
                title: 'St. Maria im Münstertal (vom Vinschgau zum Ofenpaß)',
                image: 'https://aussenlandefelder.files.wordpress.com/2008/06/stmaria-20080608-03.jpg',
                lat: 46.63094,
                lon: 10.45348,
                msl: 800,
                surface: Field.WG,
                length: 300,
                width: 50,
                direction: 260,
                bothDirections: true,
                description: 'Westlich von Schluderns gibt es noch eine Außenlandemöglichkeit, die liegt aber relativ hoch und auch auf dieser Wiese stehen zwei Bewässerungsteile, wenn man aber richtig anfliegt und direkt hinter den Feldgrenzen aufsetzt hat man eine realistische Chance das Bewässerungsventil zu umrollen. Aus der Luft sieht man das mit Sicherheit nicht, aber nach dem Aufsetzen könnte man daran vorbeisteuern. Die Felder scheinen recht kleinteilig genutzt zu werden und die Chance ist groß, daß eines der Felder gerade abgeerntet wurde. Achtung, das Feld hat ein leichtes Gefälle zum Tal hin, das heißt man muß bei der Landung die Fläche hängen lassen.'
        ).save(failOnError: true)

        new Comment(
                creator: 'Otto Lilienthal',
                text: 'Dieses Landefeld hat mir schon einige Male das Leben gerettet, aber wie die Beschreibung schon sagt ist die Landung nicht ganz einfach.',
                rating: 4,
                field: field2
        ).save(failOnError: true)

        new Comment(
                creator: 'Chuck Yeager',
                text: 'Nur was für Profis. So wie mich. Wer hier nicht landen kann, gehört nicht in ein Flugzeug.',
                rating: 5,
                field: field2
        ).save(failOnError: true)

//        http://www.segelfliegen-wiesental.de/downloads/Aussenlandefelder_Suedschwarzwald_2006.pdf
        new Field(
                title: 'Wehr / Zelg',
                image: 'https://preview.ibb.co/jnKLtJ/wehr.png',
                lat: 47.6438889,
                lon: 7.9091667,
                msl: 380,
                surface: Field.WG,
                length: 300,
                width: 50,
                direction: 320,
                bothDirections: false,
                description: 'Landung nur in Richtung 32 da Gelände nach NW ansteigt. Pistenschwelle ist mit 2 weiss/roten Fässern markiert. Im Anflug Bäume! Der Querweg ist überrollbar.'
        ).save(failOnError: true)
    }



    def destroy = {

    }
}
