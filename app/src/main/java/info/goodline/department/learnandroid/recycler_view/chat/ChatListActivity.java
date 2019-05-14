package info.goodline.department.learnandroid.recycler_view.chat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import info.goodline.department.learnandroid.DataBaseHelper;
import info.goodline.department.learnandroid.R;

public class ChatListActivity extends AppCompatActivity implements ChatAdapter.onItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Inbox");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);

        RecyclerView recyclerView = findViewById(R.id.rvChatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Получаем данные
        List<ChatItem> chats = new ArrayList<>(DataBaseHelper.chats);
        // создаем адаптер
        final ChatAdapter adapter = new ChatAdapter(this, chats, this);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        FloatingActionButton fabCreateChat = findViewById(R.id.fabCreateChat);
        fabCreateChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получить новый чат
                ChatItem chatItem = DataBaseHelper.createChat();
                // Добавить его в адаптер
                adapter.insertItem(chatItem);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recyclerview_activity_menu, menu);
        return true;
    }

    @Override
    public void onItemClick(ChatItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
