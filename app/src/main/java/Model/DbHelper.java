package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



/** sql database helper class, adapted from DrBFraser code on youtube. found at https://youtu.be/Aui-kFuXFYE
 * Created by Taylor Rose on 4/7/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    // ----------------------------
    // ---------- Constants and Data
    // ----------------------------

    //for logging:
    private static final String TAG = "DbHelper";

    // Database name
    private static final String DATABASE_NAME = "pill_model_database";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String PILL_TABLE = "pills";
    private static final String ALARM_TABLE = "alarms";
    private static final String PILL_ALARM_LINKS = "pill_alarm";

    // Common column name and location
    public static final String KEY_ROWID = "id";
    public static final int COL_ROWID = 0;

    // Pill table columns
    private static final String KEY_PILLNAME = "pillName";

    // Alarm table columns
    private static final String KEY_ALARM_ID = "alarm_id";
    private static final String KEY_INTENT = "intent";
    private static final String KEY_HOUR = "hour";
    private static final String KEY_MINUTE = "minute";
    private static final String KEY_AM_PM = "am_pm";
    private static final String KEY_DAY_WEEK = "day_of_week";

    // Pill-Alarm link table columns
    private static final String KEY_PILLTABLE_ID = "pill_id";
    private static final String KEY_ALARMTABLE_ID = "alarm_id";

    // --------------------------------------------------
    // ------- statements to create tables --------------
    // --------------------------------------------------

    // Pill Table : create statement
    private static final String CREATE_PILL_TABLE = "create table " +
            PILL_TABLE + "(" + KEY_ROWID + " integer primary key," +
            KEY_PILLNAME + " text" + ")";

    // Alarm Table : create statement
    private static final String CREATE_ALARM_TABLE = "create table " +
            ALARM_TABLE + "(" + KEY_ROWID + " integer primary key," +
            KEY_ALARM_ID + " integer," + KEY_INTENT + " text," +
            KEY_HOUR + " integer," + KEY_MINUTE + " integer," +
            KEY_AM_PM + " text," + KEY_DAY_WEEK + " integer" + ")";

    // Pill-Alarm link table: create statement
    private static final String CREATE_PILL_ALARM_LINKS_TABLE = "create table " +
            PILL_ALARM_LINKS + "(" + KEY_ROWID + " integer primary key," +
            KEY_PILLTABLE_ID + " integer," + KEY_ALARMTABLE_ID + " integer" + ")";

    // Constructor
    DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating tables
        db.execSQL(CREATE_PILL_TABLE);
        db.execSQL(CREATE_ALARM_TABLE);
        db.execSQL(CREATE_PILL_ALARM_LINKS_TABLE);
    }

    @Override
    // TODO: change this so that updating doesn't delete old data
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + PILL_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + ALARM_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PILL_ALARM_LINKS);

        // create new tables
        onCreate(db);
    }

    // --------------------------------------------
    // -------------- Individual Table Methods ----
    // --------------------------------------------

    // Create Methods

    public long createPill(Pill pill, long[] alarm_ids){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PILLNAME, pill.getPillName());

        // insert row
        long pill_id = db.insert(PILL_TABLE, null, values);

        // assigning alarms to pill ??
        for (long alarm_id : alarm_ids){
            createPillAlarmLink(pill_id, alarm_id);
        }

        return pill_id;
    }

    public long createAlarm(Alarm alarm){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // TODO: need to serialize intent
        //values.put(KEY_INTENT, alarm.getIntent());
        values.put(KEY_HOUR, alarm.getHour());
        values.put(KEY_MINUTE, alarm.getMinute());
        values.put(KEY_AM_PM, alarm.getAm_pm());
        values.put(KEY_DAY_WEEK, alarm.getDayOfWeek());

        //insert row
        long alarm_id = db.insert(ALARM_TABLE, null, values);

        return alarm_id;
    }

    public long createPillAlarmLink(long pill_id, long alarm_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PILLTABLE_ID, pill_id);
        values.put(KEY_ALARMTABLE_ID, alarm_id);

        //insert row
        long pillAlarmLink_id = db.insert(PILL_ALARM_LINKS, null, values);

        return pillAlarmLink_id;
    }
}
