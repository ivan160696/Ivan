package info.goodline.department.learnandroid.recycler_view.chat;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import info.goodline.department.learnandroid.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatVH> {

    public interface onItemClickListener {
        void onItemClick(ChatItem item,int position);
    }

    private Context context;
    private onItemClickListener clickListener;
    private LayoutInflater inflater;
    private List<ChatItem> chats;


    public ChatAdapter(Context context, List<ChatItem> chats, onItemClickListener clickListener) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.chats = chats;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ChatVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.item_view_chat, viewGroup, false);
        return new ChatVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChatVH chatVH, final int position) {
        final ChatItem chatItem = chats.get(position);
        chatVH.ivAvatar.setImageResource(chatItem.getAvatar());
        chatVH.tvChatTheme.setText(chatItem.getTitle());

        String formattedLastMessage = "<font color='#000000'>" + chatItem.getLastUserName() + "</font>" + chatItem.getLastMessage();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            chatVH.tvMessage.setText(Html.fromHtml(formattedLastMessage, Html.FROM_HTML_MODE_COMPACT));
        else
            chatVH.tvMessage.setText(Html.fromHtml(formattedLastMessage));

        chatVH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clickListener.onItemClick(chatItem);
                deleteItem(chatItem, chatVH.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    /**
     * Метод добавления чата в список
     *
     * @param item - чат
     */
    public void insertItem(ChatItem item) {
        // Добавить экземпляр класса ChatItem в коллекцию объектов сразу после первого элемента.
        chats.add(0, item);
        // Обновить адаптер. Вызывав этот метод, в списке recyclerView будет отрисовано добавление
        // нового элемента
        notifyItemInserted(0);
    }

    public void deleteItem(ChatItem item, int position) {
        chats.remove(item);
        notifyItemRemoved(position);
    }
}
