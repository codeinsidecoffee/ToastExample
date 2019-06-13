package com.mrlonewolfer.toastexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnToast,btnCustomToast;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btnCustomToast=findViewById(R.id.btnCustomToast);
        btnToast=findViewById(R.id.btnToast);
        btnToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnToast){
            showToastDailog();
        }
        if(v.getId()==R.id.btnCustomToast){
            showCustomToast();
        }
            }

            @SuppressLint("NewApi")
            private void showCustomToast() {
                LayoutInflater layoutInflater=getLayoutInflater();
                View layoutView=layoutInflater.inflate(R.layout.custom_toast_layout,
                        (ViewGroup) findViewById(R.id.mycustomAlert));
                Button btnCancel,btnSubmit;
                final EditText edtName,edtEmail;
                ImageView imageView;
                edtName=layoutView.findViewById(R.id.edtName);
                edtEmail=layoutView.findViewById(R.id.edtEmail);
                btnCancel=layoutView.findViewById(R.id.btnCancle);
                btnSubmit=layoutView.findViewById(R.id.btnSubmit);
                imageView=layoutView.findViewById(R.id.imgview);
                imageView.setVisibility(View.VISIBLE);
                edtEmail.setVisibility(View.GONE);
                edtName.setVisibility(View.GONE);
                btnCancel.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.GONE);

                Toast toast = new Toast(context);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layoutView);




        toast.show();
    }

    private void showToastDailog() {
        Toast toast= Toast.makeText(context,"Thank You for Toasting",Toast.LENGTH_SHORT);
        toast.show();
    }
}
