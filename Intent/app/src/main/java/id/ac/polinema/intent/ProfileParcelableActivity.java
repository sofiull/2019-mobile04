package id.ac.polinema.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import model.User;

public class ProfileParcelableActivity extends AppCompatActivity {
    private TextView usernameView;
    private TextView nameView;
    private TextView ageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_parcelable);

        // TODO: bind here
        usernameView = findViewById(R.id.text_username);
        nameView = findViewById(R.id.text_name);
        ageView = findViewById(R.id.text_age);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // TODO: display value here
            //  Textview Error ketika melakukan setText dengan tipe integer :(
            User user = extras.getParcelable("USER_KEY");

            String username = user.getUsername();
            String name = user.getName();
            int age = user.getAge();

            usernameView.setText(username);
            nameView.setText(name);
            ageView.setText(Integer.toString(age));
        }else {
            Toast.makeText(this, "kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
