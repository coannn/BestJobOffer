package edu.gatech.seclass.jobcompare6300;

//@Data
public class Job {
   public int id;
   public String title;
   public String company;
   public String city;
   public String state;
   public int costOfLiving;
   public String location;
   public double yearlySalary;
   public double yearlyBonus;
   public int retirementBenefit;
   public double relocationStipend;
   public double rsu;


   /*
      AYS = yearly salary adjusted for cost of living
      AYB = yearly bonus adjusted for cost of living
      RBP = retirement benefits percentage
      RS = relocation stipend
      RSUA = restricted stock unit award
    */
   public int getId(){
      return this.id;
   }
   public void setId(int id){
      this.id = id;
   }


   public void setJob(int id, String title, String company, int costOfLiving, String location,
                      double yearlySalary, double yearlyBonus, int retirementBenefit, double relocationStipend, double rsu){
      this.id = id;
      this.title = title;
      this.company = company;
      this.costOfLiving = costOfLiving;
      this.location = location;
      this.yearlySalary = yearlySalary;
      this.yearlyBonus = yearlyBonus;
      this.retirementBenefit = retirementBenefit;
      this.relocationStipend = relocationStipend;
      this.rsu = rsu;
   }


   public void setLocation(String location) {
      this.location = location;
   }
   public String getLocation(){
      return location;
   }

   public void setTitle(String title){
      this.title = title;
   }
   public String getTitle() {
      return this.title;
   }

   public void setCompany(String company){
      this.company = company;
   }
   public String getCompany() {
      return this.company;
   }

   public void setCity(String city){
      this.city = city;
   }
   public String getCity() {
      return this.city;
   }

   public void setState(String state){
      this.state = state;
   }
   public String getState() {
      return this.state;
   }

   public void setCostOfLiving(int costOfLiving){
      this.costOfLiving = costOfLiving;
   }
   public int getCostOfLiving() {
      return this.costOfLiving;
   }

   public void setYearlySalary(double yearlySalary){
      this.yearlySalary = yearlySalary;
   }
   public double getYearlySalary() {
      return this.yearlySalary;
   }

   public void setYearlyBonus(double yearlyBonus){
      this.yearlyBonus = yearlyBonus;
   }
   public double getYearlyBonus() {
      return this.yearlyBonus;
   }

   public void setRetirementBenefit(int retirementBenefit){
      this.retirementBenefit = retirementBenefit;
   }
   public int getRetirementBenefit() {
      return this.retirementBenefit;
   }

   public void setRelocationStipend(double relocationStipend){
      this.relocationStipend = relocationStipend;
   }
   public double getRelocationStipend() {
      return this.relocationStipend;
   }

   public void setRsu(double rsu){
      this.rsu = rsu;
   }
   public double getRsu() {
      return this.rsu;
   }

   public double getAdjustedYearlySalary(){
      return (yearlySalary * 100) / costOfLiving;
   }

   public double getAdjustedYearlyBonus() {
      return (yearlyBonus * 100) / costOfLiving;
   }
}
