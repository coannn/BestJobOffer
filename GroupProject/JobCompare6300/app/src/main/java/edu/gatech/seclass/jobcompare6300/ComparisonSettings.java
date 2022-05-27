package edu.gatech.seclass.jobcompare6300;

import lombok.Data;

@Data
public class ComparisonSettings {
    Integer weightYearlySalary = 1;
    Integer weightYearlyBonus = 1;
    Integer weightRetirementBenefits = 1;
    Integer weightRelocationStipend = 1;
    Integer weightRestrictedStockUnit = 1;

    public void setComparison(Integer weightYearlySalary, Integer weightYearlyBonus, Integer weightRetirementBenefits, Integer weightRelocationStipend,Integer weightRestrictedStockUnit) {

        this.weightYearlySalary = weightYearlySalary;
        this.weightYearlyBonus = weightYearlyBonus;
        this.weightRetirementBenefits = weightRetirementBenefits;
        this.weightRelocationStipend = weightRelocationStipend;
        this.weightRestrictedStockUnit = weightRestrictedStockUnit;

    }
    public Integer getWeightYearlySalary(){
        return weightYearlySalary;
    }

    public Integer getWeightYearlyBonus(){
        return weightYearlyBonus;
    }

    public Integer getWeightRetirementBenefits(){
        return weightRetirementBenefits;
    }

    public Integer getWeightRelocationStipend(){
        return weightRelocationStipend;
    }

    public Integer getWeightRestrictedStockUnit(){
        return weightRestrictedStockUnit;
    }

}
