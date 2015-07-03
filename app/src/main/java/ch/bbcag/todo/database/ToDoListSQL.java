package ch.bbcag.todo.Database;

/**
 * Created by zascho on 18.06.2015.
 */
public class ToDoListSQL {
    public static final String TABLE_LISTEN = "Listen";
    private static final String KEY_ID = "id";
    private static final String FAVORITEN = "Favoriten";
    // TODOLISTE Table - column nmaes
    public static final String LISTE_NAME = "Listenname";

    public static String getSqlQueryForCreateTableToDoList() {
        return "CREATE TABLE "
                + TABLE_LISTEN + "(" + KEY_ID + " INTEGER PRIMARY KEY," + LISTE_NAME
                + " TEXT, " + FAVORITEN + " INTEGER)";
    }

    public static String getSqlQuerySelectAlleAufgaben() {
        return "SELECT * FROM  "
                + TABLE_LISTEN;
    }
    public static String getSqlQueryAddListToFavorites(String liste){
        return "UPDATE " + TABLE_LISTEN + " SET "+ FAVORITEN +" = 1 WHERE " +LISTE_NAME +" =";
    }

    public static String getSqlQuerySelectForeignKey(String liste) {
        return "SELECT " + KEY_ID + " FROM " + TABLE_LISTEN + " WHERE " + LISTE_NAME + " = '" + liste + "';";
    }

    public static String getSqlQueryListName(int foreignKey) {
        return "SELECT " + LISTE_NAME + " FROM " + TABLE_LISTEN + " WHERE " + KEY_ID + " = '" + foreignKey + "';";
    }
}
