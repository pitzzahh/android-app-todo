package tech.araopj.backend.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tech.araopj.backend.model.Todo;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private final String TABLE_NAME = "todo";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "todo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("CREATE TABLE %s (", TABLE_NAME));
        List<String> classFields = getClassFields(Todo.class);
        for (int i = 0; i < classFields.size(); i++) {
            String classField = classFields.get(i);
            if (i == 0) {
                stringBuilder.append(String.format("%s %s PRIMARY KEY AUTOINCREMENT", classField, "INTEGER"));
            }
            stringBuilder.append(String.format("%s %s", classField, "TEXT"));
            if (i < classFields.size() - 1) {
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

    public List<String> getClassFields(Class<?> clazz) {
        List<String> columnNames = new ArrayList<>();
        for (Field field : clazz.getFields()) {
            columnNames.add(field.getName());
        }
        return columnNames;
    }

    public Context getContext() {
        return context;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }
}
