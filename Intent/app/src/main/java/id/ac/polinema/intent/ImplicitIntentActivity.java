package id.ac.polinema.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URI;

public class ImplicitIntentActivity extends AppCompatActivity {

    private static final String TAG = ImplicitIntentActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    private ImageView avatarImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        avatarImage = findViewById(R.id.image_avatar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "No data selected :(", Toast.LENGTH_SHORT).show();;
        }
        if(requestCode == GALLERY_REQUEST_CODE){
            if(data!=null) {
                Toast.makeText(this, "Data Selected :)", Toast.LENGTH_SHORT).show();

                try{
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    avatarImage.setImageBitmap(bitmap);
                }catch (IOException e){
                    Toast.makeText(this, "Can't Load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void handleAvatar(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }
}
