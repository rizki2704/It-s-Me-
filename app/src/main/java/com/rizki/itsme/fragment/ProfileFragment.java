package com.rizki.itsme.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.rizki.itsme.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // 3 Juni 2021, 10118025 Rizki Restu Illahi IF-1

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        Button call, mail, ig, maps, about;

        call = view.findViewById(R.id.btnCall);
        mail = view.findViewById(R.id.btnMail);
        ig = view.findViewById(R.id.btnIg);
        maps = view.findViewById(R.id.btnMaps);
        about = view.findViewById(R.id.btnAbout);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callphone("tel:" + "087734020763");
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail("restur2411@gmail.com");
            }
        });
        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goIg("https://www.instagram.com/restur2411/");
            }
        });
        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goMaps("https://goo.gl/maps/3NWHVfvNZmeeZu3k7");
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dialog);

                //
                Button close = dialog.findViewById(R.id.btnclose);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        return view;
    }

    private void goMaps(String s) {
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void goIg(String s) {
        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    private void sendMail(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{s});
        intent.putExtra(Intent.EXTRA_CC, new String[]{""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "");
        intent.putExtra(Intent.EXTRA_TEXT, "");
        try {
            startActivity(Intent.createChooser(intent, null));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }

    private void callphone(String s) {
        final int REQUEST_PHONE_CALL = 1;

        Uri uri = Uri.parse(s);
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(uri);

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
        } else {

            startActivity(intent);
        }
    }
}