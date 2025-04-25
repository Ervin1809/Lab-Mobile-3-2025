package com.example.instagram;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.core.view.WindowInsetsCompat;

public class UploadActivity extends AppCompatActivity {
    ImageView inputFoto, btnKembali;
    EditText inputCaption;
    MaterialButton btnBagikan;
    Uri imageUri;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        inputFoto = findViewById(R.id.input_foto);
        inputCaption = findViewById(R.id.input_capt);
        btnBagikan = findViewById(R.id.button_bagikan);
        btnKembali = findViewById(R.id.kembali);

        inputFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bukagaleri = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                bukagaleri.addCategory(Intent.CATEGORY_OPENABLE);
                bukagaleri.setType("image/*");
                bukagaleri.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);
                bukagaleri.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                openGallery.launch(Intent.createChooser(bukagaleri, "Pilih foto profil"));
            }
        });

        btnBagikan.setOnClickListener(v -> {
            if (imageUri != null && inputCaption.getText() != null) {
                String caption = inputCaption.getText().toString();

                // Tambahkan ke daftar post user
                DataSourcePostingan.postFoto(imageUri, caption);

                Toast.makeText(this, "Foto berhasil diposting!", Toast.LENGTH_SHORT).show();

                // Balik ke Profile atau MainActivity
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("nama", "ervinhsn");
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Pilih foto dan isi caption!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    ActivityResultLauncher<Intent> openGallery = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            imageUri = data.getData();
                            inputFoto.setImageURI(imageUri);

                            // Ambil dan simpan izin persistable
                            final int takeFlags = data.getFlags() &
                                    (Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
                            getContentResolver().takePersistableUriPermission(imageUri, takeFlags);
                        }
                    }
                }
            }
    );
}
