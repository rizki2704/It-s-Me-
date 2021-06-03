package com.rizki.itsme.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizki.itsme.Model;
import com.rizki.itsme.R;
import com.rizki.itsme.adapter.AdapterGallery;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GalleryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GalleryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GalleryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GalleryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
        final View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        final FragmentActivity fragment = getActivity();
        final RecyclerView recyclerView = view.findViewById(R.id.list_gallery);
        recyclerView.setLayoutManager(new GridLayoutManager(fragment, 3));
        Model model = new Model();

        //gallery
        int[] fotoGallery = {
                R.drawable.foto, R.drawable.arsad, R.drawable.gallery1,
                R.drawable.gallery2, R.drawable.gallery3, R.drawable.gallery4,
                R.drawable.gallery5, R.drawable.gallery6, R.drawable.gallery7, R.drawable.gallery8,
        };
        model.setFotoGallery(fotoGallery);
        new Thread(new Runnable() {
            @Override
            public void run() {
                final AdapterGallery adapter = new AdapterGallery(fragment, model.getFotoGallery());
                fragment.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        }).start();
        return view;
    }
}