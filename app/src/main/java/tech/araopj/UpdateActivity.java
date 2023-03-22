package tech.araopj;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import tech.araopj.backend.model.Todo;
import androidx.appcompat.app.AppCompatActivity;
import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.todo.service.ToDoService;

public class UpdateActivity extends AppCompatActivity {

    private EditText todo;
    private EditText deadline;
    private ToDoService toDoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        toDoService = new ToDoService(databaseHelper);
        setContentView(R.layout.activity_update);

        todo = findViewById(R.id.todo);
        deadline = findViewById(R.id.deadline);

        Button updateButton = findViewById(R.id.updateButton);
        updateButton.setOnClickListener(view -> {
            boolean isValid = InputHelper.checkInputs(view, todo, deadline);
            if (isValid) toDoService.updateTodo(new Todo(todo.getText().toString().trim(), deadline.getText().toString().trim()));
        });

        Button removeButton = findViewById(R.id.removeToDo);
        removeButton.setOnClickListener(view -> Log.d("remove_todo", "Remove todo"));
    }
}