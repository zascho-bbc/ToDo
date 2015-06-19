package ch.bbcag.todo.database;

/**
 * Created by zascho on 18.06.2015.
 */
public class AufgabeSQL {
    public static final String TABLE_AUFGABEN = "Aufgaben";
    private static final String KEY_ID = "id";
    // AUFGABEN Table - column nmaes
    public static final String AUFGABE_TITEL = "Titel";
    public static final String BESCHREIBUNG = "Beschreibung";
    public static final String ERINNERUNGSZEIT = "Erinngerungszeit";
    public static final String WICHTIGKEIT = "Wichtigkeit";

    public static String getSqlQueryForCreateTableAufgabe() {
        return "CREATE TABLE "
                + TABLE_AUFGABEN + "(" + KEY_ID + " INTEGER PRIMARY KEY," + AUFGABE_TITEL
                + " TEXT," + BESCHREIBUNG
                + " TEXT," + ERINNERUNGSZEIT + " INTEGER," + WICHTIGKEIT + " INTEGER)";
    }

    public static String getSqlQuerySelectAlleAufgaben() {
        return "SELECT * FROM TABLE "
                + TABLE_AUFGABEN;
    }
}