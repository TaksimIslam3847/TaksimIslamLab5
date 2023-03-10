package taksim.islam.lab5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View a = inflater.inflate(R.layout.fragment_settings, container, false);

        //text view
        TextView Text1 = a.findViewById(R.id.txt1);

        //switch
        Switch switchToggle = a.findViewById(R.id.switch1);
        // Inflate the layout for this fragment
        getParentFragmentManager().setFragmentResultListener("Key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                // We use a String here, but any type that can be put in a Bundle is supported

                String result = bundle.getString("Key");
                //Validate the result to pass the string
                if(result == null){
                    Text1.setText("");
                }
                Text1.setText(result);
            }
        });
        switchToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            View parentLayout = a.findViewById(android.R.id.content);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (switchToggle.isChecked()){
                    Snackbar.make(getActivity().findViewById(android.R.id.content),
                            "ON", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(getActivity().findViewById(android.R.id.content),
                            "OFF", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        return a;
    }
}