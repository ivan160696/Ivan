package info.goodline.department.learnandroid.recycler_view.chat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import info.goodline.department.learnandroid.R;

public class ChatVH extends RecyclerView.ViewHolder {

    public ImageView ivAvatar;
    public TextView tvChatTheme;
    public TextView tvUserName;
    public TextView tvMessage;


    public ChatVH(@NonNull View itemView) {
        super(itemView);
        ivAvatar = itemView.findViewById(R.id.ivAvatar);
        tvChatTheme = itemView.findViewById(R.id.tvChatTheme);
//        tvUserName = itemView.findViewById(R.id.tvUserName);
        tvMessage = itemView.findViewById(R.id.tvMessage);

    }
}
