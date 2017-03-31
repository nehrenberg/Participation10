package css.cis3334.nehrenberg.participation10;

/**
 * Created by nehrenberg on 3/31/2017
 * Class sets up the Comment object, Uses a get and set for the comment and ID
 */

public class Comment {

    private long id;    // constant for the id
    private String comment; // constant for the comment

    // This method gets the ID
    public long getId() {
        return id;
    }

    // This method sets the ID the parameter passes
    public void setId(long id) {
        this.id = id;
    }

    // This method gets the comment
    public String getComment() {
        return comment;
    }

    // This method sets the comment that the parameter passes
    public void setComment(String comment) {
        this.comment = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return comment;
    }
}
