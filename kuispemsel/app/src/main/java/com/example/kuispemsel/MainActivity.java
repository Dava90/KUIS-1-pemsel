package com.example.kuispemsel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private Button writeButton;
    private Button readButton;
    private String fileName = "exampleFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        writeButton = findViewById(R.id.writeButton);
        readButton = findViewById(R.id.readButton);

        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editText.getText().toString();
                FileUtils.writeToFile(MainActivity.this, fileName, data);
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = FileUtils.readFromFile(MainActivity.this, fileName);
                textView.setText(data);
            }
        });
    }
}