package tech.araopj.backend.database;

import android.util.Log;
import android.content.Context;
import java.lang.reflect.Field;
import androidx.annotation.Nullable;
import tech.araopj.backend.model.Todo;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private final Context context;
    private final String TABLE_NAME = "todo";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "todo.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("CREATE TABLE %s(", TABLE_NAME));
        Field[] classFields = getClassFields(Todo.class);
        for (int i = 0; i < classFields.length; i++) {
            Field classField = classFields[i];
            if (classField.getName().equals("id")) {
                stringBuilder.append(String.format("%s %s PRIMARY KEY AUTOINCREMENT", classField.getName(), "INTEGER"), 0, 0);
            }
            else stringBuilder.append(String.format("%s %s", classField.getName(), "TEXT"));
            if (i < classFields.length - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(");");

        String QUERY = stringBuilder.toString();
        Log.d("create_table", QUERY);
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Field[] getClassFields(Class<?> clazz) {
        return clazz.getDeclaredFields();
    }

    public Context getContext() {
        return context;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
