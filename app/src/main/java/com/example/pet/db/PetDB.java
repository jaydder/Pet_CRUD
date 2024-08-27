package com.example.pet.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.pet.model.Pet;

import java.util.ArrayList;

public class PetDB extends SQLiteOpenHelper {

        public PetDB(Context context) {
            super(context, "pet.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE pet (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, breed TEXT)");
            Log.i("db", "OnCreate");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS pet");
            onCreate(db);
        }

        public void createPet(String name, String breed) {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO pet (name, breed) VALUES ('" + name + "', '" + breed + "')");
        }

        public ArrayList<Pet> listPets() {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM pet", null);
            ArrayList<Pet> pets = new ArrayList<>();
            while (cursor.moveToNext()) {
                Pet pet = new Pet();
                pet.setId(cursor.getInt(cursor.getColumnIndex("id")));
                pet.setName(cursor.getString(cursor.getColumnIndex("name")));
                pet.setBreed(cursor.getString(cursor.getColumnIndex("breed")));
                pets.add(pet);
            }
            cursor.close();
            return pets;
        }

        public boolean deletePet(String name) {
            SQLiteDatabase db = getWritableDatabase();
            if (existsPet(name)) {
                db.execSQL("DELETE FROM pet WHERE name = '" + name + "'");
                return true;
            }
            return false;
        }

        public boolean existsPet(String name) {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM pet WHERE name = '" + name + "'", null);
            return cursor.getCount() > 0;
        }

}
