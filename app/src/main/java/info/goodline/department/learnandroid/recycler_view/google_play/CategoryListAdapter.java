package info.goodline.department.learnandroid.recycler_view.google_play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import info.goodline.department.learnandroid.R;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryVH> {

    public interface GooglePlayClickListener {
        void onMoreClicked(Category category);

        void onAppClicked(App app);
    }


    private CategoryListAdapter.GooglePlayClickListener clickListener;
    private List<Category> categories;
    Context context;

    public CategoryListAdapter(Context context, List<Category> categories, CategoryListAdapter.GooglePlayClickListener clickListener) {
        this.context = context;
        this.categories = categories;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_category_app, viewGroup, false);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH categoryVH, int position) {
        final Category category = categories.get(position);
        AppListAdapter appListAdapter = new AppListAdapter(context, category.getApps(), clickListener);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        categoryVH.rvAppList.setLayoutManager(layoutManager);
        categoryVH.rvAppList.setAdapter(appListAdapter);
        categoryVH.tvNameCategory.setText(category.getName());
        categoryVH.btnMoreApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onMoreClicked(category);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
