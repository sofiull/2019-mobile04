package id.ac.polinema.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import model.User;

public class ParcelableActivity extends AppCompatActivity {
    private EditText usernameText;
    private EditText nameText;
    private EditText ageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);

        // TODO: bind here
        usernameText = findViewById(R.id.input_username);
        nameText = findViewById(R.id.input_name);
        ageText = findViewById(R.id.input_age);
    }

    public void handleSubmit(View view) {
        String username = usernameText.getText().toString();
        String name = nameText.getText().toString();
        int age = Integer.parseInt(ageText.getText().toString());

        User user = new User(username,name,age);

        Intent intent = new Intent(this, ProfileParcelableActivity.class);
        intent.putExtra("USER_KEY",user);

        startActivity(intent);
    }
}
