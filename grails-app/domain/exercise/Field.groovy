package exercise

class Field {
    public static final String WG = "Wiese / Grass"
    public static final String FF = "Felder / Fields"

    String title
    String image
    long lat
    long lon
    int msl
    String surface
    int length
    int width
    String direction
    String description
    Date lastUpdated

    def getCoordinates() {
        return Coordinates.toDms(lat, lon)
    }

    static hasMany = [comments: Comment]

    static mapping = {
        comments(sort:'dateCreated', order: 'desc')
    }

    static constraints = {
        title nullable: false
        image nullable: false
        lat nullable: false, range: -180..180
        lon nullable: false, range: -180..180
        msl nullable: false, range: -1000..9000
        length range: 1..99999
        width range: 1..9999
        direction nullable: false, range: 0..360
        description size: 2..9999
    }
}
