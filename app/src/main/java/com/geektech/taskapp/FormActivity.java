package com.geektech.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {
    private EditText ediTitle, editDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        ediTitle = findViewById(R.id.ediTitle);
        editDesc = findViewById(R.id.editDesc);

    }

    public void onClikcForm(View view) {
        Task task = new Task();
        String title = ediTitle.getText().toString().trim();
        String desc = editDesc.getText().toString().trim();
        task.setTitle(title);
        task.setDesk(desc);
        Intent intent = new Intent();
        intent.putExtra("task", task);
        setResult(RESULT_OK, intent);
        finish();

    }
}
