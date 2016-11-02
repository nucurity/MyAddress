package com.example.myaddress;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MyAddress/Form";

    EditText fname;
    EditText lname;
    EditText country;
    EditText address;
    EditText postal;
    Spinner province;
    RadioGroup rg_suffix;
    RadioButton mr;
    RadioButton ms;
    RadioButton mrs;
    RadioButton dr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i (TAG, "Dmitry Zuev n01112600");

        setUpBinding();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.province_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        province.setAdapter(adapter);

        View submit = findViewById(R.id.btn_submit);

        submit.setOnClickListener(this);
    }

    public void onClick(View v) {



        String fnameText = fname.getText().toString();
        String lnameText = lname.getText().toString();
        String addressText = address.getText().toString();
        String countryText = country.getText().toString();
        String postalText = postal.getText().toString();
        String provinceText = province.getSelectedItem().toString();
        int selectedId = rg_suffix.getCheckedRadioButtonId();

        //logic
        boolean flag = true;
        if(fnameText.equals("")){
            flag = false;
            Toast.makeText(this, "Enter First Name", Toast.LENGTH_LONG).show();
        }
        else if(lnameText.equals("")){
            flag = false;
            Toast.makeText(this, "Enter Last Name", Toast.LENGTH_LONG).show();
        }
        else if(addressText.equals("")){
            flag = false;
            Toast.makeText(this, "Enter Address", Toast.LENGTH_LONG).show();
        }
        else if(countryText.equals("")){
            flag = false;
            Toast.makeText(this, "Enter Country", Toast.LENGTH_LONG).show();
        }
        else if(postalText.equals("")){
            flag = false;
            Toast.makeText(this, "Enter Postal Code", Toast.LENGTH_LONG).show();
        }
        else if(provinceText.equals("Not applicable") && (countryText.toLowerCase().equals("canada"))){
            //"Not applicable" option was made for all outside canada.
            flag = false;
            Toast.makeText(this, "Enter Province for Canada", Toast.LENGTH_LONG).show();
        }
        else if(selectedId < 0){
            flag = false;
            Toast.makeText(this, "Select Title", Toast.LENGTH_LONG).show();
        }
        else {
            RadioButton rb = (RadioButton) findViewById(selectedId);
            String suffix = rb.getText().toString();

            Intent intent = new Intent(MainActivity.this, ShowMeActivity.class);

            intent.putExtra("fname", fnameText);
            intent.putExtra("lname", lnameText);
            intent.putExtra("address", addressText);
            intent.putExtra("country", countryText);
            intent.putExtra("postal", postalText);
            intent.putExtra("province", provinceText);
            intent.putExtra("suffix", suffix);

            startActivity(intent);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            this.startActivity(intent);
        } else if (item.getItemId() == R.id.menu_clear) {
            fname.setText("");
            lname.setText("");
            address.setText("");
            country.setText("");
            postal.setText("");
            province.setSelection(0);
            mr.setChecked(false);
            ms.setChecked(false);
            mrs.setChecked(false);
            dr.setChecked(false);
        }
        return true;
    }

    public void setUpBinding() {
        fname = (EditText) findViewById(R.id.edit_fname);
        lname = (EditText) findViewById(R.id.edit_lname);
        country = (EditText) findViewById(R.id.edit_country);
        address = (EditText) findViewById(R.id.edit_address);
        postal = (EditText) findViewById(R.id.edit_postal);
        province = (Spinner) findViewById(R.id.spinner_province);
        mr = (RadioButton) findViewById(R.id.rb_mr);
        ms = (RadioButton) findViewById(R.id.rb_ms);
        mrs = (RadioButton) findViewById(R.id.rb_mrs);
        dr = (RadioButton) findViewById(R.id.rb_dr);
        rg_suffix = (RadioGroup) findViewById(R.id.rg_suffix);
    }
}