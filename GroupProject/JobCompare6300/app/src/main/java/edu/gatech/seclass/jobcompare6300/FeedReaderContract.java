package edu.gatech.seclass.jobcompare6300;

import android.provider.BaseColumns;

public class FeedReaderContract {
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class CurrentJobEntry implements BaseColumns {
        public static final String TABLE_NAME = "currentJob";
        public static final String CURRENT_JOB_TITLE = "currentJobTitle";
        public static final String CURRENT_JOB_COMPANYNAME = "currentJobCompanyName";
        public static final String CURRENT_JOB_LOCATION = "currentJobLocation";
        public static final String CURRENT_JOB_CITY = "currentJobCity";
        public static final String CURRENT_JOB_STATE = "currentJobState";
        public static final String CURRENT_JOB_COSTOFLIVING = "currentJobCostOfLiving";
        public static final String CURRENT_JOB_YEARLYSALARY = "currentJobYearlySalary";
        public static final String CURRENT_JOB_YEARLYBONUS = "currentJobYearlyBonus";
        public static final String CURRENT_JOB_RETIREMENTBENEFIT = "currentJobRetirementBenefit";
        public static final String CURRENT_JOB_RELOCATIONSTIPEND = "currentJobRelocationStipend";
        public static final String CURRENT_JOB_RSU = "currentJobRsu";
    }
    
    public static class OfferJobEntry implements BaseColumns {
        public static final String TABLE_NAME = "Job";
        public static final String JOB_TITLE = "jobTitle";
        public static final String JOB_COMPANYNAME = "jobCompanyName";
        public static final String JOB_LOCATION = "jobLocation";
        public static final String JOB_COSTOFLIVING = "jobCostOfLiving";
        public static final String JOB_YEARLYSALARY = "jobYearlySalary";
        public static final String JOB_YEARLYBONUS = "jobYearlyBonus";
        public static final String JOB_RETIREMENTBENEFIT = "jobRetirementBenefit";
        public static final String JOB_RELOCATIONSTIPEND = "jobRelocationStipend";
        public static final String JOB_RSU = "jobRsu";
    }
    
    public static class ComparisonSetting implements BaseColumns {
        public static final String TABLE_NAME = "ComparisonSetting";
        public static final String COMPARISON_SALARY = "weightYearlySalary";
        public static final String COMPARISON_BONUS = "weightYearlyBonus";
        public static final String COMPARISON_RETIREMENTBENEFITS = "weightRetirementBenefits";
        public static final String COMPARISON_RELOCATIONSTIPEND = "weightRelocationStipend";
        public static final String COMPARISON_STOCKUNIT= "weightRestrictedStockUnit";
    }
}
