package lwtech.itad230.implicitintents;

import android.os.Bundle;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import lwtech.itad230.implicitintents.R;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onSetAlarmClick(View view){
        // get alarm settings
        EditText hourEditText = (EditText) findViewById(R.id.set_Hour);
        EditText minuteEditText = (EditText) findViewById(R.id.set_Minute);
        EditText labelEditText = (EditText) findViewById(R.id.set_Label);

        int hour = Integer.parseInt(hourEditText.getText().toString());
        int minute = Integer.parseInt(minuteEditText.getText().toString());
        String message = labelEditText.getText().toString();

        // implicit intent
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_HOUR,hour)
                .putExtra(AlarmClock.EXTRA_MINUTES,minute)
                .putExtra(AlarmClock.EXTRA_MESSAGE,message);

        if(intent.resolveActivity(getPackageManager()) != null) {
            //startActivity(intent);
            startActivityForResult(intent, 0);
            //finish();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int x = 0;
    }


}
