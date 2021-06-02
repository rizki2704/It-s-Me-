package com.rizki.itsme.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.Model;
import com.rizki.itsme.R;
import com.rizki.itsme.adapter.AdapterActivity;
import com.rizki.itsme.adapter.AdapterFriends;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActivityFragment extends Fragment {
    public RecyclerView listActivity;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActivityFragment newInstance(String param1, String param2) {
        ActivityFragment fragment = new ActivityFragment();
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
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_activity, container, false);
        final FragmentActivity fragment = getActivity();
        final FragmentActivity fragment2 = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.list_activity);
        final RecyclerView recyclerView2 = view.findViewById(R.id.list_friends);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView2.setLayoutManager(new GridLayoutManager(fragment,2 ));
        Model model = new Model();

        String[] subjects = {
                "Running", "Musik", "Film"
        };
        int[] subjects2 = {
                R.drawable.running,
                R.drawable.music,
                R.drawable.cinema
        };
        model.setSubjects(subjects);
        model.setSubjects2(subjects2);

        String[] nama = {
                "Rizki Restu","Arsyad"
        };
        int[] foto = {
                R.drawable.foto,
                R.drawable.arsad
        };
        model.setNamaT(nama);
        model.setFotoT(foto);


        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterActivity adapter = new AdapterActivity(fragment, model.getSubjects(), model.getSubjects2());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterFriends adapter = new AdapterFriends(fragment2, model.getNamaT(), model.getFotoT());
                fragment2.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView2.setAdapter(adapter);
                    }
                });
            }
        }).start();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Daily Activity");
    }
}