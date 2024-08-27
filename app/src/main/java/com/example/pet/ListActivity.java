package com.example.pet;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pet.db.PetDB;
import com.example.pet.model.Pet;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        PetDB db = new PetDB(getApplicationContext());

        List<Pet> listPet;
        ListView ltView;
        ArrayAdapter<String> adapter;

        listPet = db.listPets();
        String[] lengthPet = new String[listPet.size()];

        for (int i = 0; i < listPet.size(); i++) {
            lengthPet[i] = "Name: "+ listPet.get(i).getName() +
                    "\nBreed: "+ listPet.get(i).getBreed();
        }
        adapter = new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, lengthPet);
        ltView = findViewById(R.id.ltviewPet);
        ltView.setAdapter(adapter);
    }
}