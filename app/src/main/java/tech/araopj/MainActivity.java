package tech.araopj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import tech.araopj.backend.database.DatabaseHelper;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.booksRecyclerView);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(view -> {
            @NonNull Intent addActivity = new Intent(MainActivity.this, AddActivity.class);
            startActivity(addActivity);
        });
    }
}