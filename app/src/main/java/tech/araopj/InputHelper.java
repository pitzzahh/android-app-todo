package tech.araopj;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

public class InputHelper {

    public static boolean checkInputs(View view, EditText todo, EditText deadline) {
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
