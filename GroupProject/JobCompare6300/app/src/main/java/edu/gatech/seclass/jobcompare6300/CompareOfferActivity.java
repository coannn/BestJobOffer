package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CompareOfferActivity extends AppCompatActivity {

    ArrayList<Double> sortedScore = new ArrayList<>();
    public HashMap<Double, Job> rankTable = new HashMap<Double, Job>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_offer);

        OfferComparison offerCompare = new OfferComparison();
        LinearLayout featuresTable = (LinearLayout) findViewById(R.id.checkBoxID);

        //show table in the text
        FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);

        ArrayList<Job> jobList = dbHelper.getAllJobOffer();

        for (int i = 0; i < jobList.size(); i++) {
            Double score = offerCompare.computeJobScoreRank(jobList.get(i), dbHelper);
            sortedScore.add(score);
            rankTable.put(score, jobList.get(i));
        }

        Collections.sort(sortedScore);
        Collections.reverse(sortedScore);

        System.out.println(rankTable);
        System.out.println(sortedScore);
        for (int i =0; i <sortedScore.size(); i++) {
            Job jobTemp = rankTable.get(sortedScore.get(i));
            CheckBox checkBox = new CheckBox(this);
            checkBox.setText(jobTemp.getTitle()+"@"+jobTemp.getCompany());
            featuresTable.addView(checkBox);
        }
    }

    public void compareSelectedJob(View view) {
        Button compareButton = (Button) findViewById(R.id.compareJobID);
        if (view.getId() == R.id.compareJobID) {
            //need to add
            System.out.println("compare selected jobs");
            ArrayList<Integer> count;
            count = itemClicked(view);
            ArrayList<Job> twoJobs= new ArrayList<>();

            if(count.size() != 2){
                Toast errorToast = Toast.makeText(this, "Must select two jobs only!!", Toast.LENGTH_SHORT);
                errorToast.show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            } else {
                for (int i = 0; i < 2; i++) {
                    int n = count.get(i);
                    twoJobs.add(rankTable.get(sortedScore.get(n)));
                }

                Intent intent = new Intent(CompareOfferActivity.this, CompareTwoJobsActivity.class);
                String job1, job2;
                job1 = "Company: " + twoJobs.get(0).getCompany() + "\n"
                        + "Title: " + twoJobs.get(0).getTitle() + "\n"
                        + "Salary: " + twoJobs.get(0).getYearlySalary() + "\n"
                        + "Bonus: " + twoJobs.get(0).getYearlyBonus() + "\n"
                        + "Relocation Stipend: " + twoJobs.get(0).getRelocationStipend() + "\n"
                        + "Retirement Benefits: " + twoJobs.get(0).getRetirementBenefit() + "\n"
                        + "Stocks: " + twoJobs.get(0).getRsu() + "\n";

                job2 = "Company: " + twoJobs.get(1).getCompany() + "\n"
                        + "Title: " + twoJobs.get(1).getTitle() + "\n"
                        + "Salary: " + twoJobs.get(1).getYearlySalary() + "\n"
                        + "Bonus: " + twoJobs.get(1).getYearlyBonus() + "\n"
                        + "Relocation Stipend: " + twoJobs.get(1).getRelocationStipend() + "\n"
                        + "Retirement Benefits: " + twoJobs.get(1).getRetirementBenefit() + "\n"
                        + "Stocks: " + twoJobs.get(1).getRsu() + "\n";

                Bundle extras = new Bundle();
                extras.putString("job1", job1);
                extras.putString("job2", job2);
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
    }

    public ArrayList itemClicked(View view) {
        LinearLayout featuresTable = (LinearLayout) findViewById(R.id.checkBoxID);
        //code to check if this checkbox is checked!
        ArrayList<Integer> count = new ArrayList();
        for(int i = 0; i < featuresTable.getChildCount(); i++) {
            if(((CheckBox)featuresTable.getChildAt(i)).isChecked()){
                count.add(i);
            }
        }
        return count;
    }

    public void rankReturnMainMenu(View view) {
        if (view.getId() == R.id.rankReturnID) {
            Intent intent = new Intent(CompareOfferActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

}