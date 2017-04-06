package com.example.mypc.seventhsessionstudentrecord74;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mypc.seventhsessionstudentrecord74.Adapter.CustomAdapter;
import com.example.mypc.seventhsessionstudentrecord74.Database.DBHelper;
import com.example.mypc.seventhsessionstudentrecord74.Model.StudentData;
import com.example.mypc.seventhsessionstudentrecord74.Utils.CommonUtilities;
import com.example.mypc.seventhsessionstudentrecord74.Utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<StudentData> dataList;

    DBHelper dbHelper;
    String[] first_name= new String[]{
            "Narinder", "Happy", "Mukesh","Sukhdeep"
    };
    String[] last_names= new String[]{
            "Singh", "Gumber", "Kumar","Singh"
    };
    String[] ids= new String[]{"1234", "2345", "3456","2234"};
    ListView list;
    private static final int reqCode=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper= CommonUtilities.getDBObject(this);
        list= (ListView)findViewById(R.id.list);
        int count= dbHelper.getFullCount(Constants.STUDENT_RECORD, null);
        if(count==0) {
            insertStudentRecord();
        }
        ArrayList<StudentData> model = new ArrayList<>();
        dataList = dbHelper.getAllStudents();


        for(int i=0; i<first_name.length; i++){
            StudentData handlerdata= new StudentData();
            handlerdata.setId(dataList.get(i).getId());
            handlerdata.setFirstname(dataList.get(i).getFirstname());
            handlerdata.setLastname(dataList.get(i).getLastname());
            model.add(handlerdata);
        }

        CustomAdapter dap = new CustomAdapter(this, model);
        list.setAdapter(dap);
        dataList = dbHelper.getAllStudents();

    }

    private void insertStudentRecord(){
        for(int i=0; i<first_name.length; i++) {
            ContentValues vals = new ContentValues();
            vals.put(Constants.FIRST_NAME, first_name[i]);
            vals.put(Constants.LAST_NAME, last_names[i]);
            dbHelper.insertContentVals(Constants.STUDENT_RECORD, vals);
        }
    }

}
