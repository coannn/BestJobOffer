package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompareTwoJobsActivity extends AppCompatActivity {
    private TextView Job1;
    private TextView Job2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_jobs);
        CompareOfferActivity ca = new CompareOfferActivity();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String job1 = extras.getString("job1");
        String job2 = extras.getString("job2");

        System.out.println(job1);

        Job1 = (TextView) findViewById(R.id.job1ID);
        Job2 = (TextView) findViewById(R.id.job2ID);

        //show table in the text
        Job1.setText(job1);
        Job2.setText(job2);
    }

    public void selectOtherJob(View view) {
        if (view.getId() == R.id.selectOtherJobID) {
            //need to add select option
            System.out.println("compare selected jobs");
            Intent intent = new Intent(CompareTwoJobsActivity.this, CompareOfferActivity.class);
            startActivity(intent);

        }
    }

    public void jobReturnMainMenu(View view) {
        if (view.getId() == R.id.jobReturnID) {
            Intent intent = new Intent(CompareTwoJobsActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
