package mvc

class Card {
    public static final String WG = "Wiese / Grass"
    public static final String FF = "Felder / Fields"

    String title
    Coordinates coordinates
    String country
    String surface
    int length
    int width
    String direction
    String description
    int rating
    List<Comment> comments
    Date lastUpdated

    static constraints = {
        title nullable: false
        coordinates nullable: false
        country length: 2, nullable: false
        surface inList: [WG]
        length range: 1..99999
        width range: 1..9999
        direction nullable: false
        description length: 2..9999
        rating range: 0..5
    }

    static mapping = {
        autoTimestamp true
    }
}
