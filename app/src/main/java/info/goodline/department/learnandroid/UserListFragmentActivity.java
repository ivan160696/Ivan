package info.goodline.department.learnandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class UserListFragmentActivity extends AppCompatActivity implements UserListFragment.onUserListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_fragmetnt);

        CommentListFragment fragmentComments = new CommentListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.flContainer, fragmentComments)
                .commit();
    }

    @Override
    public void onUserClicked(User user) {
        Fragment fragmentComments = getSupportFragmentManager().findFragmentById(R.id.flContainer);
        if (fragmentComments instanceof CommentListFragment) {
            ((CommentListFragment) fragmentComments).showCommentsByUser(user);
        }
    }
}
