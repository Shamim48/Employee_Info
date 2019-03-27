package com.fci.shamim.employee_info;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fci.shamim.employee_info.ModelCls.Employee;

public class ShowEmployeeData extends AppCompatActivity {
    TextView nameEt,designation,salary,address,phone,email,dob,age,gender,dep,sub;
    Button locationBtn,callBtn,emailBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee_data);
        findId();

        Intent intent=getIntent();

        final Employee employee= (Employee) intent.getSerializableExtra("em");

        nameEt.setText(employee.getName());
        designation.setText(employee.getDesignation());
        salary.setText(employee.getSalary());
        address.setText(employee.getAddress());
        phone.setText(employee.getPhone());
        email.setText(employee.getEmail());
        dob.setText(employee.getDate());
        age.setText(employee.getAge());
        gender.setText(employee.getGender());

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+employee.getPhone()));
                startActivity(callIntent);

            }
        });
        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent=new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,employee.getEmail());
                startActivity(emailIntent);
            }
        });

        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent locationIntent=new Intent(Intent.ACTION_VIEW);
                locationIntent.setData(Uri.parse("geo:0,0?q="+employee.getAddress()));
                startActivity(locationIntent);
            }
        });


    }

    public void  findId(){
        nameEt=findViewById(R.id.showNameTvId);
        address=findViewById(R.id.addressShowTvId);
        phone=findViewById(R.id.phoneShowTvId);
        email=findViewById(R.id.emailShowTvId);
        dob=findViewById(R.id.dobShowTvId);
        age=findViewById(R.id.ageShowTvId);
        gender=findViewById(R.id.genderShowTvId);
        designation=findViewById(R.id.showDesignationTvId);
        salary=findViewById(R.id.showSalaryTvId);


        // find Id  Button

        locationBtn=findViewById(R.id.LocationBtnId);
        callBtn=findViewById(R.id.CallBtnId);
        emailBtn=findViewById(R.id.emailBtnId);


    }
}
