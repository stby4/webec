package exercise

class Comment {
    Date dateCreated
    String creator
    String text
    int rating
    boolean deleted

    static transients = ['deleted']

    static belongsTo = [field: Field]

    static constraints = {
        creator nullable: false, size: 3..50
        text nullable: false, size: 5..15000
        rating nullable: false, range: 0..5
    }
}
