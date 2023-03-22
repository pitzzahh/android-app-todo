package tech.araopj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.time.LocalDateTime;

import tech.araopj.backend.database.DatabaseHelper;
import tech.araopj.backend.model.Todo;
import tech.araopj.backend.todo.service.ToDoService;

public class AddActivity extends AppCompatActivity {

    private EditText todo;
    private EditText deadline;
    private Button addButton;

    private DatabaseHelper databaseHelper;
    private ToDoService toDoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(this);
        toDoService = new ToDoService(databaseHelper);
        setContentView(R.layout.activity_add);

        todo = findViewById(R.id.todo);
        deadline = findViewById(R.id.deadline);
        addButton = findViewById(R.id.addTodo);

        addButton.setOnClickListener(view -> {

        });

    }


}