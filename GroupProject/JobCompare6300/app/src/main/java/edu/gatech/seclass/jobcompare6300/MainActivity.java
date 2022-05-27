package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enterOrEditCurrentJob(View view) {
        if (view.getId() == R.id.enterorEditCurrentJobDetailsID) {
            // Check if a job is created
            FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);
            Job existingJob = dbHelper.getCurrentJob();

            // If job is not created than create one
            if (existingJob.city == null){
                // Navigate to Create Job page
                Intent intent = new Intent(this, EnterJobDetailsActivity.class);
                startActivity(intent);
            } else {
                // Else edit details of current job
                // Navigate to Edit Job page
                Intent intent = new Intent(this, EnterJobDetailsActivity.class);
                String message = "Edit Current Job Message";
                intent.putExtra("editFlag", message);
                intent.putExtra("id", Integer.toString(existingJob.id));
                intent.putExtra("company", existingJob.company);
                intent.putExtra("city", existingJob.city);
                intent.putExtra("state", existingJob.state);
                intent.putExtra("costOfLiving", Integer.toString(existingJob.costOfLiving));
                intent.putExtra("yearlyBonus", Double.toString(existingJob.yearlyBonus));
                intent.putExtra("yearlySalary", Double.toString(existingJob.yearlySalary));
                intent.putExtra("relocationStipend", Double.toString(existingJob.relocationStipend));
                intent.putExtra("retirementBenefit", Integer.toString(existingJob.retirementBenefit));
                intent.putExtra("rsu", Double.toString(existingJob.rsu));
                intent.putExtra("title", existingJob.title);
                startActivity(intent);
            }
        }
    }

    public void enterJobOffer(View view) {

        if (view.getId() == R.id.enterJobOfferID) {
            FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);
            ArrayList<Job> offers = dbHelper.getAllJobOffer();
            System.out.println(offers);

            Intent intent = new Intent(this, EnterJobOfferDetailsActivity.class);
            startActivity(intent);
        }

    }
  
    public void comparisonSetting(View view) {
        if (view.getId() == R.id.adjustComparisonSettingsID) {
            Intent intent = new Intent(this, ComparisonSettingActivity.class);
            startActivity(intent);
        }
    }

    public void compareOffer(View view) {
        if (view.getId() == R.id.compareJobOfferID) {
            Intent intent = new Intent(this, CompareOfferActivity.class);
            startActivity(intent);
        }
    }
}