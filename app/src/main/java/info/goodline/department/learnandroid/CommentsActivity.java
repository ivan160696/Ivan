package info.goodline.department.learnandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class CommentsActivity extends AppCompatActivity {

    public static final String KEY_USER_ID = "USER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        TextView tvCommentNameOne = findViewById(R.id.tvCommentNameOne);
        TextView tvCommentNameTwo = findViewById(R.id.tvCommentNameTwo);
        TextView tvCommentNameThree = findViewById(R.id.tvCommentNameThree);

        int userId = getIntent().getIntExtra(KEY_USER_ID, -1);
        if (userId == -1) {
            return;
        }

        List<Comment> comments = DataBaseHelper.getCommentsByUserId(userId);
        if (comments == null) {
            return;
        }

        tvCommentNameOne.setText(comments.get(0).getMessage());
        tvCommentNameTwo.setText(comments.get(1).getMessage());
        tvCommentNameThree.setText(comments.get(2).getMessage());
    }



}
