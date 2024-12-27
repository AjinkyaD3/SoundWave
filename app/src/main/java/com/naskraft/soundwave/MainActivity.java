package com.naskraft.soundwave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    DBHandler dbHandler ;
    TextView name,email,phoneno;
    String[] country = { "India", "USA", "China", "Japan", "Other"};
    String[] blank = { ""};
    String[] IndiaState = { "Maharashtra", "Gujarat", "Rajasthan"};
    String[] Gujratcity = new String[]{"Ahmedabad","Amreli district", "Anand", "Banaskantha", "Bharuch", "Bhavnagar", "Gandhinagar",
//            'Jamnagar',
//            'Junagadh',
//            'Kutch',
//            'Kheda',
//            'Mehsana',
//            'Narmada',
//            'Navsari',
//            'Patan',
//            'Panchmahal',
//            'Porbandar',
//            'Rajkot',
//            'Sabarkantha',
//            'Surendranagar',
//            'Surat',
//            'Vyara',
//            'Vadodara',
            "Valsad"};
String[] Maharashtracity = new String[]{"Ahmednagar",
        "Akola",        "Amravati",        "Aurangabad",        "Beed",        "Buldhana",        "Chandrapur",        "Dhule",        "Gadchiroli",        "Gondia",
        "Hingoli",        "Jalgaon",        "Jalna"       };
    String[] RajasthanCity= {
            "Jaipur",
            "Jodhpur",
            "Ajmer",
            "Pushkar",
            "Udaipur",
            "Jaisalmer",
            "Bharatpur",
            "Sawai Madhopur",
            "Samode",
            "Mandawa",
            "Mount Abu",
            "Bikaner",
    };

    String[] USAState = { "Atlanta", "CA", "TX", "Ohio"};
    String[] ChinaState = { "Wuhan", "Bejieng", "Xhenheing", "Ching Chong"};
    String[] JapanState = { "Tokyo", "Kawasaki", "Hiroshima", "Kyoto", "Osaka"};
    Spinner spin_state;
    Spinner spin_city;
    ArrayAdapter stateaa = null;
    ArrayAdapter cityaa = null;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.edt_name);
        email=(EditText)findViewById(R.id.edt_email);
        phoneno=(EditText)findViewById(R.id.edt_mobno);
        login=(Button)findViewById(R.id.btn_login);
        Spinner spin_country = (Spinner)findViewById(R.id.snip_country);
        spin_state= (Spinner) findViewById(R.id.snip_state);
        spin_city= (Spinner) findViewById(R.id.snip_city);
        spin_country.setOnItemSelectedListener(this);
        spin_state.setOnItemSelectedListener(this);
        spin_city.setOnItemSelectedListener(this);
        dbHandler = new DBHandler(MainActivity.this);


        ArrayAdapter countryaa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        countryaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_country.setAdapter(countryaa);
        spin_country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(country[i].equals("USA"))
                {
                    Toast.makeText(getApplicationContext(),"USA SELECTED  now in state selection", Toast.LENGTH_LONG).show();
                    stateaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,USAState);


                }

                if(country[i].equals("India"))
                {

                    stateaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,IndiaState);



                }


                if(country[i].equals("Japan"))
                {
                    stateaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,JapanState);



                } if(country[i].equals("China"))
                {
                    stateaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,ChinaState);



                }
                spin_state.setAdapter(stateaa);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        })   ;
        spin_state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spin_city.setAdapter(null);
                if(spin_state.getSelectedItem().toString().equals("Maharashtra"))
                {
                    cityaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,Maharashtracity);
                    cityaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin_city.setAdapter(cityaa);
                }

                if(spin_state.getSelectedItem().toString().equals("Gujarat"))
                {
                    System.out.println("---> " +spin_state.getSelectedItem().toString());
                    cityaa = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,Gujratcity);
                    cityaa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin_city.setAdapter(cityaa);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")||phoneno.getText().toString().equals("")||email.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Fiels are Mandotory",Toast.LENGTH_LONG).show();
                    return;
                }else{
                    Intent intent = new Intent(getApplicationContext(),OTPPage.class);
                    intent.putExtra("FULLNAME",name.getText().toString() );
                    intent.putExtra("PHONENO",phoneno.getText().toString() );
                    intent.putExtra("EMAIL",email.getText().toString() );
                    startActivity(intent);
                    dbHandler.addNewRow(name.getText().toString(),email.getText().toString(),phoneno.getText().toString());

                }}
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}