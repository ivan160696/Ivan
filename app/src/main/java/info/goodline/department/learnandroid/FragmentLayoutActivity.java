package info.goodline.department.learnandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FragmentLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_layout);
        findViewById(R.id.btnUserListActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserListActivity();
            }
        });

        findViewById(R.id.btnUserListActivityFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUserListFragmentActivity();
            }
        });
    }

    private void showUserListActivity() {
        Intent intent =  new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    private void showUserListFragmentActivity() {
        Intent intent =  new Intent(this, UserListFragmentActivity.class);
        startActivity(intent);
    }
}
