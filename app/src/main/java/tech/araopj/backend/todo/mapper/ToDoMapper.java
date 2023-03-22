package tech.araopj.backend.todo.mapper;

import android.content.Context;
import androidx.annotation.Nullable;
import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.model.Todo;

public class ToDoMapper extends DatabaseHelper {

    public ToDoMapper(@Nullable Context context) {
        super(context);
    }

    @Nullable // TODO: implement
    public Todo mapRow() {
        return null;
    }

}
