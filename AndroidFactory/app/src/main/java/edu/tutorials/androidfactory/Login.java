package edu.tutorials.androidfactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Button;

public class Login extends Activity {

    // Temporary Credentials
    private static final String USERNAME = "android";
    private static final String PASSWORD = "factory";

    // Declaring references to the widgets we created in the layout of this activity
    private EditText usernameET, passwordET;
    private Button loginB;
    private ImageView logoIV;
    private View loginFormRL;

    // Toast is a class that allow us to create an error message
    private Toast errorMessage;

    // By using Intents we can navigate from one activity to another
    private Intent nextActivity;

    // The Animation class allow us to create animations with our widgets
    private Animation animTranslate;
    private Animation animFadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();

        // Set a timer for two seconds and then show login form
        // By using threads we can run code in parallel
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // When the timer is over we wan to start our first animation
                    // The "Android Factory logo" will translate from one position to another
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            logoIV.startAnimation(animTranslate);
                        }
                    });

                }
            }
        };

        timer.start();
    }

    private void initialize() {

        // We need a reference of the widgets we created in the layout so we can control
        // the behavior of each widget dynamically
        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginB = (Button) findViewById(R.id.loginB);
        logoIV = (ImageView) findViewById(R.id.logoIV);
        loginFormRL = findViewById(R.id.loginFormRL);

        // OnClick Listener of the button
        loginB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loginClicked(v);
            }
        });


        // Create a translate animation to be used after the splash screen
        animTranslate = AnimationUtils.loadAnimation(Login.this,
                R.anim.translate);

        // Listener to detect when the animation starts, repeats or ends.
        animTranslate.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationEnd(Animation arg0) {
                loginFormRL.setVisibility(View.VISIBLE);
                // Fade In Animation
                animFadeIn = AnimationUtils.loadAnimation(Login.this,
                        R.anim.fade_in);
                loginFormRL.startAnimation(animFadeIn);
            }
        });
    }

    // This method is executed when the user presses the login button
    public void loginClicked(View view){

        // Get the data from the text fields
        String usernameGiven = usernameET.getText().toString();
        String passwordGiven = passwordET.getText().toString();

        // Verify if the credentials are correct
        if(usernameGiven.equals(USERNAME) && passwordGiven.equals(PASSWORD)){
            // Credentials are correct, lets go to the next activity
            nextActivity =  new Intent(Login.this, Main.class);
            startActivity(nextActivity);
            finish();

        }else{
            // Credentials are incorrect, show error Message
            errorMessage = Toast.makeText(this, "Wrong username or password",
                    Toast.LENGTH_SHORT);
            errorMessage.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
