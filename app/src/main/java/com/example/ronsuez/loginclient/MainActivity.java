package com.example.ronsuez.loginclient;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ronsuez.loginclient.Model.Todo;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {



    //--> Array of Todos --> ArrayAdapter --> ListView

    // ListView {views: da_items.xml}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateListView();
        setOnClickItemListener();
    }

    private void populateListView() {

        //Create the list of items
        //  String [] items = {"Blue", "Green"};

        List<Todo> items = new ArrayList<Todo>();

        items.add(new Todo());


        //Build the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, //Context
                R.layout.the_item, //Layout
                items //Data to be desplayed
        );

        //Configure the ListView

        ListView list = (ListView) findViewById(R.id.todoListView);
        list.setAdapter(adapter);

    }


    private void setOnClickItemListener() {

            ListView list = (ListView) findViewById(R.id.todoListView);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                // TODO: CHANGE THE [[ to a less than, ]] to greater than.
                public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                    TextView textView = (TextView) viewClicked;

                    String message = "You clicked # " + position +
                            ", which is string: " + textView.getText().toString();

                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            });
        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.new_todo) {
            Intent intent = new Intent(MainActivity.this, todoForm.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
