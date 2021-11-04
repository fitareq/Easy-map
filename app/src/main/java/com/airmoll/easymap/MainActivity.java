package com.airmoll.easymap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.airmoll.easymap.databinding.ActivityMainBinding;
import com.airmoll.easymap.models.DataModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements MapsAdapter.RecyclerviewOnClick {

    private ActivityMainBinding binding;
    private List<DataModel> phaseOneToSevenData = new ArrayList<>();
    private List<DataModel> safariValleyMapsData = new ArrayList<>();
    private List<DataModel> phaseEightCapitalBlocksData = new ArrayList<>();
    private List<DataModel> phaseEightSpecialBlocksData = new ArrayList<>();
    private List<DataModel> safariVillasAndAwamiVillasData = new ArrayList<>();
    private List<DataModel> commercialsData = new ArrayList<>();

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String myPREFERENCES = "easymap";

    private MapsAdapter phaseOneToSevenAdapter,safariValleyMapsAdapter, phaseEightCapitalBlocksAdapter, phaseEightSpecialBlocksAdapter, safariVillasAndAwamiVillasAdapter, commercialsAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        //getting slider data from firebase
        fetchSliderDataFromFirebase();
        sharedPreferences = getSharedPreferences(myPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        //initialize all data
        initializeData();
        binding.mainSlider.setSliderTransformAnimation(SliderAnimations.HORIZONTALFLIPTRANSFORMATION);
        binding.mainSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        binding.mainSlider.startAutoCycle();



        //get and set data shared preferences to slider
        fetchSliderDataFromSharedPreferences();



        //setting layout manager for all recycler view
        binding.p1ToP7RecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false)
        );
        binding.safariValleyMapsRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        binding.phaseEightCapitalBlocksRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );
        binding.phaseEightSpecialBlocksRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false)
        );
        binding.safariVillasAndAwamiVillasRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL,false)
        );
        binding.commercialsRecyclerView.setLayoutManager(
                new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false)
        );

        //setting adapter for phase 1 to phase 7 recycler view
        phaseOneToSevenAdapter = new MapsAdapter(phaseOneToSevenData, this);
        binding.p1ToP7RecyclerView.setAdapter(phaseOneToSevenAdapter);

        //setting adapter for phase 1 to phase 7 recycler view
        safariValleyMapsAdapter = new MapsAdapter(safariValleyMapsData, this);
        binding.safariValleyMapsRecyclerView.setAdapter(safariValleyMapsAdapter);

        //setting adapter for phase 8 capital blocks recycler view
        phaseEightCapitalBlocksAdapter = new MapsAdapter(phaseEightCapitalBlocksData, this);
        binding.phaseEightCapitalBlocksRecyclerView.setAdapter(phaseEightCapitalBlocksAdapter);

        //setting adapter for phase 8 special blocks recycler view
        phaseEightSpecialBlocksAdapter = new MapsAdapter(phaseEightSpecialBlocksData,this);
        binding.phaseEightSpecialBlocksRecyclerView.setAdapter(phaseEightSpecialBlocksAdapter);

        //setting adapter for Safari Villas & Awami Villas recycler view
        safariVillasAndAwamiVillasAdapter = new MapsAdapter(safariVillasAndAwamiVillasData,this);
        binding.safariVillasAndAwamiVillasRecyclerView.setAdapter(safariVillasAndAwamiVillasAdapter);

        //setting adapter for Commercials recycler view
        commercialsAdapter = new MapsAdapter(commercialsData,this);
        binding.commercialsRecyclerView.setAdapter(commercialsAdapter);


        //calculator button on click
        binding.transferFeeCalculatorButton.setOnClickListener(v1 -> {
            startActivity(new Intent(getApplicationContext(), TransferExpensesActivity.class));
        });


        FirebaseMessaging.getInstance().subscribeToTopic("easymap")
                .addOnCompleteListener(task -> {
                    String msg = "this is test message";
                    if (!task.isSuccessful())
                    {
                        msg = "failed";
                    }
                    Log.d("FCM",msg);
                    //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                });
    }

    private void fetchSliderDataFromSharedPreferences() {
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
        SliderAdapter adapter = new SliderAdapter(data);
        binding.mainSlider.setSliderAdapter(adapter);
    }

    private void fetchSliderDataFromFirebase()
    {
        FirebaseDatabase database;
        DatabaseReference reference;
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists())
                {
                    Map<String, Object> map = (Map<String, Object>) snapshot.getValue();
                    editor.putString("value1", map.get("value1").toString());
                    editor.putString("value2", map.get("value2").toString());
                    editor.putString("value3", map.get("value3").toString());
                    editor.putString("value4", map.get("value4").toString());
                    editor.putString("value5", map.get("value5").toString());
                    editor.putString("value6", map.get("value6").toString());
                    editor.putString("value7", map.get("value7").toString());
                    editor.putString("value8", map.get("value8").toString());
                    editor.putString("value9", map.get("value9").toString());
                    editor.putString("value10", map.get("value10").toString());
                    editor.commit();
                    fetchSliderDataFromSharedPreferences();

                    //Toast.makeText(getApplicationContext(),  map.get("value1").toString(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initializeData() {
        //phase 1 to phase 7 data initialize
        phaseOneToSevenData.add(new DataModel("Phase1", R.drawable.ph_one, R.drawable.ph_one_gm));
        phaseOneToSevenData.add(new DataModel("Phase2", R.drawable.ph_two, R.drawable.ph_two_gm));
        phaseOneToSevenData.add(new DataModel("Phase3", R.drawable.ph_three, R.drawable.ph_three_gm));
        phaseOneToSevenData.add(new DataModel("Phase4", R.drawable.ph_four, R.drawable.ph_four_gm));
        phaseOneToSevenData.add(new DataModel("Phase5", R.drawable.ph_five, R.drawable.ph_five_gm));
        phaseOneToSevenData.add(new DataModel("Phase6", R.drawable.ph_six, R.drawable.ph_six_gm));
        phaseOneToSevenData.add(new DataModel("Phase7", R.drawable.ph_seven, R.drawable.ph_seven_gm));

        //safari valley data initialize
        safariValleyMapsData.add(new DataModel("Abu-Bakar", R.drawable.abu, R.drawable.abugm));
        safariValleyMapsData.add(new DataModel("Ali Block", R.drawable.ali, R.drawable.aligm));
        safariValleyMapsData.add(new DataModel("Usman Block", R.drawable.usman, R.drawable.usmangm));
        safariValleyMapsData.add(new DataModel("Umer Block", R.drawable.umer, R.drawable.umergm));
        safariValleyMapsData.add(new DataModel("Rafi Block", 0, 0));
        safariValleyMapsData.add(new DataModel("Khalid Block", 0, 0));
        safariValleyMapsData.add(new DataModel("Safari Homes", 0, 0));

        //phase 8 capital blocks data initialize
        phaseEightCapitalBlocksData.add(new DataModel("A Block", R.drawable.am, R.drawable.agm));
        phaseEightCapitalBlocksData.add(new DataModel("A1 Block", R.drawable.a1m, R.drawable.a1gm));
        phaseEightCapitalBlocksData.add(new DataModel("B Block", R.drawable.bm, R.drawable.bgm));
        phaseEightCapitalBlocksData.add(new DataModel("C Block", R.drawable.cm, R.drawable.cgm));
        phaseEightCapitalBlocksData.add(new DataModel("D Block", R.drawable.dm, R.drawable.dgm));
        phaseEightCapitalBlocksData.add(new DataModel("E Block", R.drawable.em, R.drawable.egm));
        phaseEightCapitalBlocksData.add(new DataModel("E1 Block", R.drawable.e1m, R.drawable.e1gm));
        phaseEightCapitalBlocksData.add(new DataModel("F1 Block", R.drawable.f1m, R.drawable.f1gm));
        phaseEightCapitalBlocksData.add(new DataModel("F2 Block", R.drawable.f1m, R.drawable.f2gm));
        phaseEightCapitalBlocksData.add(new DataModel("F3 Block", R.drawable.f3m, R.drawable.f3gm));
        phaseEightCapitalBlocksData.add(new DataModel("F4 Block", R.drawable.f4m, R.drawable.f4gm));
        phaseEightCapitalBlocksData.add(new DataModel("G Block", R.drawable.gm, R.drawable.ggm));
        phaseEightCapitalBlocksData.add(new DataModel("H Block", R.drawable.hm, R.drawable.hgm));
        phaseEightCapitalBlocksData.add(new DataModel("I Block", R.drawable.im, R.drawable.igm));
        phaseEightCapitalBlocksData.add(new DataModel("J Block", R.drawable.jm, R.drawable.jgm));
        phaseEightCapitalBlocksData.add(new DataModel("K Block", R.drawable.km, R.drawable.kgm));
        phaseEightCapitalBlocksData.add(new DataModel("L Block", R.drawable.lm, R.drawable.lgm));
        phaseEightCapitalBlocksData.add(new DataModel("M Block", R.drawable.mm, R.drawable.mgm));
        phaseEightCapitalBlocksData.add(new DataModel("N Block", R.drawable.nm, R.drawable.ngm));
        phaseEightCapitalBlocksData.add(new DataModel("P Block", R.drawable.pm, R.drawable.pgm));


        //Phase 8 Special Blocks data initialize
        phaseEightSpecialBlocksData.add(new DataModel("Hamlets", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Garden City", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Overseas Block", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Orchad", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Rose Garden", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Owais Block", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Club City", 0, 0));
        phaseEightSpecialBlocksData.add(new DataModel("Intellectual Village", 0, 0));

        //Safari Villas & Awami Villas data initialize
        safariVillasAndAwamiVillasData.add(new DataModel("Awami Villas 1",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Awami Villas 2",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Awami Villas 3",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Awami Villas 5",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Awami Villas 6",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Khalid Block",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Safari Homes",0,0));
        safariVillasAndAwamiVillasData.add(new DataModel("Safari Villas",0,0));

        //Commercials data initialize
        commercialsData.add(new DataModel("Spring North",0,0));
        commercialsData.add(new DataModel("Spring South",0,0));
        commercialsData.add(new DataModel("Business District",0,0));
        commercialsData.add(new DataModel("Hub Commercial",0,0));
        commercialsData.add(new DataModel("Midway Commercial",0,0));
        commercialsData.add(new DataModel("Mini Commercial",0,0));
        commercialsData.add(new DataModel("River View Commercial",0,0));
        commercialsData.add(new DataModel("DHA 1 Sector F",0,0));
        commercialsData.add(new DataModel("Mini Commercial",0,0));
        commercialsData.add(new DataModel("Square Commercial",0,0));
    }

    @Override
    public void gotoImageActivity(int image1, int image2) {

        startActivity(new Intent(getApplicationContext(), ImagesActivity.class).
                putExtra("image1",image1).
                putExtra("image2",image2));
    }
}