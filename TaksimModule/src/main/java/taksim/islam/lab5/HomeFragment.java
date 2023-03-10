package taksim.islam.lab5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View a = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn = a.findViewById(R.id.button);
        String Pattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        String[] emails = getResources().getStringArray(R.array.email_array);

        AutoCompleteTextView auto = a.findViewById(R.id.autoCompleteTextView1);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, emails);
        auto.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Input = auto.getText().toString();
                Bundle bundle = new Bundle();
                if (Input.matches("")){
                    auto.setError(getString(R.string.empty));
                    Input = getString(R.string.empty);
                    bundle.putString("Key", Input);
                    getParentFragmentManager().setFragmentResult("Key", bundle);
                }
                else if (Input.matches(Pattern) && Input.length() > 0){
                    bundle.putString("Key", Input);
                    getParentFragmentManager().setFragmentResult("Key", bundle);
                    auto.getText().clear();
                }else{
                    auto.setError(getString(R.string.invalid_email));
                }


            }
        });
        return a;


    }
}