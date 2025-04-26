package com.example.ex_9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    TextView employeeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up custom toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Employee Details from JSON");
        setSupportActionBar(toolbar);

        employeeDetails = findViewById(R.id.employeeDetails);

        // Hardcoded JSON string
        String jsonMessage = "{ \"employees\": [" +
                "{ \"name\": \"John Doe\", \"id\": \"EMP001\", \"age\": 30, \"salary\": 50000, \"department\": \"IT\", \"experience\": \"5 years\" }," +
                "{ \"name\": \"Jane Smith\", \"id\": \"EMP002\", \"age\": 28, \"salary\": 48000, \"department\": \"HR\", \"experience\": \"3 years\" }" +
                "]}";

        try {
            JSONObject jsonObject = new JSONObject(jsonMessage);
            JSONArray employeesArray = jsonObject.getJSONArray("employees");

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < employeesArray.length(); i++) {
                JSONObject emp = employeesArray.getJSONObject(i);

                result.append("Name: ").append(emp.getString("name")).append("\n")
                        .append("ID: ").append(emp.getString("id")).append("\n")
                        .append("Age: ").append(emp.getInt("age")).append("\n")
                        .append("Salary: ₹").append(emp.getInt("salary")).append("\n")
                        .append("Department: ").append(emp.getString("department")).append("\n")
                        .append("Experience: ").append(emp.getString("experience")).append("\n\n");
            }

            employeeDetails.setText(result.toString());

        } catch (JSONException e) {
            employeeDetails.setText("Error parsing JSON.");
        }
    }
}
