package com.outlook.gonzososa.apps.multiscreenssupport;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction().replace (R.id.container, new ListadoFragment ())
                .commit ();

        View v = findViewById(R.id.containerLogin);
        if (v != null) {

            getSupportFragmentManager()
                    .beginTransaction().replace(R.id.containerLogin, new LoginFragment ())
                    .commit();
        }

    }
}
