package com.example.praktikum4.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.praktikum4.DataSource.BookDataSource;
import com.example.praktikum4.MainActivity;
import com.example.praktikum4.Model.Book;
import com.example.praktikum4.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddBookFragment extends Fragment {
    MaterialButton btnAddBook;
    EditText title, author, publisher, year, description;
    ImageView inputFoto;
    Uri imageUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_book, container, false);
        LinearLayout checkboxContainer = view.findViewById(R.id.checkboxContainer);
        ArrayList<String> genres = BookDataSource.getGenre(); // Genre dari data dummy kamu

        //      ProgressBar
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        int maxRows = 3;  // Maksimum 3 baris
        int checkboxCount = genres.size();
        int rowsFilled = 0;
        int jumlahPerBaris = (int) Math.ceil((double) (genres.size() - 1) / maxRows);
        LinearLayout currentRow = null;
        for (int i = 1; i < checkboxCount; i++) {
            if (i == 1 || i % jumlahPerBaris == 1) {
                // Membuat baris baru
                currentRow = new LinearLayout(requireContext());
                currentRow.setOrientation(LinearLayout.HORIZONTAL);
                checkboxContainer.addView(currentRow);
                rowsFilled++;
            }
            // Membuat checkbox dan menambahkannya ke baris yang sesuai
            View checkboxView = LayoutInflater.from(requireContext()).inflate(R.layout.genre_checkbox_layout, currentRow, false);
            CheckBox checkBox = checkboxView.findViewById(R.id.checkboxGenre);
            checkBox.setText(genres.get(i));
            currentRow.addView(checkboxView);
            if (rowsFilled > maxRows) {
                break;  // Hentikan setelah 3 baris
            }
        }

        title = view.findViewById(R.id.editTitle);
        author = view.findViewById(R.id.editAuthor);
        year = view.findViewById(R.id.editYear);
        description = view.findViewById(R.id.editBlurb);
        inputFoto = view.findViewById(R.id.imgBookCover);

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

        btnAddBook = view.findViewById(R.id.btnAddBook);
        btnAddBook.setOnClickListener(v -> {
            String title1 = this.title.getText().toString();
            String author1 = this.author.getText().toString();
            String description1 = this.description.getText().toString();
            String year1 = this.year.getText().toString();


            // Ambil semua checkbox yang dicentang
            ArrayList<String> selectedGenres = new ArrayList<>();
            for (int i = 0; i < checkboxContainer.getChildCount(); i++) {
                LinearLayout row = (LinearLayout) checkboxContainer.getChildAt(i);
                for (int j = 0; j < row.getChildCount(); j++) {
                    View checkboxView = row.getChildAt(j);
                    CheckBox checkBox = checkboxView.findViewById(R.id.checkboxGenre);
                    if (checkBox.isChecked()) {
                        selectedGenres.add(checkBox.getText().toString());
                    }
                }
            }
            if (title1.isEmpty() || author1.isEmpty() || description1.isEmpty() || year1.isEmpty() || selectedGenres.isEmpty()) {
                Toast.makeText(getContext(), "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                return;
            }
            Book book = new Book(title1, author1, description1, year1, imageUri, false, selectedGenres);
            BookDataSource.addBook(book);

            MainActivity mainActivity = (MainActivity) getActivity();
            if (mainActivity != null) {
                mainActivity.progressBar.setVisibility(View.VISIBLE);

                new Handler().postDelayed(() -> {
                    mainActivity.progressBar.setVisibility(View.GONE);
                    FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, new HomeFragment()); // Ganti dengan ID container kamu
//            transaction.addToBackStack(null); // opsional, bisa dihapus jika tidak ingin user bisa kembali
                    transaction.commit();
                    // Tampilkan foto
                }, 5000);
            }

        });


        return view;
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
                            requireActivity().getContentResolver().takePersistableUriPermission(imageUri, takeFlags);

                        }
                    }
                }
            }
    );
}
