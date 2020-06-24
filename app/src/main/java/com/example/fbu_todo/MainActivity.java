package com.example.fbu_todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        //edItem.setText("I'm doing this from Java :)"); set text in edItem bar

        items = new ArrayList<>(); //instatiate your list of items
        items.add("Struggle over AP Assignment");
        items.add("Cry over Physics");
        items.add("Figure out how to move from my pinkie?");

        //inserted this after the interface
        ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener()
        {
            @Override
            public void onItemLongClick(int position) {
                //delete item from model
                //notify adapter at which position an item has been deleted
            }
        };


        //Still a bit confused about how this adaptor works but ok...
        //put it after defining our items, bc pass the items to ItemsAdapter
        final ItemsAdapter itemsAdapter = new ItemsAdapter(items, onLongClickListenerlong);
        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //when someone taps on the button
                String todoItems = edItem.getText().toString(); //returns a Editable, but we want a String
                //add items to model
                items.add(todoItems);
                //notify adapter that an item is inserted in last position
                itemsAdapter.notifyItemInserted(items.size()-1);
                //clear the edit text
                edItem.setText("");

                String tstMsg = "'" + todoItems + "' was added";
                Toast.makeText(getApplicationContext(), tstMsg, Toast.LENGTH_SHORT).show();
                //Length short is the duration
            }
        });
    }
}
