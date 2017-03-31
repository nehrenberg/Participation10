package css.cis3334.nehrenberg.participation10;

/**
 * Created by nehrenberg on 3/31/2017
 * This class sets up the database and opens the connection
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_COMMENTS = "comments"; //sets up a constant for the table of comments to be used in the SQL command
    public static final String COLUMN_ID = "_id";   // sets up a constant for the id for the SQL command
    public static final String COLUMN_COMMENT = "comment";  // sets up a constant for the comments to be used in the SQL command

    private static final String DATABASE_NAME = "commments.db"; // sets up a constant string value for the database name
    private static final int DATABASE_VERSION = 1;  // sets up a constant for the version that is used by MySQLiteHelper

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";

    // creates the MySQLiteHelper object pulling the database name and version
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // sets up so when the program starts it will create and execute the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        // Standard SQL command
        // CREATE TABLE table(id integer primary key autoincrement, Name String);
        database.execSQL(DATABASE_CREATE);
    }

    // upgrades the database version and will destroy all the old data in the database, drops all existing tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}
