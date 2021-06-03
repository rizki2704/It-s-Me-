package com.rizki.itsme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.rizki.itsme.fragment.ActivityFragment;
import com.rizki.itsme.fragment.GalleryFragment;
import com.rizki.itsme.fragment.HomeFragment;
import com.rizki.itsme.fragment.MusicFragment;
import com.rizki.itsme.fragment.ProfileFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainScreen extends AppCompatActivity {
    // 1 Juni 2021, 10118025 Rizki Restu Illahi IF-1

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        bnv_Main = findViewById(R.id.bnv_Main);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.running));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.picture));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.ic_music));
        bnv_Main.add(new MeowBottomNavigation.Model(5,R.drawable.ic_profile));

        bnv_Main.show(1,true);
        replace(new HomeFragment());
        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new HomeFragment());
                        break;

                    case 2:
                        replace(new ActivityFragment());
                        break;

                    case 3:
                        replace(new GalleryFragment());
                        break;
                    case 4:
                        replace(new MusicFragment());
                        break;
                    case 5:
                        replace(new ProfileFragment());
                        break;

                }
                return null;
            }
        });




    }

    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}