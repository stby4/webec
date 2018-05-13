package mvc

class Comment {
    Date created
    String text

    static constraints = {
        created(validator: {val, obj -> val?.before(new Date())})
        text size: 5..15000
    }
}