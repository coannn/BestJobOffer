package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterJobOfferDetailsActivity extends AppCompatActivity {

    private EditText titleText;
    private EditText companyText;
    private EditText cityText;
    private EditText stateText;
    private EditText costOfLivingText;
    private EditText yearlySalaryText;
    private EditText yearlyBonusText;
    private EditText retirementBenefitText;
    private EditText relocationStipendText;
    private EditText restrictedStockUnitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_job_offer_details);

        titleText = findViewById(R.id.editTextEnterTitle);
        companyText= findViewById(R.id.editTextEnterCompany);
        cityText = findViewById(R.id.editTextEnterCity);
        stateText = findViewById(R.id.editTextEnterState);
        costOfLivingText= findViewById(R.id.editTextEnterCostOfLiving);
        yearlySalaryText= findViewById(R.id.editTextEnterYearlySalary);
        yearlyBonusText= findViewById(R.id.editTextEnterYearlyBonus);
        retirementBenefitText= findViewById(R.id.editTextEnterRetirementBenefit);
        relocationStipendText= findViewById(R.id.editTextEnterRelocationStipend);
        restrictedStockUnitText= findViewById(R.id.editTextEnterRestrictedStockUnit);
    }

    public void saveJobOffer(View view) {
        if (view.getId() == R.id.saveJobOfferID) {
            if (checkDataEntry()==true) {
                Job job = new Job();
                job.setCompany(companyText.getText().toString());
                job.setCity(cityText.getText().toString());
                job.setState(stateText.getText().toString());
                job.setLocation(cityText.getText().toString() + " , " + stateText.getText().toString());
                job.setCostOfLiving(Integer.parseInt(costOfLivingText.getText().toString()));
                job.setYearlyBonus(Integer.parseInt(yearlyBonusText.getText().toString()));
                job.setYearlySalary(Integer.parseInt(yearlySalaryText.getText().toString()));
                job.setRelocationStipend(Double.parseDouble(relocationStipendText.getText().toString()));
                job.setRetirementBenefit(Integer.parseInt(retirementBenefitText.getText().toString()));
                job.setRsu(Double.parseDouble(restrictedStockUnitText.getText().toString()));
                job.setTitle(titleText.getText().toString());

                FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);
                dbHelper.insertJobOffer(job);

                //Refresh the page
                Intent intent = new Intent(this, EnterJobOfferDetailsActivity.class);
                startActivity(intent);
            }
        }
    }

    public void cancelJobOffer(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void returnMainMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void enterAnotherJobOffer(View view){
        Intent intent = new Intent(this, EnterJobOfferDetailsActivity.class);
        startActivity(intent);
    }

    public void compareOffer(View view){
        Intent intent = new Intent(this, CompareOfferActivity.class);
        startActivity(intent);
    }

    private Boolean checkDataEntry() {
        String Title= titleText.getText().toString();
        String Company = companyText.getText().toString();
        String State = stateText.getText().toString();
        String City = cityText.getText().toString();
        String COL = costOfLivingText.getText().toString();
        String YB = yearlyBonusText.getText().toString();
        String YS = yearlySalaryText.getText().toString();
        String Relocation = relocationStipendText.getText().toString();
        String Retirement = retirementBenefitText.getText().toString();
        String RSU = restrictedStockUnitText.getText().toString();


        if (Title.isEmpty()) {
            titleText.setError("This field cannot be blank");
            return false;
        }

        if (Company.isEmpty()) {
            companyText.setError("This field cannot be blank");
            return false;
        }
        if (COL.isEmpty()) {
            costOfLivingText.setError("This field cannot be blank");
            return false;
        }
        if (YS.isEmpty()) {
            yearlySalaryText.setError("This field cannot be blank");
            return false;
        }
        if (YB.isEmpty()) {
            yearlyBonusText.setError("This field cannot be blank");
            return false;
        }
        if (Retirement.isEmpty()) {
            retirementBenefitText.setError("This field cannot be blank");
            return false;
        }
        if (Relocation.isEmpty()) {
            relocationStipendText.setError("This field cannot be blank");
            return false;
        }

        if (RSU.isEmpty()) {
            restrictedStockUnitText.setError("This field cannot be blank");
            return false;
        }

        return true;
    }




}