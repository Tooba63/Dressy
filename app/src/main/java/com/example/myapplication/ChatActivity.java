package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerViewChat;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> chatMessageList;
    private EditText editTextMessage;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        recyclerViewChat = findViewById(R.id.recyclerView_chat);
        editTextMessage = findViewById(R.id.editText_message);
        buttonSend = findViewById(R.id.button_send);

        chatMessageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessageList);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewChat.setAdapter(chatAdapter);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();
                if (!TextUtils.isEmpty(message)) {
                    sendMessage(message);
                }
            }
        });
    }

    private void sendMessage(String message) {
        // Adding user message to the list
        chatMessageList.add(new ChatMessage(message, true));
        chatAdapter.notifyDataSetChanged();
        recyclerViewChat.scrollToPosition(chatMessageList.size() - 1);
        editTextMessage.setText("");

        // Simulate admin response
        chatMessageList.add(new ChatMessage("Admin reply: " + message, false));
        chatAdapter.notifyDataSetChanged();
        recyclerViewChat.scrollToPosition(chatMessageList.size() - 1);
    }
}
