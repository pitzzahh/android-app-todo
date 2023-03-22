package tech.araopj.backend.todo.service;

import android.widget.Toast;
import android.database.Cursor;
import android.content.ContentValues;
import tech.araopj.backend.model.Todo;
import android.database.sqlite.SQLiteDatabase;
import tech.araopj.backend.database.DatabaseHelper;

public class ToDoService {

    private final DatabaseHelper databaseHelper;

    public ToDoService(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void addToDo(Todo todo) {
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(databaseHelper.getClassFields(todo.getClass())[1].getName(), todo.getTodo());
        contentValues.put(databaseHelper.getClassFields(todo.getClass())[0].getName(), todo.getDeadline());
        long insert = writableDatabase.insert(databaseHelper.getTABLE_NAME(), null, contentValues);
        Toast.makeText(
                        databaseHelper.getContext(),
                        insert != -1 ? String.format("%s ToDo Added Successfully", todo.getTodo()) :
                                String.format("Failed to Add %s ToDo", todo.getTodo()), Toast.LENGTH_LONG
                )
                .show();
    }

    public Todo[] getTodoList() {
        SQLiteDatabase readableDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(
                String.format("SELECT * FROM %s", databaseHelper.getTABLE_NAME()),
                null
        );
        int count = cursor.getCount();
        Todo[] todoList = new Todo[count];
        for (int i = 0; i < count; i++) {
            todoList[i] = new Todo(cursor.getInt(2), cursor.getString(1), cursor.getString(0));
        }
        cursor.close();
        return todoList;
    }

    public void updateTodo(Todo todo) {
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(databaseHelper.getClassFields(todo.getClass())[1].getName(), todo.getTodo());
        contentValues.put(databaseHelper.getClassFields(todo.getClass())[0].getName(), todo.getDeadline());

        Todo[] todoList = getTodoList();
        int count = todoList.length;

        int indexOf = 0;
        for (int i = 0; i < count; i++) {
            if (todoList[i].equals(todo)) {
                indexOf = i;
                break;
            }
        }

        Todo oldTodo = todoList[indexOf];

        long update = writableDatabase.update(
                databaseHelper.getTABLE_NAME(),
                contentValues,
                "id = ?",
                new String[]{String.valueOf(oldTodo.getId())}
        );
        Toast.makeText(
                        databaseHelper.getContext(),
                        update != -1 ? String.format("%s ToDo Updated Successfully", todo.getTodo()) :
                                String.format("Failed to Update %s ToDo", todo.getTodo()), Toast.LENGTH_LONG
                )
                .show();
    }

    public void removeTodo(Todo todo) {
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        int delete = writableDatabase.delete(databaseHelper.getTABLE_NAME(), "id = ?", new String[]{String.valueOf(todo.getId())});
        Toast.makeText(
                        databaseHelper.getContext(),
                        delete != -1 ? String.format("%s ToDo Deleted Successfully", todo.getTodo()) :
                                String.format("Failed to Delete %s ToDo", todo.getTodo()), Toast.LENGTH_LONG
                )
                .show();
    }
}
