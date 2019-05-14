package info.goodline.department.learnandroid.recycler_view.google_play;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import info.goodline.department.learnandroid.R;

public class AppVH extends RecyclerView.ViewHolder {

    public ImageView ivIconApp;
    public TextView tvNameApp;
    public ImageView ivMore;
    public TextView tvSizeApp;

    public AppVH(@NonNull View itemView) {
        super(itemView);
        ivIconApp = itemView.findViewById(R.id.ivIconApp);
        tvNameApp = itemView.findViewById(R.id.tvNameApp);
        ivMore = itemView.findViewById(R.id.ivMore);
        tvSizeApp = itemView.findViewById(R.id.tvSizeApp);
    }
}
