package tech.araopj;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import tech.araopj.backend.model.Todo;
import androidx.appcompat.app.AppCompatActivity;
import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.todo.service.ToDoService;

public class AddActivity extends AppCompatActivity {

    private EditText todo;
    private EditText deadline;
    private ToDoService toDoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        toDoService = new ToDoService(databaseHelper);
        setContentView(R.layout.activity_add);

        todo = findViewById(R.id.todo);
        deadline = findViewById(R.id.deadline);
        Button addButton = findViewById(R.id.addTodo);

        addButton.setOnClickListener(view -> {
            boolean isValid = InputHelper.checkInputs(view, todo, deadline);
            if (isValid) toDoService.addToDo(new Todo(todo.getText().toString().trim(), deadline.getText().toString().trim()));
        });

    }

}