package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class FeedReaderDbHelper extends SQLiteOpenHelper {

    public static FeedReaderDbHelper helper ;
    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "JobCompare.db";
    SQLiteDatabase db;

    private static final String CURRENT_JOB_SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.CurrentJobEntry.TABLE_NAME + " (" +
                    FeedReaderContract.CurrentJobEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_TITLE + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COMPANYNAME + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_LOCATION + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_CITY + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_STATE + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COSTOFLIVING + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYSALARY + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYBONUS + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RETIREMENTBENEFIT + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RELOCATIONSTIPEND + " TEXT," +
                    FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RSU + " TEXT)" ;
    
    private static final String OFFER_JOB_SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.OfferJobEntry.TABLE_NAME + " (" +
                    FeedReaderContract.OfferJobEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.OfferJobEntry.JOB_TITLE + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_COMPANYNAME + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_LOCATION + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_COSTOFLIVING + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_YEARLYSALARY + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_YEARLYBONUS + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_RETIREMENTBENEFIT + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_RELOCATIONSTIPEND + " TEXT," +
                    FeedReaderContract.OfferJobEntry.JOB_RSU + " TEXT)" ;

    
    private static final String COMPARISON_SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedReaderContract.ComparisonSetting.TABLE_NAME + " (" +
                    FeedReaderContract.ComparisonSetting._ID + " INTEGER PRIMARY KEY," +
                    FeedReaderContract.ComparisonSetting.COMPARISON_SALARY + " TEXT," +
                    FeedReaderContract.ComparisonSetting.COMPARISON_BONUS + " TEXT," +
                    FeedReaderContract.ComparisonSetting.COMPARISON_RETIREMENTBENEFITS + " TEXT," +
                    FeedReaderContract.ComparisonSetting.COMPARISON_RELOCATIONSTIPEND + " TEXT," +
                    FeedReaderContract.ComparisonSetting.COMPARISON_STOCKUNIT + " TEXT)" ;

    private static final String CURRENT_JOB_SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.CurrentJobEntry.TABLE_NAME;
    
    private static final String OFFER_JOB_SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.OfferJobEntry.TABLE_NAME;

    private static final String COMPARISON_SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.ComparisonSetting.TABLE_NAME;

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized FeedReaderDbHelper getInstance(Context ctx) {
        if (helper == null) {
            helper = new FeedReaderDbHelper(ctx.getApplicationContext());
        }
        return helper;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CURRENT_JOB_SQL_CREATE_ENTRIES);
        db.execSQL(OFFER_JOB_SQL_CREATE_ENTRIES);
        db.execSQL(COMPARISON_SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(CURRENT_JOB_SQL_DELETE_ENTRIES);
        db.execSQL(OFFER_JOB_SQL_DELETE_ENTRIES);
        db.execSQL(COMPARISON_SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    @Override
    public synchronized void close () {
        if (db != null) {
            db.close();
            super.close();
        }
    }

    public Job getCurrentJob(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FeedReaderContract.CurrentJobEntry.TABLE_NAME  + " " , null);
        Job job = new Job();
        while(cursor.moveToNext()) {
            job.id = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry._ID));
            job.title = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_TITLE));
            job.company = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COMPANYNAME));
            job.costOfLiving = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COSTOFLIVING));
            job.location = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_LOCATION));
            job.city = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_CITY));
            job.state = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_STATE));
            job.yearlySalary = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYSALARY));
            job.yearlyBonus = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYBONUS));
            job.retirementBenefit = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RETIREMENTBENEFIT));
            job.relocationStipend = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RELOCATIONSTIPEND));
            job.rsu = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RSU));
        }
        return job;
    }

    public boolean insertCurrentJob(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_TITLE, job.title);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COMPANYNAME, job.company);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_LOCATION, job.location);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_CITY, job.city);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_STATE, job.state);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COSTOFLIVING, job.costOfLiving);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYSALARY, job.yearlySalary);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYBONUS, job.yearlyBonus);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RETIREMENTBENEFIT, job.retirementBenefit);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RELOCATIONSTIPEND, job.relocationStipend);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RSU, job.rsu);

        db.insert(FeedReaderContract.CurrentJobEntry.TABLE_NAME, null, values);
        return true;
    }

    public boolean updateCurrentJob(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.CurrentJobEntry._ID, job.id);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_TITLE, job.title);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COMPANYNAME, job.company);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_LOCATION, job.location);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_CITY, job.city);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_STATE, job.state);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COSTOFLIVING, job.costOfLiving);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYSALARY, job.yearlySalary);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYBONUS, job.yearlyBonus);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RETIREMENTBENEFIT, job.retirementBenefit);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RELOCATIONSTIPEND, job.relocationStipend);
        values.put(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RSU, job.rsu);

        db.update(FeedReaderContract.CurrentJobEntry.TABLE_NAME, values, "_id = ?", new String[] { Integer.toString(job.id) });
        return true;
    }

    public Job getJobOffer(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FeedReaderContract.ComparisonSetting.TABLE_NAME  + " " , null);
        Job job = new Job();
        while(cursor.moveToNext()) {
            job.id = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry._ID));
            job.title = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_TITLE));
            job.company = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_COMPANYNAME));
            job.costOfLiving = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_COSTOFLIVING));
            job.location = cursor.getString(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_LOCATION));
            job.yearlySalary = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_YEARLYSALARY));
            job.yearlyBonus = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_YEARLYBONUS));
            job.retirementBenefit = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RETIREMENTBENEFIT));
            job.relocationStipend = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RELOCATIONSTIPEND));
            job.rsu = cursor.getDouble(cursor.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RSU));
        }
        cursor.close();
        return job;
    }

    public boolean insertJobOffer(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.OfferJobEntry.JOB_TITLE, job.title);
        values.put(FeedReaderContract.OfferJobEntry.JOB_COMPANYNAME, job.company);
        values.put(FeedReaderContract.OfferJobEntry.JOB_LOCATION, job.location);
        values.put(FeedReaderContract.OfferJobEntry.JOB_COSTOFLIVING, job.costOfLiving);
        values.put(FeedReaderContract.OfferJobEntry.JOB_YEARLYSALARY, job.yearlySalary);
        values.put(FeedReaderContract.OfferJobEntry.JOB_YEARLYBONUS, job.yearlyBonus);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RETIREMENTBENEFIT, job.retirementBenefit);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RELOCATIONSTIPEND, job.relocationStipend);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RSU, job.rsu);

        db.insert(FeedReaderContract.OfferJobEntry.TABLE_NAME, null, values);
        return true;
    }

    public boolean updateJobOffer(Job job){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.OfferJobEntry._ID, job.id);
        values.put(FeedReaderContract.OfferJobEntry.JOB_TITLE, job.title);
        values.put(FeedReaderContract.OfferJobEntry.JOB_COMPANYNAME, job.company);
        values.put(FeedReaderContract.OfferJobEntry.JOB_LOCATION, job.location);
        values.put(FeedReaderContract.OfferJobEntry.JOB_COSTOFLIVING, job.costOfLiving);
        values.put(FeedReaderContract.OfferJobEntry.JOB_YEARLYSALARY, job.yearlySalary);
        values.put(FeedReaderContract.OfferJobEntry.JOB_YEARLYBONUS, job.yearlyBonus);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RETIREMENTBENEFIT, job.retirementBenefit);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RELOCATIONSTIPEND, job.relocationStipend);
        values.put(FeedReaderContract.OfferJobEntry.JOB_RSU, job.rsu);

        db.update(FeedReaderContract.OfferJobEntry.TABLE_NAME, values, "_id = ?", new String[] { Integer.toString(job.id) });
        return true;
    }

    public ArrayList<Job> getAllJobOffer() {
        SQLiteDatabase db = getReadableDatabase(); //SQLiteDatabase db = dbHelper.getReadableDatabase();
        ArrayList<Job> jobList = new ArrayList<>();
        Cursor cursor1 =  db.rawQuery( "SELECT * FROM " + FeedReaderContract.CurrentJobEntry.TABLE_NAME + " " , null);
        Cursor cursor2 =  db.rawQuery( "SELECT * FROM " + FeedReaderContract.OfferJobEntry.TABLE_NAME + " " , null);
        try {
            while (cursor1.moveToNext()) {
                Job job1 = new Job();
                int id = cursor1.getInt(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry._ID));
                String title = cursor1.getString(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_TITLE));
                String company = cursor1.getString(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COMPANYNAME));
                int costOfLiving = cursor1.getInt(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_COSTOFLIVING));
                String location = cursor1.getString(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_LOCATION));
                double yearlySalary = cursor1.getDouble(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYSALARY));
                double yearlyBonus = cursor1.getDouble(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_YEARLYBONUS));
                int retirementBenefit = cursor1.getInt(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RETIREMENTBENEFIT));
                double relocationStipend = cursor1.getDouble(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RELOCATIONSTIPEND));
                double rsu = cursor1.getDouble(cursor1.getColumnIndexOrThrow(FeedReaderContract.CurrentJobEntry.CURRENT_JOB_RSU));
                job1.setJob(id, title, company, costOfLiving, location, yearlySalary, yearlyBonus, retirementBenefit, relocationStipend, rsu);
                jobList.add(job1);
            }
        } finally {
            if (cursor1 != null && !cursor1.isClosed())
                cursor1.close();
        }

        try {
            while (cursor2.moveToNext()) {
                Job job2 = new Job();
                int id = cursor2.getInt(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry._ID));
                String title = cursor2.getString(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_TITLE));
                String company = cursor2.getString(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_COMPANYNAME));
                int costOfLiving = cursor2.getInt(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_COSTOFLIVING));
                String location = cursor2.getString(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_LOCATION));
                double yearlySalary = cursor2.getDouble(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_YEARLYSALARY));
                double yearlyBonus = cursor2.getDouble(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_YEARLYBONUS));
                int retirementBenefit = cursor2.getInt(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RETIREMENTBENEFIT));
                double relocationStipend = cursor2.getDouble(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RELOCATIONSTIPEND));
                double rsu = cursor2.getDouble(cursor2.getColumnIndexOrThrow(FeedReaderContract.OfferJobEntry.JOB_RSU));
                job2.setJob(id, title, company, costOfLiving, location, yearlySalary, yearlyBonus, retirementBenefit, relocationStipend, rsu);
                jobList.add(job2);
            }
        } finally {
            if (cursor1 != null && !cursor1.isClosed())
                cursor1.close();
        }
        db.close();
        return jobList;
    }

    public Integer deleteJobOffer(Integer id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(FeedReaderContract.OfferJobEntry.TABLE_NAME , " _id = ? ", new String[] { Integer.toString(id) });
    }

    public void insertDataComparison(ComparisonSettings settings){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_SALARY, settings.weightYearlySalary);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_BONUS, settings.weightYearlyBonus);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_RETIREMENTBENEFITS, settings.weightRetirementBenefits);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_RELOCATIONSTIPEND, settings.weightRelocationStipend);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_STOCKUNIT, settings.weightRestrictedStockUnit);

        db.insert(FeedReaderContract.ComparisonSetting.TABLE_NAME, null, values);
    }

    public void updateDataComparison(ComparisonSettings settings){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_SALARY, settings.weightYearlySalary);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_BONUS, settings.weightYearlyBonus);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_RETIREMENTBENEFITS, settings.weightRetirementBenefits);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_RELOCATIONSTIPEND, settings.weightRelocationStipend);
        values.put(FeedReaderContract.ComparisonSetting.COMPARISON_STOCKUNIT, settings.weightRestrictedStockUnit);
        db.update(FeedReaderContract.ComparisonSetting.TABLE_NAME, values, "_id = ?", new String[] { Integer.toString(1) });
    }

    public ComparisonSettings getDataComparisonSettings(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + FeedReaderContract.ComparisonSetting.TABLE_NAME  + " " , null);
        ComparisonSettings compareSettings = new ComparisonSettings();
        try {
            while (cursor.moveToNext()) {
                int salary = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.ComparisonSetting.COMPARISON_SALARY));
                int bonus = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.ComparisonSetting.COMPARISON_BONUS));
                int retire = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.ComparisonSetting.COMPARISON_RETIREMENTBENEFITS));
                int relocate = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.ComparisonSetting.COMPARISON_RELOCATIONSTIPEND));
                int stock = cursor.getInt(cursor.getColumnIndexOrThrow(FeedReaderContract.ComparisonSetting.COMPARISON_STOCKUNIT));

                // Add dbData.
                compareSettings.setComparison(salary, bonus, retire, relocate, stock);
            }
        } finally{
            if (cursor != null && !cursor.isClosed())
                cursor.close();
        }

        db.close();
        return compareSettings;
    }

    public Integer deleteDataComparison(Integer id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(FeedReaderContract.ComparisonSetting.TABLE_NAME , " _id = ? ", new String[] { Integer.toString(1) });
    }

}

