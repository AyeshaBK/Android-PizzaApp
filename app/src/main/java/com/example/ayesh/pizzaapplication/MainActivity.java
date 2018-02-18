package com.example.ayesh.pizzaapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //DECLARE VARIABLES
    public double pizzaCost = 0;

    //DECLARE OBJECT VARIABLES
    public Button btn_Calc, btn_Clear;
    public RadioGroup rbg_Size;
    public RadioButton rb_Small, rb_Medium, rb_Large;
    public CheckBox chk_Chicken, chk_Mushroom, chk_Sausage, chk_Olives;
    public TextView txt_Cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalcCost();
    }

    public void CalcCost()
    {
        btn_Calc = (Button) findViewById(R.id.btnCalc);
        btn_Clear = (Button) findViewById(R.id.btnClear);

        rbg_Size = (RadioGroup) findViewById(R.id.rbgSize);

        rb_Small = (RadioButton) findViewById(R.id.rbSmall);
        rb_Medium = (RadioButton) findViewById(R.id.rbMedium);
        rb_Large = (RadioButton) findViewById(R.id.rbLarge);

        chk_Chicken = (CheckBox) findViewById(R.id.chkChicken);
        chk_Mushroom = (CheckBox) findViewById(R.id.chkMushroom);
        chk_Sausage = (CheckBox) findViewById(R.id.chkSausage);
        chk_Olives = (CheckBox) findViewById(R.id.chkOlives);

        txt_Cost = (TextView) findViewById(R.id.txtCost);

        rbg_Size.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_Small.isChecked()) {
                    pizzaCost = 35;
                } else if (rb_Medium.isChecked()) {
                    pizzaCost = 55;
                } else if (rb_Large.isChecked()) {
                    pizzaCost = 65;
                }
            }
        });

        btn_Calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_Chicken.isChecked()){
                    pizzaCost += 15;
                }
                if (chk_Mushroom.isChecked()){
                    pizzaCost += 7;
                }
                if (chk_Sausage.isChecked()){
                    pizzaCost += 10;
                }
                if (chk_Olives.isChecked()){
                    pizzaCost += 5;
                }

                btn_Calc.setEnabled(false);

                txt_Cost.setText("Total Cost: R" + String.valueOf(pizzaCost));
            }
        });

        btn_Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb_Small.setChecked(false);
                rb_Medium.setChecked(false);
                rb_Large.setChecked(false);

                chk_Chicken.setChecked(false);
                chk_Mushroom.setChecked(false);
                chk_Sausage.setChecked(false);
                chk_Olives.setChecked(false);

                btn_Calc.setEnabled(true);

                pizzaCost = 0;

                txt_Cost.setText(" ");
            }
        });
    }
}
