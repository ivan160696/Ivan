package info.goodline.department.learnandroid.recycler_view.google_play;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import info.goodline.department.learnandroid.R;

import static com.bumptech.glide.request.RequestOptions.centerCropTransform;

public class AppListAdapter extends RecyclerView.Adapter<AppVH> {

    private List<App> apps;
    private CategoryListAdapter.GooglePlayClickListener clickListener;
    Context context;

    public AppListAdapter(Context context, List<App> apps, CategoryListAdapter.GooglePlayClickListener clickListener) {
        this.context = context;
        this.apps = apps;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AppVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_application, viewGroup, false);
        return new AppVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppVH appVH, int position) {
        final App app = apps.get(position);

        Glide.with(context)
                .load(app.getIconUrl())
                .apply(centerCropTransform())
                .into(appVH.ivIconApp);


        appVH.tvNameApp.setText(app.getName());
        appVH.tvSizeApp.setText(app.getSize() + " МБ");
        appVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onAppClicked(app);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

}
