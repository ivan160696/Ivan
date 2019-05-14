package info.goodline.department.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import info.goodline.department.learnandroid.image.ImagePickActivity;
import info.goodline.department.learnandroid.local_storage.ChatListActivityKT;
import info.goodline.department.learnandroid.recycler_view.RecyclerViewExamplesActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLinearLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnRelativeLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnFrameLayoutScreen).setOnClickListener(this);
        findViewById(R.id.btnScrollViewScreen).setOnClickListener(this);
        findViewById(R.id.btnCardViewScreen).setOnClickListener(this);
        findViewById(R.id.btnWidgetsScreen).setOnClickListener(this);
        findViewById(R.id.btnFragmentScreen).setOnClickListener(this);
        findViewById(R.id.btnRecyclerViewScreen).setOnClickListener(this);
        findViewById(R.id.btnLocalStorage).setOnClickListener(this);
        findViewById(R.id.btnImagePickScreen).setOnClickListener(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("View и ViewGroup");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btnLinearLayoutScreen:
                intent = new Intent(this, LinearLayoutActivity.class);
                break;
            case R.id.btnRelativeLayoutScreen:
                intent = new Intent(this, RelativeLayoutActivity.class);
                break;
            case R.id.btnFrameLayoutScreen:
                intent = new Intent(this, FrameLayoutActivity.class);
                break;
            case R.id.btnScrollViewScreen:
                intent = new Intent(this, ScrollViewActivity.class);
                break;
            case R.id.btnCardViewScreen:
                intent = new Intent(this, CardViewActivity.class);
                break;
            case R.id.btnWidgetsScreen:
                intent = new Intent(this, WidgetsActivity.class);
                break;
            case R.id.btnFragmentScreen:
                intent = new Intent(this, FragmentLayoutActivity.class);
                break;
            case R.id.btnRecyclerViewScreen:
                intent = new Intent(this, RecyclerViewExamplesActivity.class);
                break;
            case R.id.btnLocalStorage:
                intent = new Intent(this, ChatListActivityKT.class);
                break;
            case R.id.btnImagePickScreen:
                intent = new Intent(this, ImagePickActivity.class);
                break;
        }

        if (intent == null) {
            return;
        }

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_favorite:
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
