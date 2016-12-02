package com.example.vincentbevia.interfacecomm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        decorView = getWindow().getDecorView();

        getSupportActionBar().setTitle("Detail View");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setSubtitle("   second activity");

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

    }

    public void changeNameFromFirstActivity(View view) {

        StateListenerModel.getInstance().changeState(true);

        LayoutInflater inflater = getLayoutInflater();
        View layouttoast = inflater.inflate(R.layout.toastcustom, (ViewGroup)findViewById(R.id.toastcustom));
        ((TextView) layouttoast.findViewById(R.id.texttoast)).setText("Title has been change in first activity...");

        Toast mytoast = new Toast(getBaseContext());
        mytoast.setView(layouttoast);
        mytoast.setDuration(Toast.LENGTH_LONG);
        mytoast.show();
    }
}
