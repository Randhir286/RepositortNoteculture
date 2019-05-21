package com.app.notesculture.view.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceHelper {
    private  SharedPreferences pref;
    private   SharedPreferences.Editor editor;
    private  Context _context;
    // Shared preferences file name
    private  final String PREFS_NAME = "notes_culture";
    private  final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    /*LoginData*/
    private  final String USER_ID="userId";
    private  final String DEVICE_ID="deviceId";
    private   final String OTP="otp";
    private  final String PHONENO="phoneNo";
    private  final String PASSWORD="password";
    private  final String LOG_IN="log_in";

    /**
     * Constructor takes an android.content.Context argument
     */

    public SharedPrefrenceHelper(Context ctx) {
        if (pref == null) {
            pref = ctx.getSharedPreferences(PREFS_NAME,
                    Context.MODE_PRIVATE);
        }
        /*
         * Get a SharedPreferences editor instance.
         * SharedPreferences ensures that updates are atomic
         * and non-concurrent
         */
        editor = pref.edit();
    }

    public   void setLoginData(String userId,String deviceId,String otp){
        editor.putString(USER_ID,userId);
        editor.putString(DEVICE_ID,deviceId);
        editor.putString(OTP,otp);
        editor.commit();
    }
    public void setSignupInfo(String phoneNumber,String password){
        editor.putString(PHONENO,phoneNumber);
        editor.putString(PASSWORD,password);
        editor.commit();
    }
    public  String getPhoneNumber(){
       return pref.getString(PHONENO,"");
    }
    public  String getPassword(){
        return pref.getString(PASSWORD,"");
    }
    public void setUserId(String userId){
        editor.putString(USER_ID,userId);
        editor.commit();
    }
    public  String getUserId(){
        return pref.getString(USER_ID,"");
    }

    public  void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public Boolean isLogedIn() {
        return pref.getBoolean(LOG_IN, true);
    }

    public void setLogedIn( Boolean value) {

        editor.putBoolean(LOG_IN,value);
        editor.commit();
    }
}
