package tech.araopj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import tech.araopj.backend.model.Todo;
import androidx.appcompat.app.AppCompatActivity;
import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.todo.service.ToDoService;
import com.google.android.material.snackbar.Snackbar;

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
            boolean isValid = checkInputs(view, todo, deadline);
            if (isValid) toDoService.addToDo(new Todo(todo.getText().toString().trim(), deadline.getText().toString().trim()));
        });

    }

    private boolean checkInputs(View view, EditText todo, EditText deadline) {
        if(todo.getText().toString().isEmpty()) {
            Snackbar.make(view, "ToDo cannot be empty", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        if(deadline.getText().toString().isEmpty()) {
            Snackbar.make(view, "deadline cannot be empty", Snackbar.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}