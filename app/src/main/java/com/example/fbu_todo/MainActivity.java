package com.example.fbu_todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items; //option enter for import statement

    //my widgets
    Button btnAdd;
    EditText edItem;
    RecyclerView rvItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //UI of our application

        //initialize the widget variables
        btnAdd = findViewById(R.id.btnAdd); //What is R?
        edItem = findViewById(R.id.edItem);
        rvItems = findViewById(R.id.rvitems);

        edItem.setText("I'm doing this from Java :)");


        items = new ArrayList<>(); //instatiate your list of items
        items.add("Struggle over AP Assignment");
        items.add("Cry over Physics");
        items.add("Figure out how to move from my pinkie?");
    }
}
