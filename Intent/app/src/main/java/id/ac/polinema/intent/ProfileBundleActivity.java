package id.ac.polinema.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileBundleActivity extends AppCompatActivity {
    private TextView usernameText;
    private TextView nameText;
    private TextView AgeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_bundle);

        // TODO: bind here
        usernameText = findViewById(R.id.text_username);
        nameText = findViewById(R.id.text_name);
        AgeText = findViewById(R.id.text_age);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here (Menangkap data berdasarkan Key. exp = USERNAME_KEY)
            //  Textview Error ketika melakukan setText dengan tipe integer :(

            String username =  extras.getString("USERNAME_KEY");
            String name =  extras.getString("NAME_KEY");
            int age =  extras.getInt("AGE_KEY");

            usernameText.setText(username);
            nameText.setText(name);
            AgeText.setText(Integer.toString(age));
        }else{
            Toast.makeText(this, "kosong", Toast.LENGTH_SHORT).show();
        }
    }
}
