package jp.ac.meijou.android.s221205013;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import jp.ac.meijou.android.s221205013.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205013.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textviewGone.setVisibility(View.GONE);
    }
}