package info.goodline.department.learnandroid.local_storage

import android.os.Build
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.view.View
import android.view.ViewGroup
import info.goodline.department.learnandroid.R
import info.goodline.department.learnandroid.local_storage.models.Chat
import kotlinx.android.synthetic.main.item_view_chat.view.*

class ChatAdapter(val items: MutableList<Chat>, val listener: (Chat) -> Unit) : RecyclerView.Adapter<ChatAdapter.ChatVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChatVH(parent.inflate(R.layout.item_view_chat))

    override fun onBindViewHolder(holder: ChatVH, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount() = items.size

    class ChatVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(chat: Chat, listener: (Chat) -> Unit) = with(itemView) {

            tvChatTheme.text = chat.name

            val lastMessage = chat.messages?.lastOrNull() ?: return@with
            val user = lastMessage.user ?: return@with

            ivAvatar.setImageResource(user.avatarUrl)
            val formattedLastMessage = "<font color='#000000'>" + user.name + "</font>" + lastMessage.text
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                tvMessage.text = Html.fromHtml(formattedLastMessage, Html.FROM_HTML_MODE_COMPACT)
            else
                tvMessage.text = Html.fromHtml(formattedLastMessage)

            setOnClickListener { listener(chat) }
        }
    }

    /**
     * Метод добавления чата в список
     * @param item - чат
     */
    fun insertItem(item: Chat) {
        items.add(0, item)
        notifyItemInserted(0)
    }

    fun removeAt(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateItemChat(item: Chat) {
        // Проверяем есть ли такой элемент в списке
        if (!items.contains(item)) {
            // Если нет то ничего не обновлять
            return
        }
        // Если есть, то обновить его
        val positionItem = items.indexOf(item)
        items[positionItem] = item
        notifyItemChanged(positionItem)
    }

    fun getItemChat(position: Int): Chat? {
        if (position >= itemCount) {
            return null
        }

        return items[position]
    }


}