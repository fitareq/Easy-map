package com.airmoll.easymap;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airmoll.easymap.databinding.ActivityImagesBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.HashMap;
import java.util.Map;

public class ImagesActivity extends AppCompatActivity {

    private ActivityImagesBinding binding;
    int img1, img2;
    SharedPreferences sharedPreferences;

    String myPREFERENCES = "easymap";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImagesBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        sharedPreferences = getSharedPreferences(myPREFERENCES, Context.MODE_PRIVATE);
        String[] data = {
                sharedPreferences.getString("value1","empty"),
                sharedPreferences.getString("value2","empty"),
                sharedPreferences.getString("value3","empty"),
                sharedPreferences.getString("value4","empty"),
                sharedPreferences.getString("value5","empty"),
                sharedPreferences.getString("value6","empty"),
                sharedPreferences.getString("value7","empty"),
                sharedPreferences.getString("value8","empty"),
                sharedPreferences.getString("value9","empty"),
                sharedPreferences.getString("value10","empty")
        };


        binding.slider.setSliderTransformAnimation(SliderAnimations.HORIZONTALFLIPTRANSFORMATION);
        binding.slider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.slider.startAutoCycle();


        img1 = getIntent().getIntExtra("image1",0);
        img2 = getIntent().getIntExtra("image2",0);

        SliderAdapter adapter = new SliderAdapter(data);
        binding.slider.setSliderAdapter(adapter);



        if (img1 == 0 || img2 == 0)
        {
            binding.seekbar.setVisibility(View.GONE);
            binding.image1.setVisibility(View.GONE);
            binding.slider.setVisibility(View.GONE);
            binding.image2.setImageResource(R.drawable.error_message);
        }else {

            binding.image1.setImageResource(img2);
            binding.image2.setImageResource(img1);
        }

        binding.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.image2.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}