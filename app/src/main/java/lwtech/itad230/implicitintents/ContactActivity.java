package lwtech.itad230.implicitintents;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.provider.ContactsContract.Intents;
import android.widget.EditText;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
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


    public void onSetContactClick(View view){
        // create implicit intent to add contact
        Intent intent = new Intent(Intents.Insert.ACTION)
                .setType(ContactsContract.RawContacts.CONTENT_TYPE);

        // retrieve email and phone inputs
        EditText mEmailAddress = (EditText) findViewById(R.id.email_eTxt);
        EditText mPhone= (EditText) findViewById(R.id.phone_eTxt);

        // insert email and phone
        intent.putExtra(Intents.Insert.EMAIL,mEmailAddress.getText())
                .putExtra(Intents.Insert.PHONE,mPhone.getText());



        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 0);
        }

    }
    public void onViewContactClick(View view){
        // create implicit intent to add calendar event
        Intent intent = new Intent(Intent.ACTION_EDIT);


        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 0);
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        int x = 0;
    }
}
