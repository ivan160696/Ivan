package info.goodline.department.learnandroid.recycler_view.google_play;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import info.goodline.department.learnandroid.R;

public class CategoryVH extends RecyclerView.ViewHolder {

    public TextView tvNameCategory;
    public Button btnMoreApp;
    public RecyclerView rvAppList;

    public CategoryVH(@NonNull View itemView) {
        super(itemView);
        tvNameCategory = itemView.findViewById(R.id.tvNameCategory);
        btnMoreApp = itemView.findViewById(R.id.btnMoreApp);
        rvAppList = itemView.findViewById(R.id.rvAppList);
    }
}