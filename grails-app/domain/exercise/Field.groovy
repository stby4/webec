package exercise

class Field {
    public static final String WG = "Wiese / Grass"
    public static final String FF = "Felder / Fields"

    String title
    String image
    double lat
    double lon
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

    def getDistance(double fromLat, double fromLon) {
        // haversine formula from https://bigdatanerd.wordpress.com/2011/11/03/java-implementation-of-haversine-formula-for-distance-calculation-between-two-points/
        def r = 6371
        double p = Math.PI / 180
        double latDistance = (fromLat - lat) * p
        double lonDistance = (fromLon - lon) * p
        def a = Math.pow(Math.sin(latDistance / 2), 2) + Math.cos(lat * p) * Math.cos(fromLat * p) * Math.pow(Math.sin(lonDistance / 2), 2)
        def c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))
        def distance = r * c

        return distance
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
