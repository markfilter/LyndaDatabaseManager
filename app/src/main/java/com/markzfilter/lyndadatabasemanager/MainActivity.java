package com.markzfilter.lyndadatabasemanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.markzfilter.lyndadatabasemanager.databaseHelper.MyDataSource;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MyDataSource dataSource;
    private TextView mLog, mSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSource = new MyDataSource(this);
        dataSource.initData(); // Checks to see if there is any data stored
        // in the database.  It will check to see the number of rows stored
        // in the database table.
    }

    @Override
    public void onClick(View v) {
        searchDatabase(v);
    }

    public void searchDatabase(View view) {

        String searchString = mSearch.getText().toString();

        if (searchString.length() == 0) {
            Toast.makeText(MainActivity.this, "Enter an integer between 1 and 100",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        int indexValue = new Integer(searchString);

        Cursor cursor = dataSource.selectRecord(indexValue);
        if (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(MyDataSource.PERSON_NAME));
            Toast.makeText(MainActivity.this, "You found " + name, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Person not found", Toast.LENGTH_SHORT).show();
        }

    }


}
