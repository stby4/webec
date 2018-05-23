package exercise

class Comment {
    Date dateCreated
    String text
    boolean deleted

    static transients = ['deleted']

    static belongsTo = [field: Field]

    static constraints = {
        text nullable: false, size: 5..15000
    }
}
