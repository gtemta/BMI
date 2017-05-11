package com.example.pika.bmi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //定義會使用到的物件
    Button BT_calculate;
    EditText TF_height;
    EditText TF_weight;
    TextView TV_result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //讓介面中的物件與使用到的物件相對應
        BT_calculate = (Button)findViewById(R.id.BT_calculate);
        TF_height = (EditText)findViewById(R.id.TF_height);
        TF_weight = (EditText) findViewById(R.id.TF_weight);
        TV_result = (TextView)findViewById(R.id.TV_result);

        BT_calculate.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                double weight = Integer.parseInt(TF_weight.getText().toString());//單位目前仍是公分
                double height = Integer.parseInt(TF_height.getText().toString());
                double BMI = weight/((height/100)*(height/100));
                TV_result.setText( String.format("計算結果: %.2f", BMI));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
