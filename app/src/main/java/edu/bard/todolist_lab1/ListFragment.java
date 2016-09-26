package edu.bard.todolist_lab1;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by MarleyAlford on 9/25/16.
 */
public class ListFragment extends Fragment{
    public static String TAG = "todolab";
    private ArrayList<String> mToDoItems; // list of items
    private ArrayAdapter<String> aa; // adapter from list to viewlist
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mToDoItems = new ArrayList<String>();
        aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mToDoItems);

    }

    public void addNewItem(String newItem){  //this function will be called by addItemFragment whenever a new list item is added
        mToDoItems.add(0, newItem.toString());
        aa.notifyDataSetChanged();
        mListView.setAdapter(aa);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        mListView = (ListView)v.findViewById(R.id.myListView);
        return v;
    }

}
