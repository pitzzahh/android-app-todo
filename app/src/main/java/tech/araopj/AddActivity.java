package tech.araopj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import tech.araopj.backend.database.DatabaseHelper;

public class AddActivity extends AppCompatActivity {

    private EditText todo;
    private EditText deadline;
    private Button addButton;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHelper = new DatabaseHelper(this);
        setContentView(R.layout.activity_add);

        todo = findViewById(R.id.todo);
        deadline = findViewById(R.id.deadline);
        addButton = findViewById(R.id.addButton);


    }

}