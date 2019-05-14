package info.goodline.department.learnandroid.recycler_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import info.goodline.department.learnandroid.R;
import info.goodline.department.learnandroid.recycler_view.chat.ChatListActivity;
import info.goodline.department.learnandroid.recycler_view.google_play.GooglePlayActivity;

public class RecyclerViewExamplesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_examples);

        findViewById(R.id.btnVerticalList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChatListActivity();
            }
        });

        findViewById(R.id.btnNestedRecyclerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showGooglePlayActivity();
            }
        });
    }

    private void showGooglePlayActivity() {
        Intent intent =  new Intent(this, GooglePlayActivity.class);
        startActivity(intent);
    }

    private void showChatListActivity() {
        Intent intent =  new Intent(this, ChatListActivity.class);
        startActivity(intent);
    }
}
