package uk.co.phoebemurphy.apps.calculator;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;


public class DisplayResultActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        
        //create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        
        //set the text view as the activity layout
        setContentView(textView);
        
    }

}
