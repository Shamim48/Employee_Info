package com.fci.shamim.employee_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.fci.shamim.employee_info.ModelCls.Employee;
import com.fci.shamim.employee_info.ModelCls.EmployeeAdapter;

public class EmployeeList extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        listView=findViewById(R.id.EmployeeListId);

        listView.setAdapter(new EmployeeAdapter(this,Employee.employeeList));
    }

    public void addNewItem(View view) {

        startActivity(new Intent(getApplicationContext(),MainActivity.class));

    }
}
