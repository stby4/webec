package mvc

class Comment {
    Date dateCreated
    String text

    static constraints = {
        text nullable: false, size: 5..15000
    }

    static mapping = {
        autoTimestamp true
    }
}