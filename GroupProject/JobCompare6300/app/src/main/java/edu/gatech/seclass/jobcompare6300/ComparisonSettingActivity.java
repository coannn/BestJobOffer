package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ComparisonSettingActivity extends AppCompatActivity {
    private EditText salarySetting;
    private EditText bonusSetting;
    private EditText retireBenefitSetting;
    private EditText relocateSetting;
    private EditText stockSetting;
    private Button saveSetting;
    private Button returnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparison_settings);

        Intent intent = getIntent();
        String message = intent.getStringExtra("IDK");

        saveSetting = (Button) findViewById(R.id.saveComparisonID);
        returnMain = (Button) findViewById(R.id.returnID);
        salarySetting = findViewById(R.id.salaryID);
        bonusSetting = findViewById(R.id.bonusID);
        retireBenefitSetting = findViewById(R.id.retireID);
        relocateSetting = findViewById(R.id.relocateID);
        stockSetting = findViewById(R.id.stockID);

        FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);

        ComparisonSettings setting = dbHelper.getDataComparisonSettings();
        System.out.println(setting);
        salarySetting.setText(setting.getWeightYearlySalary().toString());
        bonusSetting.setText(setting.getWeightYearlyBonus().toString());
        retireBenefitSetting.setText(setting.getWeightRetirementBenefits().toString());
        relocateSetting.setText(setting.getWeightRelocationStipend().toString());
        stockSetting.setText(setting.getWeightRestrictedStockUnit().toString());

    }

    public void saveCurrentComparison(View view) {
        if (view.getId() == R.id.saveComparisonID) {
            System.out.println("saved comparison settings");
            ComparisonSettings comparisonSettings = new ComparisonSettings();

            int salary = Integer.valueOf(salarySetting.getText().toString());
            int bonus = Integer.valueOf(bonusSetting.getText().toString());
            int retire = Integer.valueOf(retireBenefitSetting.getText().toString());
            int relocate = Integer.valueOf(relocateSetting.getText().toString());
            int stock = Integer.valueOf(stockSetting.getText().toString());

            comparisonSettings.setComparison(salary, bonus, retire, relocate, stock);
            /* save to database */
            FeedReaderDbHelper dbHelper = FeedReaderDbHelper.getInstance(this);

            dbHelper.insertDataComparison(comparisonSettings);
            System.out.println(dbHelper.getDataComparisonSettings().getWeightYearlySalary());
        }
    }

    public void returnMainMenu(View view) {
        if (view.getId() == R.id.returnID) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


}