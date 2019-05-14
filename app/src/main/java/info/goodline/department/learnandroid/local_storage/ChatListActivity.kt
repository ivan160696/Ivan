package info.goodline.department.learnandroid.local_storage

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.InputType
import android.view.Menu
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import info.goodline.department.learnandroid.R
import info.goodline.department.learnandroid.local_storage.models.Chat
import kotlinx.android.synthetic.main.activity_chat_list.*


class ChatListActivityKT : AppCompatActivity() {
    val chatRepository = ChatRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Inbox"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

        rvChatList.layoutManager = LinearLayoutManager(this)

        // Получаем данные
        val chats = chatRepository.loadChats()
        // создаем адаптер
        val adapter = ChatAdapter(chats) { chat ->
            // При нажатии на чат показать диалоговое окно для редактирования его названия
            showDialogForEditTitle(chat)
        }
        // устанавливаем для списка адаптер
        rvChatList.adapter = adapter
        // обработка свайпа влево
        val swipeHandler = object : SwipeToDeleteCallback(this) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = rvChatList.adapter as ChatAdapter
                val chat = adapter.getItemChat(viewHolder.adapterPosition) ?: return

                // Удалить чат из БД
                chatRepository.deleteChat(chat)
                // Удалить чат из списка в recycle view
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(rvChatList)


        fabCreateChat.setOnClickListener {
            // Получить новый чат
            val chatItem = ChatRepository.getRandomChat()
            // Добавить его в адаптер
            adapter.insertItem(chatItem)
            rvChatList.smoothScrollToPosition(0)

            // Сохранить чат в БД
            chatRepository.saveChat(chatItem)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.recyclerview_activity_menu, menu)
        return true
    }

    fun showDialogForEditTitle(chat: Chat) {
        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        input.setText(chat.name)

        val container = FrameLayout(this)
        val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val margin = resources.getDimensionPixelSize(R.dimen.dialog_margin)
        params.leftMargin = margin
        params.rightMargin = margin

        input.layoutParams = params
        container.addView(input)

        AlertDialog.Builder(this)
                .setTitle("Title Chat")
                .setView(container)
                .setPositiveButton("OK") { dialog, which ->
                    // Если пользователь нажал ОК, то сохранить новое название
                    chat.name = input.text.toString()
                    updateItemChat(chat)
                }
                .setNegativeButton("Cancel") { dialog, which -> dialog.cancel() }
                .show()
    }

    fun updateItemChat(chat: Chat) {
        val adapter = rvChatList.adapter as ChatAdapter
        adapter.updateItemChat(chat)
        // Сохранить чат в БД
        chatRepository.saveChat(chat)
    }
}