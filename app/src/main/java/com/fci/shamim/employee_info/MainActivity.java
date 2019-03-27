package com.fci.shamim.employee_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.fci.shamim.employee_info.ModelCls.Employee;

public class MainActivity extends AppCompatActivity {

    String selsectedDate;
    EditText nameEt,designationEt,salaryEt,addressEt,phoneEt,emailEt,dateEt,ageEt;
    RadioGroup radioGroupGender;
    Spinner spinner_Dep;
    CheckBox cCb,javaCb,phpCb;
    String gender="Male";
    String dep;


    Button submitbtn,cleanBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();


        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);

                gender=rb.getText().toString();
                toast(gender+" is Selected");

            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEt.getText().toString();
                String designation=designationEt.getText().toString();
                String salary=salaryEt.getText().toString();
                String address= addressEt.getText().toString();
                String phone= phoneEt.getText().toString();
                String email=  emailEt.getText().toString();
                String dateofbirth= dateEt.getText().toString();
                String age= ageEt.getText().toString();
             //   dep=spinner_Dep.getSelectedItem().toString();
                Employee employee=new Employee(name,designation,salary,address,phone,email,dateofbirth,age,gender);

                Employee.employeeList.add(employee);
                Intent intent=new Intent(getApplicationContext(),EmployeeList.class);
                startActivity(intent);



            }
        });


        cleanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameEt.setText("");
                designationEt.setText("");
                salaryEt.setText("");
                addressEt.setText("");
                phoneEt.setText("");
                emailEt.setText("");
                dateEt.setText("");
                ageEt.setText("");
            }
        });

    }
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
    public  void findId(){
        nameEt=findViewById(R.id.nameEtId);
        designationEt=findViewById(R.id.DesignationEtId);
        salaryEt=findViewById(R.id.salaryEtId);
        addressEt=findViewById(R.id.addressEtId);
        phoneEt=findViewById(R.id.phoneEtId);
        emailEt=findViewById(R.id.emailEtId);
        dateEt=findViewById(R.id.dateOfBirthEtId);
        ageEt=findViewById(R.id.agelEtId);
        radioGroupGender=findViewById(R.id.radioGroupFOrGenderId);
        submitbtn=findViewById(R.id.submitBtnId);
        cleanBtn=findViewById(R.id.cleanBtnId);
    }

    public void selectDate(View view) {


    }
}
