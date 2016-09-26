package edu.bard.todolist_lab1;
/*
  Most basic Todo List in one activity, no fragments.
 */
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ToDoList extends FragmentActivity implements AddItemFragment.ItemCapture{

    public static String TAG = "todolab";
    private EditText mEditText; // enter todo item
    private Button mItemButton; // add the item to the list
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;
    private String mItem;

    @Override
    public void onCreate(Bundle stuff) {
        super.onCreate(stuff);

        // Inflate your view
        setContentView(R.layout.main); // Extracts resources, autogenerates R.java from XML file

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container_add);

        //fill first fragment container with addItemFragment
        if (fragment == null){
            fragment = new AddItemFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_add, fragment)
                    .commit();
        }

        Fragment fragment2 = fm.findFragmentById(R.id.fragment_container_list);
        //fill second fragment container with ListFragment
        if (fragment2 == null){
            fragment2 = new ListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container_list, fragment2)
                    .commit();
        }


        //Log.i(TAG, "Entered onCreate");
    }


        public void setItem (String item) {
            //implementation of interface. Gets item and sets value of mItem
            //calls ListFragment's addNewItem method
            mItem = item;
            ListFragment listFrag = (ListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container_list);
            listFrag.addNewItem(mItem);
            //Log.i(TAG, "item is " + mItem);
        }


    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Entered onStart");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Entered onRestart");
    }

    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Entered onResume");
    }

    protected void onPause() {
        super.onPause();
        Log.i(TAG, "Entered onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Entered onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Entered onDestroy");
    }

}


