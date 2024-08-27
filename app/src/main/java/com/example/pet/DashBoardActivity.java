package com.example.pet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pet.RegisterActivity;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(v -> {
            changeActivity(RegisterActivity.class);
        });

        Button btn_list = findViewById(R.id.btn_list);
        btn_list.setOnClickListener(v -> {
            changeActivity(ListActivity.class);
        });

        Button btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(v -> {
            changeActivity(DeleteActivity.class);
        });

    }

    public void changeActivity(Class<?> activity) {
        startActivity(new Intent(this, activity));
    }

}