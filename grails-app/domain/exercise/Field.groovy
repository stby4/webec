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
    boolean bothDirections
    String description
    Date lastUpdated

    def getCoordinates() {
        return Coordinates.toDms(lat, lon)
    }

    def getRating() {
        if (null == comments || 0 == comments.size()) {
            return 0
        }

        int avg = 0
        for (comment in comments) {
            avg += comment.rating
        }

        return Math.round(avg / comments.size())
    }

    static hasMany = [comments: Comment]

    static mapping = {
        comments(sort: 'dateCreated', order: 'desc')
    }

    static constraints = {
        title nullable: false
        image nullable: false
        lat nullable: false, range: -180..180
        lon nullable: false, range: -180..180
        msl nullable: false, range: -1000..9000
        length nullable: false, range: 1..99999
        width nullable: false, range: 1..9999
        direction nullable: false, range: 0..360
        bothDirections nullable: false
        description nullable: false, size: 2..9999
        comments(cascade: "all-delete-orphan")
    }
}
