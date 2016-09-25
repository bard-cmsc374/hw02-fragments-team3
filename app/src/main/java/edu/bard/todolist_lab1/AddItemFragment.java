package edu.bard.todolist_lab1;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by meghanhogan on 9/22/16.
 */
public class AddItemFragment extends Fragment {

    private TextView mEditText;
    private Button mItemButton;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_add_item, container, false);

        mEditText =  (EditText)v.findViewById(R.id.myEditText);
        mItemButton = (Button)v.findViewById(R.id.addButton);

        mItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                mEditText.setText("");
            }
        });

        return v;
    }
}
