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
    ItemCapture mItemCapture;
    private TextView mEditText;
    private Button mItemButton;

    public interface ItemCapture {
        public void setItem(String s);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mItemCapture = (ItemCapture) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

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
                String item = mEditText.getText().toString();
                mItemCapture.setItem(item);
                mEditText.setText("");
            }
        });

        return v;
    }
}
