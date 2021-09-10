package com.example.sprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String MESSAGE_ID = "messages_prefs";
    private Button saveButton;
    private EditText enterMessage;
    private TextView showMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveButton = findViewById(R.id.button_save_message);
        enterMessage = findViewById(R.id.editText_enter_message);
        showMessageTextView = findViewById(R.id.show_message_textView);

        saveButton.setOnClickListener(view -> {
            String message = enterMessage.getText().toString().trim();

            SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("message", message);

            editor.apply();
        });

        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
        String value = getShareData.getString("message", "Nothing");

        showMessageTextView.setText(value);


    }
}