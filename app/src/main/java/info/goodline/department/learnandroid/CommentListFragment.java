package info.goodline.department.learnandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class CommentListFragment extends Fragment {
    RelativeLayout rlUserComments;
    RelativeLayout rlEmptyState;

    TextView tvCommentNameOne;
    TextView tvCommentNameTwo;
    TextView tvCommentNameThree;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comment_list, container, false);
        rlUserComments = v.findViewById(R.id.rlUserComments);
        rlEmptyState = v.findViewById(R.id.rlEmptyState);

        tvCommentNameOne = v.findViewById(R.id.tvCommentNameOne);
        tvCommentNameTwo = v.findViewById(R.id.tvCommentNameTwo);
        tvCommentNameThree = v.findViewById(R.id.tvCommentNameThree);
        return v;

    }


    public void showCommentsByUser(User user) {
        Log.d("CommentListFragment", "showCommentsByUser -> " + user.getName());
        rlUserComments.setVisibility(View.VISIBLE);
        rlEmptyState.setVisibility(View.GONE);

        List<Comment> comments = DataBaseHelper.getCommentsByUserId(user.getId());
        if (comments == null) {
            return;
        }

        tvCommentNameOne.setText(comments.get(0).getMessage());
        tvCommentNameTwo.setText(comments.get(1).getMessage());
        tvCommentNameThree.setText(comments.get(2).getMessage());

    }
}
