package com.fci.shamim.employee_info.ModelCls;

import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fci.shamim.employee_info.EmployeeList;
import com.fci.shamim.employee_info.R;
import com.fci.shamim.employee_info.ShowEmployeeData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {

    private Context context;
    public  List<Employee> employeesList=new ArrayList<>();
    public EmployeeAdapter( Context context, List<Employee> employeesList) {
        super(context, R.layout.samplelist,employeesList);
        this.context=context;
        this.employeesList=employeesList;




    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.samplelist,parent,false);

        TextView nameTv=convertView.findViewById(R.id.nameSampleTvid);
        TextView designationTv=convertView.findViewById(R.id.designationSampleTvid);

        nameTv.setText(employeesList.get(position).getName());
        designationTv.setText(employeesList.get(position).getDesignation());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ShowEmployeeData.class);
                intent.putExtra("em",employeesList.get(position));
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
