package com.asldaw.billappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText edit_price, edit_vat;
    Button btn_calculate;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_price = findViewById(R.id.edit_price);
        edit_vat = findViewById(R.id.edit_vat);
        btn_calculate = findViewById(R.id.btn_calculate);

        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int price = Integer.valueOf(edit_price.getText().toString());
                int vat = Integer.valueOf(edit_vat.getText().toString());

                int total_price = ((price+vat)/100)+price;

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_dialog);

                ImageView X = dialog.findViewById(R.id.X);
                TextView explanation = dialog.findViewById(R.id.Explanation);
                Button okay = dialog.findViewById(R.id.Okay);

                explanation.setText("Entered Price: " + price + "\n" + "Vat Rate: " + vat + "\n" + "Total Price: " + total_price);

                X.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Document Reviewed", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });

    }
}