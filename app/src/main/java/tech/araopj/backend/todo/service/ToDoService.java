package tech.araopj.backend.todo.service;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.model.Todo;

public class ToDoService {
    private DatabaseHelper databaseHelper;

    public ToDoService(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addToDo(Todo todo) {
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.getClassFields(todo.getClass()).get(0), todo.getTodo());
        contentValues.put(databaseHelper.getClassFields(todo.getClass()).get(1), String.valueOf(todo.getDeadline()));
        long insert = writableDatabase.insert(databaseHelper.getTABLE_NAME(), null, contentValues);
        Toast.makeText(databaseHelper.getContext(), insert != -1 ? "ToDo Added Successfully" : "Failed to Add ToDo", Toast.LENGTH_SHORT)
                .show();
    }
}
