package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGetAll;
    private EditText etName;
    private DatabaseHelper databaseHelper;
    private TextView tvNames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStore = findViewById(R.id.btnstore);
        btnGetAll = findViewById(R.id.btngetall);
        etName = findViewById(R.id.etname);
        tvNames = findViewById(R.id.tvnames);
        databaseHelper = new DatabaseHelper(this);

        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etName.getText().toString());
                etName.setText("");
                Toast.makeText(MainActivity.this,"Stored Succesfully!",Toast.LENGTH_SHORT).show();
            }
        });

        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvNames.setText("");
                for (int i=0; i<arrayList.size(); i++){
                    tvNames.setText(tvNames.getText().toString()+", "
                            +arrayList.get(i));
                }
            }
        });
    }
}