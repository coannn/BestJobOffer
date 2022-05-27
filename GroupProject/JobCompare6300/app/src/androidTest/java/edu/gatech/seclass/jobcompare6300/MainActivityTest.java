package edu.gatech.seclass.jobcompare6300;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.assertion.ViewAssertions;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayingAtLeast;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import android.view.View;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static ViewAction handleConstraints(final ViewAction action, final Matcher<View> constraints)
    {
        return new ViewAction()
        {
            @Override
            public Matcher<View> getConstraints()
            {
                return constraints;
            }

            @Override
            public String getDescription()
            {
                return action.getDescription();
            }

            @Override
            public void perform(UiController uiController, View view)
            {
                action.perform(uiController, view);
            }
        };
    }




    @Rule
    public ActivityTestRule<MainActivity> tActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    /** Test 1**/
    // verify cancel button works inside enter/edit job details  test07
    @Test
    public void cancelWithoutSave(){
        onView(withId(R.id.enterorEditCurrentJobDetailsID)).perform(click());
        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("SWE"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Google"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("San Francisco"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("California"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("200000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("20"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("5000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("50000"));

        onView(withId(R.id.cancelJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(65)));
        onView(withId(R.id.enterorEditCurrentJobDetailsID)).perform(click());

    }
    /**Test 2**/
    // enter a full current job//. //TODO: Write test for partial current job details
    @Test
    public void enterAndSaveCurrentJob(){

        onView(withId(R.id.enterorEditCurrentJobDetailsID)).perform(click());
        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("SWE"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Google"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("San Francisco"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("California"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("200000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("20"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("5000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("50000"));

        onView(withId(R.id.saveCurrentJob)).perform(handleConstraints(click(), isDisplayingAtLeast(65)));

    }





    /**** Test 3 : edit company name and verify if edit was made */
    @Test
    public void editCurrentJob()
    {


        onView(withId(R.id.enterorEditCurrentJobDetailsID)).perform(click());
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Microsoft"));

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveCurrentJob)).perform(handleConstraints(click(), isDisplayingAtLeast(65)));
        onView(withId(R.id.enterorEditCurrentJobDetailsID)).perform(click());
        //onView((withId(R.id.editTextEnterCompany)).check(matches("company2"));

        onView(withId(R.id.editTextEnterCompany)).check(ViewAssertions.matches(withText("Microsoft")));

    }
//
    /** test 04**/
    @Test
    public void enterAndSaveJobOffer() {
        onView(withId(R.id.enterJobOfferID)).perform(click());
        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("Data Engineer"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Google"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("NYC"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("NY"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("175000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("50000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("30"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("5000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("50000"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));
    }

    /** test 05: checks if multiple offers can be saved **/
    @Test
    public void enterAndSaveMultipleJobOffer() {
        onView(withId(R.id.enterJobOfferID)).perform(click());
        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("SWE"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("IBM"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("NYC"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("NY"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("150000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("10"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("1000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("0"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));

        onView(withId(R.id.enterAnotherJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));

        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("DS"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Hulu"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("NYC"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("NY"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("160000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("70000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("20"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("50000"));

        Espresso.closeSoftKeyboard();
        onView(withId(R.id.saveJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));
    }
    /** test 06 - validate the enter offer button works*/
    @Test
    public void enterOffer() {
        onView(withId(R.id.enterJobOfferID)).perform(click());
        onView(withId(R.id.enterAnotherJobOfferID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));

    }


    /**test 07 - Validate adjust compare settings **/

    @Test
    public void adjustCompareSettings()
    {
        onView(withId(R.id.adjustComparisonSettingsID)).perform(click());
        onView(withId(R.id.salaryID)).perform(clearText(), replaceText("1"));
        onView(withId(R.id.bonusID)).perform(clearText(), replaceText("4"));
        onView(withId(R.id.retireID)).perform(clearText(), replaceText("1"));
        onView(withId(R.id.relocateID)).perform(clearText(), replaceText("3"));
        onView(withId(R.id.stockID)).perform(clearText(), replaceText("2"));
        onView(withId(R.id.saveComparisonID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));
        onView(withId(R.id.returnID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));

        onView(withId(R.id.adjustComparisonSettingsID)).perform(click());
        onView(withId(R.id.bonusID)).check(ViewAssertions.matches(withText("4")));

    }
    @Test
    public void returnMainMenu(){
        onView(withId(R.id.enterJobOfferID)).perform(click());
        onView(withId(R.id.editTextEnterTitle)).perform(clearText(), replaceText("Data Engineer"));
        onView(withId(R.id.editTextEnterCompany)).perform(clearText(), replaceText("Netflix"));
        onView(withId(R.id.editTextEnterCity)).perform(clearText(), replaceText("NYC"));
        onView(withId(R.id.editTextEnterState)).perform(clearText(), replaceText("NY"));
        onView(withId(R.id.editTextEnterCostOfLiving)).perform(clearText(), replaceText("150"));
        onView(withId(R.id.editTextEnterYearlySalary)).perform(clearText(), replaceText("150000"));
        onView(withId(R.id.editTextEnterYearlyBonus)).perform(clearText(), replaceText("10000"));
        onView(withId(R.id.editTextEnterRetirementBenefit)).perform(clearText(), replaceText("60"));
        onView(withId(R.id.editTextEnterRelocationStipend)).perform(clearText(), replaceText("1000"));
        onView(withId(R.id.editTextEnterRestrictedStockUnit)).perform(clearText(), replaceText("1000"));
        onView(withId(R.id.returnMainMenuID)).perform(handleConstraints(click(), isDisplayingAtLeast(40)));
    }
//
//
   /** test11 */ // verify if  compare job offer button works inside job offer detail
    @Test
    public void compareJobOfferButton(){ //check again
        onView(withId(R.id.enterJobOfferID)).perform(click());
        onView(withId(R.id.compareOfferID)).perform(click());
    }
    /** test 12 : verify if compare job offer from main menu works*/
    @Test
    public void compareJobOfferButtonFromMainMenu(){
        onView(withId(R.id.compareJobOfferID)).perform(click());
    }

    /** test13 */
    @Test
    public void returnMainMenuFromCompareOfferPage(){
        onView(withId(R.id.compareJobOfferID)).perform(click());
        onView(withId(R.id.rankReturnID)).perform(click());
    }

    /** test 14 : verify if correct ranking is given using excel sheet*/ //TODO: Make this completely a unit test
    @Test
    public void compareRankingAccuracy(){
        onView(withId(R.id.compareJobOfferID)).perform(click());
    }



}