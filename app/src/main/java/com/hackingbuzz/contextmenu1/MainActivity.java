package com.hackingbuzz.contextmenu1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // Dont forget to long press for the context menu
    ListView listView;
    String contacts[] = {"Ajay","Ria","Mohit","Shery","James","Rita"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter  = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
            menu.setHeaderTitle("Select the Appropriate Action");               // Setting header for Pop Up when we click on item
            menu.add(0,1,0,"Call");                // id u can get v.getId()                      //groupId, itemId, order, title
            menu.add(0, 2,0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle() == "Call") {    // when we click on it...

            Toast.makeText(getApplicationContext(),"Calling"  ,Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "SMS")  {

            Toast.makeText(this, "Sending SMS " , Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);

    }
}
