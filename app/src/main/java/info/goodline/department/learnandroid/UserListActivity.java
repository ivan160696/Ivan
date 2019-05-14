package info.goodline.department.learnandroid;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        findViewById(R.id.rlUserJon).setOnClickListener(this);
        findViewById(R.id.rlUserLisa).setOnClickListener(this);

        DataBaseHelper.initDatabase();
        List<User> users = DataBaseHelper.getUsers();

        User jon = users.get(DataBaseHelper.USER_JON);
        User lisa = users.get(DataBaseHelper.USER_LISA);

        TextView tvUserNameJon = findViewById(R.id.tvUserName);
        tvUserNameJon.setText(jon.getName());
        TextView tvMailJon = findViewById(R.id.tvMail);
        tvMailJon.setText(jon.getEmail());

        TextView tvUserNameLisa = findViewById(R.id.tvUserNameLisa);
        tvUserNameLisa.setText(lisa.getName());
        TextView tvMailLisa = findViewById(R.id.tvMailLisa);
        tvMailLisa.setText(lisa.getEmail());
    }

    @Override
    public void onClick(View view) {
        Intent intent =  new Intent(this, CommentsActivity.class);
        int userId = -1;

        switch (view.getId()) {
            case R.id.rlUserJon:
                userId = DataBaseHelper.USER_JON;
                break;
            case R.id.rlUserLisa:
                userId = DataBaseHelper.USER_LISA;
                break;
        }

        if (userId == -1) {
            return;
        }

        intent.putExtra(CommentsActivity.KEY_USER_ID, userId);
        startActivity(intent);
    }
}
