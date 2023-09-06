package jp.ac.meijou.android.s221205013;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import java.util.Optional;

import jp.ac.meijou.android.s221205013.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205013.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    private final ActivityResultLauncher<Intent> getActivityResult =registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()){
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result: "+ text)
                                .ifPresent(text -> binding.resultText.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.resultText.setText("Result: Canceled");
                        break;
                    default:
                        binding.resultText.setText("Result: Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonMei.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        });

        binding.buttonAn.setOnClickListener(view -> {
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.yahoo.co.jp"));
            startActivity(intent);
        });

        binding.buttonSoushin.setOnClickListener(view -> {
            var intent =new Intent(this, SubActivity.class);
            intent.putExtra("text", binding.editTextText.getText().toString());
            startActivity(intent);
        });

        binding.buttonsyutoku.setOnClickListener(view -> {
            var intent =new Intent(this, SubActivity.class);
            getActivityResult.launch(intent);
        });


    }
}