package com.rizki.itsme.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rizki.itsme.Model;
import com.rizki.itsme.R;
import com.rizki.itsme.adapter.AdapterMusik;
import com.rizki.itsme.adapter.AdapterVideo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MusicFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MusicFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        Model model = new Model();

        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.list_musik);
        final RecyclerView recyclerView1 = view.findViewById(R.id.list_video);
        LinearLayoutManager layoutManager = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(fragment, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView1.setLayoutManager(layoutManager2);

        String[] judul_lagu_fav = {
                "Simple Plan - Welcome To My Life", "The Hoobastank - Reason",
                "Kygo - Stay", "Petit Biscuit - Sunset Lover", "Passenger - Let Her Go",
                "Peterpan - Kukatakan Dengan Indah", "Peterpan - Kisah Cintaku",
                "Chriye - Menunggumu", "Ed Sheeran - Photograph", "The Chainsmokers - All We Know",
                "Andmesh Kamaleng - Cinta Luar Biasa"
        };
        String[] uri_video = {
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video1,
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video2,
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video3,
                "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video4
        };
        String[] judul_video = {
                "Sub Urban - Cradle", "Renai Circulation", "Sia - Snowman", "Clean Bandit - Baby"
        };


        model.setVideo(uri_video);
        model.setJudulVideo(judul_video);
        model.setMusik(judul_lagu_fav);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterMusik adapter = new AdapterMusik(fragment, model.getMusik());
                final AdapterVideo adapter2 = new AdapterVideo(fragment, model.getVideo(), model.getJudulVideo());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                        recyclerView1.setAdapter(adapter2);

                    }

                });
            }
        }).start();
        return view;
    }
}