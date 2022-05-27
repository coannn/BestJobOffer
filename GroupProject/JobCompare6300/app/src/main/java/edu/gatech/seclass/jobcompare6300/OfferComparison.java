package edu.gatech.seclass.jobcompare6300;


public class OfferComparison {
    int salarySetting;
    int bonusSetting;
    int retireSetting;
    int relocateSetting;
    int stockSetting;

    public Double computeJobScoreRank(Job currentJob, FeedReaderDbHelper dbHelper){

        String jobID;
        Double adjustedSalary;
        Double adjustedBonus;
        int retireBenefits;
        Double relocateStipend;
        Double restrictedStock;
        ComparisonSettings currentSetting;

        currentSetting = dbHelper.getDataComparisonSettings();
        System.out.println("comparison numbers checked-------------------------");
        System.out.println(currentSetting.getWeightYearlySalary());
        System.out.println(currentSetting.getWeightYearlyBonus());
        System.out.println(currentSetting.getWeightRelocationStipend());
        System.out.println(currentSetting.getWeightRestrictedStockUnit());
        System.out.println(currentSetting.getWeightRetirementBenefits());
        System.out.println("--------------end-------------------------");

        salarySetting = currentSetting.getWeightYearlySalary();
        bonusSetting = currentSetting.getWeightYearlyBonus();
        retireSetting = currentSetting.getWeightRetirementBenefits();
        relocateSetting = currentSetting.getWeightRelocationStipend();
        stockSetting = currentSetting.getWeightRestrictedStockUnit();

        jobID = currentJob.getTitle() + currentJob.getCompany(); /*title+name*/
        adjustedSalary = currentJob.getAdjustedYearlySalary();
        adjustedBonus = currentJob.getAdjustedYearlyBonus();
        retireBenefits = currentJob.getRetirementBenefit();
        relocateStipend = currentJob.getRelocationStipend();
        restrictedStock = currentJob.getRsu();


        int sumSetting = salarySetting + bonusSetting + retireSetting + relocateSetting + stockSetting;
        Double salaryRatio = (double)salarySetting / (double)sumSetting;
        Double bonusRatio = (double)bonusSetting / (double)sumSetting;
        Double retireRatio = (double)retireSetting / (double)sumSetting;
        Double relocateRatio = (double)relocateSetting / (double)sumSetting;
        Double stockRatio = (double)stockSetting / (double)sumSetting;


        Double rankScore = salaryRatio * adjustedSalary + bonusRatio * adjustedBonus + retireRatio *
                retireBenefits * adjustedSalary /100.0 + relocateRatio * relocateStipend +
                stockRatio * restrictedStock / 4.0;
        System.out.println(adjustedSalary);
        System.out.println(adjustedBonus);
        System.out.println(relocateStipend);
        System.out.println(restrictedStock);
        System.out.println(currentJob.getCompany());
        return rankScore;


    }
}
