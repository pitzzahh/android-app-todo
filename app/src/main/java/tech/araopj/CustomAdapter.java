package tech.araopj;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CardHolder> {

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    protected static class CardHolder extends RecyclerView.ViewHolder {

        public CardHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
