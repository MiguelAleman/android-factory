package edu.tutorials.androidfactory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MemeCreator extends ActionBarActivity {

    // Declaring references of the UI Elements
    private EditText topET, bottomET;
    private TextView topTV, bottomTV;
    private Button createMemeB, changeMemeB;

    // Amount of memes currently supported
    private static final int amountOfMemes = 4;

    // Array Used to change between memes
    private Drawable[] arrayOfMemes = new Drawable[amountOfMemes];

    // This relative layout contains as background a meme
    private RelativeLayout memeRL;

    // This variable will store the current meme currently displayed
    private int currentMeme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meme_creator);

        // Setting the currentMeme variable to 0, this means that we are displaying the first meme
        currentMeme = 0;

        // Getting the memes from the drawable folder
        arrayOfMemes[0] = getDrawable(R.drawable.meme_1);
        arrayOfMemes[1] = getDrawable(R.drawable.meme_2);
        arrayOfMemes[2] = getDrawable(R.drawable.meme_3);
        arrayOfMemes[3] = getDrawable(R.drawable.meme_4);

        // Getting reference of each ui element using an ID
        topET = (EditText) findViewById(R.id.topET);
        bottomET = (EditText) findViewById(R.id.bottomET);
        topTV = (TextView) findViewById(R.id.topTV);
        bottomTV = (TextView) findViewById(R.id.bottomTV);
        createMemeB = (Button) findViewById(R.id.createMemeB);
        changeMemeB = (Button) findViewById(R.id.changeMemeB);
        memeRL = (RelativeLayout) findViewById(R.id.memeRL);

        // Setting a listener for the createMeme button
        createMemeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Changing the text views when the user presses the create meme button
                topTV.setText(topET.getText().toString());
                bottomTV.setText(bottomET.getText().toString());
            }
        });

        changeMemeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // When the user pressses the change meme button, we need to switch the current drawable image
                memeRL.setBackground(arrayOfMemes[++currentMeme % amountOfMemes]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meme_creator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
