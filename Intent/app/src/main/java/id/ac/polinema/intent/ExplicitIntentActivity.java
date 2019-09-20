package id.ac.polinema.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ExplicitIntentActivity extends AppCompatActivity {

    //  Todo: Deklarasi Variable
    private EditText inputText;
    private TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        //  Todo: Bind Layout
        inputText = findViewById(R.id.input_name);
        outputText = findViewById(R.id.text_output);
    }

    public void handleSubmit(View view) {
        //  Todo: Handle Tombol Submit
        String nama = inputText.getText().toString();
        outputText.setText("Hello "+nama+", Congratulations!");
    }
}
