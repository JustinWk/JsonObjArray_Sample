package com.example.myxlab.samplehelloworld;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    String strJson = "{ \"Employee\" :[{\"id\":\"1021\",\"name\":\"Waqas Khalid\",\"salary\":\"800\"},{\"id\":\"1112\",\"name\":\"Asra Khalid\",\"salary\":\"120000\"},{\"id\":\"1432\",\"name\":\"Tooba Khalid\",\"salary\":\"160000\"},{\"id\":\"1232\",\"name\":\"Alia Khalid\",\"salary\":\"180000\"}] }";
    String strJsonArray = "[{\"id\":\"1021\",\"name\":\"Waqas Khalid\",\"salary\":\"800\"},{\"id\":\"1112\",\"name\":\"Asra Khalid\",\"salary\":\"120000\"},{\"id\":\"1432\",\"name\":\"Tooba Khalid\",\"salary\":\"160000\"},{\"id\":\"1232\",\"name\":\"Alia Khalid\",\"salary\":\"180000\"}]";
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.textView1);


    }

    public void getJsonObj(View view) {
        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");



            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "JSObject Node" + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n\n ";
            }

            output.setText(data);
            output.setGravity(Gravity.LEFT);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getJsonArray(View view) {
        String data = "";
        try {
            // Create the root JSONObject from the JSON string.
            //JSONObject  jsonRootObject = new JSONObject(strJson);

            //Get the instance of JSONArray that contains JSONObjects
            //JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");


            JSONArray jsonArray = new JSONArray(strJsonArray);
            //Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id").toString());
                String name = jsonObject.optString("name").toString();
                float salary = Float.parseFloat(jsonObject.optString("salary").toString());

                data += "Array Item " + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n \n";
            }

            output.setText(data);
            output.setGravity(Gravity.RIGHT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}