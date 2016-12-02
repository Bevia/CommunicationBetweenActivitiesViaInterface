package com.example.vincentbevia.interfacecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        StateListener {

    private String TAG = "tagOutput";
    private View decorView;
    private boolean TAG_TITLE_CHANGED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        decorView = getWindow().getDecorView();

        getSupportActionBar().setTitle("Testing Interface");
        toolbar.setSubtitle("   first activity");

        /**
         * Interface and Model listener callbacks:
         */
        StateListenerModel.getInstance().setListener(this);
        boolean stateListenerModel = StateListenerModel.getInstance().getState();

        Log.d(TAG, "Current state listener mode: " + String.valueOf(stateListenerModel));

    }

    @Override
    public void stateChanged() {

        TAG_TITLE_CHANGED = true;
        getSupportActionBar().setTitle("New Title");
    }

    public void goToSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void reinstateToolbarTitle(View view) {

        if (TAG_TITLE_CHANGED == false) {

            LayoutInflater inflater = getLayoutInflater();
            View layouttoast = inflater.inflate(R.layout.toastcustom, (ViewGroup)findViewById(R.id.toastcustom));
            ((TextView) layouttoast.findViewById(R.id.texttoast)).setText("The title has not been changed!");

            Toast mytoast = new Toast(getBaseContext());
            mytoast.setView(layouttoast);
            mytoast.setDuration(Toast.LENGTH_LONG);
            mytoast.show();

        }else{
            getSupportActionBar().setTitle("Testing Interface");
            TAG_TITLE_CHANGED = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
