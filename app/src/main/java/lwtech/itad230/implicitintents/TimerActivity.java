package lwtech.itad230.implicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class TimerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
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

    public void onSetTimerClick(View view) {
        // get the alarm settings from the UI
        EditText durationEditText = (EditText) findViewById(R.id.set_duration);
        int duration = Integer.parseInt(durationEditText.getText().toString());

        EditText messageEditText = (EditText) findViewById(R.id.set_message);
        String message = messageEditText.getText().toString();

        // create an implicit intent with extras for a count down timer
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
            .putExtra(AlarmClock.EXTRA_MESSAGE, message);
            //.putExtra(AlarmClock.EXTRA_LENGTH, duration);

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
