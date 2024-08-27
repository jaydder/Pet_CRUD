package com.example.pet;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pet.db.PetDB;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        EditText field_delete = findViewById(R.id.fieldDelete);
        Button btn_delete = findViewById(R.id.btn_delete_pet);

        btn_delete.setOnClickListener(v -> {

            if (field_delete.getText().toString().isEmpty()) {
                field_delete.setError("This field is required");
                return;
            }
            String name = field_delete.getText().toString();
            PetDB db = new PetDB(getApplicationContext());
            if (!db.existsPet(name)) {
                field_delete.setError("Pet not found");
            } else {
                Toast.makeText(this, "Pet deleted", Toast.LENGTH_SHORT).show();
                field_delete.setText("");
            }
        });



    }
}