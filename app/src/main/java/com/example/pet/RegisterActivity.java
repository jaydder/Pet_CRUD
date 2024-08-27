package com.example.pet;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pet.db.PetDB;

public class RegisterActivity extends AppCompatActivity {

    EditText field_name;
    EditText field_breed;
    Button button_register_db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        field_name = findViewById(R.id.field_name);
        field_breed = findViewById(R.id.field_breed);
        button_register_db = findViewById(R.id.btn_register_db);

        PetDB db = new PetDB(getApplicationContext());

        button_register_db.setOnClickListener(v -> {
            if (verifyFieldsEmpty()) {
                db.createPet(field_name.getText().toString(), field_breed.getText().toString());
                Toast.makeText(this, "Pet registered", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public boolean nameEmptyError() {
        field_name.setError("Name is empty");
        return false;
    }

    public boolean breedEmptyError() {
        field_breed.setError("Breed is empty");
        return false;
    }

    public boolean verifyFieldsEmpty() {
        if (field_name.getText().toString().isEmpty()) {
            nameEmptyError();
            return false;
        }
        if (field_breed.getText().toString().isEmpty()) {
            breedEmptyError();
            return false;
        }
        return true;
    }
}
