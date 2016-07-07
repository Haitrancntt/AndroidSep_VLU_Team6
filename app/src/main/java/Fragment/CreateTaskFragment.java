package Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.haitr.planed_12062016.LoginActivity;
import com.example.haitr.planed_12062016.R;

import Controller.Task_Control;
import Database.DatabaseConnection;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTaskFragment extends Fragment {
    DatabaseConnection db = LoginActivity.db;
    EditText edit;
    private ImageButton btnExit;
    public CreateTaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_task, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edit = (EditText) getActivity().findViewById(R.id.editText3);
        btnExit = (ImageButton) getActivity().findViewById(R.id.imageButton3);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Task_Control task = new Task_Control(db.getConnection());
                String taskName = edit.getText().toString();
                boolean b = task.AddTask(taskName, 1);
                if (b)
                    Toast.makeText(getActivity(), "Succeess", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "Fail", Toast.LENGTH_SHORT).show();
               /* FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, new TaskFragment()).commit();*/
            }
        });
    }


}
