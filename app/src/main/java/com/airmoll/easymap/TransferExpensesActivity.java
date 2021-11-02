package com.airmoll.easymap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.airmoll.easymap.databinding.ActivityTransferExpensesBinding;

public class TransferExpensesActivity extends AppCompatActivity {

    private ActivityTransferExpensesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTransferExpensesBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);
        binding.toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        binding.toolbar.setNavigationOnClickListener(v12->{
            onBackPressed();
            finish();
        });

        binding.locationSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.locationEmpty));
        binding.sizeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));


        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) ->
        {
            switch (checkedId) {
                case R.id.radio_plot:
                    //ArrayAdapter<String> adapterLocaton1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotLocation);
                    binding.locationSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotLocation));
                    binding.sizeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                    break;
                case R.id.radio_house:
                    //ArrayAdapter<String> adapterLocaton2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseLocation);
                    binding.locationSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseLocation));
                    binding.sizeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                    break;
                case R.id.radio_commercial:
                    //ArrayAdapter<String> adapterLocaton3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.commercialLocation);
                    binding.locationSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.commercialLocation));
                    binding.sizeSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                    break;
            }
        });

        binding.locationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_plot) {
                    switch (position) {
                        case 0:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                            break;
                        case 1:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase1to6));
                            break;
                        case 2:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase7));
                            break;
                        case 3:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase8));
                            break;
                        case 4:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownClubCity));
                            break;
                        case 5:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaGreensOverseas));
                            break;
                        case 6:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase8Ext));
                            break;
                        case 7:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownSafariValley));
                            break;
                        case 8:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaHillView));
                            break;
                        case 9:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeKhalidRafiAwaisBlock));
                            break;
                    }
                } else if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_house) {
                    switch (position) {
                        case 0:
                        case 9:
                        case 10:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                            break;
                        case 1:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase1to6));
                            break;
                        case 2:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase7));
                            break;
                        case 3:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaTownPhase8));
                            break;
                        case 4:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.plotSizeBahriaGreensOverseas));
                            break;
                        case 5:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseSizeBahriaTownSafariValley));
                            break;
                        case 6:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseSizeSafariVillas));
                            break;
                        case 7:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseSizeGardenCity));
                            break;
                        case 8:
                            binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.houseSizeSafariHomes));
                            break;

                    }
                } else if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_commercial) {
                    binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.sizeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                binding.calculation.setVisibility(View.GONE);
                binding.bahariaTownPhase1To61Kanal.setVisibility(View.GONE);

                if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_plot) {
                    String s = binding.locationSpinner.getSelectedItem().toString();
                    if (s.equalsIgnoreCase("Bahria Town Phase 1 to 6")) {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {

                            setCalculatorValues("240,000", "0", "0", "0", "0", "123,000", "90,000");

                        } else if (s1.equalsIgnoreCase("1 Kanal")) {

                            setCalculatorValues("540,000", "0", "0", "0", "0", "0", "0");
                            binding.bahariaTownPhase1To61Kanal.setVisibility(View.VISIBLE);
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {

                            setCalculatorValues("480,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {

                            setCalculatorValues("720,000", "0", "0", "0", "0", "0", "0");
                        }

                    }


                    else if (s.equalsIgnoreCase("Bahria Town Phase 7")) {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("129,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("208,800", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("309,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {
                            setCalculatorValues("504,000", "0", "0", "0", "0", "0", "0");
                        }

                    }



                    else if (s.equalsIgnoreCase("Bahria Town Phase 8")) {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("31,200", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("6 Marla")) {
                            setCalculatorValues("39,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7-8 Marla")) {
                            setCalculatorValues("46,800", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("62,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("78,000", "0", "0", "0", "0", "0", "0");
                        }

                    }


                    else if (s.equalsIgnoreCase("Bahria Town Club City")) {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("156,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("234,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Greens (overseas)")) {

                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("46,800", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("78,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("109,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("156,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Town Phase 8 Ext")) {

                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("15,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7 Marla")) {
                            setCalculatorValues("20,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("24,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("42,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Town Safari Valley")) {

                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("43,200", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7 Marla")) {
                            setCalculatorValues("72,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal Usman D")) {
                            setCalculatorValues("240,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Hill View")) {

                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("129,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("208,800", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("309,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {
                            setCalculatorValues("504,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Khalid, Rafi, Awais Block")) {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("72,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7 Marla")) {
                            setCalculatorValues("108,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("134,000", "0", "0", "0", "0", "0", "0");
                        }
                    }
                }


                else if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_house) {
                    String s = binding.locationSpinner.getSelectedItem().toString();
                    if (s.equalsIgnoreCase("Bahria Town Phase 1 to 6"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("360,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("864,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("720,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {
                            setCalculatorValues("720,000", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Town Phase 7"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("237,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("381,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("468,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {
                            setCalculatorValues("561,600", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Town Phase 8"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("140,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("6 Marla")) {
                            setCalculatorValues("156,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7-8 Marla")) {
                            setCalculatorValues("156,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("218,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("327,600", "0", "0", "0", "0", "0", "0");
                        }
                    }


                    else if (s.equalsIgnoreCase("Bahria Greens (overseas)"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("140,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("218,400", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("327,600", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            //setCalculatorValues("", "0", "0", "0", "0", "0", "0");
                            //binding.calculation.setVisibility(View.GONE);
                        }

                    }


                    else if (s.equalsIgnoreCase("Bahria Town Safari Valley"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla")) {
                            setCalculatorValues("130,800", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("7 Marla")) {
                            setCalculatorValues("201,600", "0", "0", "0", "0", "0", "0");
                        }
                    }

                    else if (s.equalsIgnoreCase("Safari Villas"))
                    {
                        String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla Villa")) {
                            setCalculatorValues("360,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal Villa")) {
                            setCalculatorValues("540,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal Villa")) {
                            setCalculatorValues("864,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("3 Bed Apartment")) {
                            setCalculatorValues("360,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Bed Apartment")) {
                            setCalculatorValues("20,000 + 120/sq.ft", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("10 Marla Plot")) {
                            setCalculatorValues("240,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal Plot")) {
                            setCalculatorValues("330,000", "0", "0", "0", "0", "0", "0");
                        }
                    }

                    else if (s.equalsIgnoreCase("Garden City"))
                    {
                        /*String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("10 Marla")) {
                            setCalculatorValues("", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("1 Kanal")) {
                            setCalculatorValues("", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("2 Kanal")) {
                            setCalculatorValues("", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("4 Kanal")) {
                            setCalculatorValues("", "0", "0", "0", "0", "0", "0");
                        }*/
                    }


                    else if (s.equalsIgnoreCase("Safari Homes"))
                    {

                       /* String s1 = binding.sizeSpinner.getSelectedItem().toString();
                        if (s1.equalsIgnoreCase("5 Marla Single Story")) {
                            setCalculatorValues("504,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("5 Marla Double Story")) {
                            setCalculatorValues("504,000", "0", "0", "0", "0", "0", "0");
                        } else if (s1.equalsIgnoreCase("8 Marla Double Story")) {
                            setCalculatorValues("504,000", "0", "0", "0", "0", "0", "0");
                        }*/
                    }



                    else if (s.equalsIgnoreCase("Rafi Villas"))
                    {

                    }else if (s.equalsIgnoreCase("Awami Villas"))
                    {

                    }

                } else if (binding.radioGroup.getCheckedRadioButtonId() == R.id.radio_commercial) {
                    binding.sizeSpinner.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ConstantResources.sizeEmpty));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void setCalculatorValues(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        binding.purchaserTransferFee.setText(s);
        binding.purchaserStampDuty.setText(s1);
        binding.purchaserAdvanceIncomeTax.setText(s2);

        binding.sellerCapitalGainTax.setText(s3);
        binding.sellerNdcCharges.setText(s4);

        binding.possessionExpensePossessionCharges.setText(s5);
        binding.possessionExpenseUtilityConnection.setText(s6);


        binding.calculation.setVisibility(View.VISIBLE);
    }
}