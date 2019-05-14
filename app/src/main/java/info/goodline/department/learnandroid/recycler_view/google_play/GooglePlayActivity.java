package info.goodline.department.learnandroid.recycler_view.google_play;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.List;

import info.goodline.department.learnandroid.DataBaseHelper;
import info.goodline.department.learnandroid.R;

public class GooglePlayActivity extends AppCompatActivity implements CategoryListAdapter.GooglePlayClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_play);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Google Play");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        List<Category> categories = DataBaseHelper.getGooglePlayApps();
        CategoryListAdapter categoryListAdapter = new CategoryListAdapter(this, categories, this);
        RecyclerView recyclerView = findViewById(R.id.rvAppCategoryList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(categoryListAdapter);
    }

    @Override
    public void onMoreClicked(Category category) {
        Toast.makeText(this, category.getName() + " -> еще приложения", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAppClicked(App app) {
        Toast.makeText(this, "Открыть: " + app.getName(), Toast.LENGTH_SHORT).show();
    }
}
