package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
Editable UserInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);


    }
    public static void on_click_button(View view){


    }
    public void sendMessageSaveAndCancel(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);//Intent takes 2 parameters Context and Class The DisplayMessage is the class that shows the new creen
        //Context is used because aActivity is a subclass of Context
        startActivity(intent);//opens the activity The startActivity() method starts an instance of the DisplayMessageActivity that's specified by the Intent
    }

}
