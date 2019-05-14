package info.goodline.department.learnandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class UserListFragment extends Fragment implements View.OnClickListener {

    public interface onUserListListener {
        void onUserClicked(User user);
    }

    private onUserListListener listener;

    public UserListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_list, container, false);

        v.findViewById(R.id.rlUserJon).setOnClickListener(this);
        v. findViewById(R.id.rlUserLisa).setOnClickListener(this);

        DataBaseHelper.initDatabase();
        List<User> users = DataBaseHelper.getUsers();

        User jon = users.get(DataBaseHelper.USER_JON);
        User lisa = users.get(DataBaseHelper.USER_LISA);

        TextView tvUserNameJon = v.findViewById(R.id.tvUserName);
        tvUserNameJon.setText(jon.getName());
        TextView tvMailJon = v.findViewById(R.id.tvMail);
        tvMailJon.setText(jon.getEmail());

        TextView tvUserNameLisa = v.findViewById(R.id.tvUserNameLisa);
        tvUserNameLisa.setText(lisa.getName());
        TextView tvMailLisa = v.findViewById(R.id.tvMailLisa);
        tvMailLisa.setText(lisa.getEmail());

        return v;
    }

    @Override
    public void onClick(View view) {
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
        Log.d("UserListFragment", "User clicked. Id = " + userId);

        List<User> users = DataBaseHelper.getUsers();
        listener.onUserClicked(users.get(userId));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            listener = (onUserListListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onUserListListener");
        }
    }


}
