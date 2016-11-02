package com.example.myaddress;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by nucur on 10/22/2016.
 */

public class ShowMeActivity extends Activity {

    private static final String TAG = "MyAddress/ShowMe";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i (TAG, "Dmitry Zuev n01112600");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_me);

        TextView fname;
        TextView lname;
        TextView country;
        TextView address;
        TextView postal;
        TextView suffix;
        TextView province;

        fname = (TextView) findViewById(R.id.edit_fname);
        lname = (TextView) findViewById(R.id.edit_lname);
        country = (TextView) findViewById(R.id.edit_country);
        address = (TextView) findViewById(R.id.edit_address);
        postal = (TextView) findViewById(R.id.edit_postal);
        province = (TextView) findViewById(R.id.edit_province);
        suffix = (TextView) findViewById(R.id.edit_suffix);

        String fnameText = getIntent().getStringExtra("fname");
        String lnameText = getIntent().getStringExtra("lname");
        String countryText = getIntent().getStringExtra("country");
        String addressText = getIntent().getStringExtra("address");
        String postalText = getIntent().getStringExtra("postal");
        String suffixText = getIntent().getStringExtra("suffix");
        String provinceText = getIntent().getStringExtra("province");


        fname.setText(fnameText);
        lname.setText(lnameText);
        country.setText(countryText);
        address.setText(addressText);
        postal.setText(postalText);
        province.setText(provinceText);
        suffix.setText(suffixText);

    }
}
