package com.app.notesculture.view.utills;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class AppUtility {
    public static CoordinatorLayout coordinatorLayout;

    public static void showSimpleSnackbar(Activity activity, String msg) {
        Snackbar.make(activity.findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show();


    }
    public static void hideSoftkeyboard(Activity activity,EditText edtext){
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edtext.getWindowToken(), 0);
    }

    public static boolean  isValid(String phone_no , String password,EditText edPhone,EditText edPass){

        if(TextUtils.isEmpty(phone_no)){
            edPhone.setError("Please enter Phone No!");
             return false;
        }
        if(phone_no.length()<6){
            edPhone.setError("Phone No length is least  character!");
            return  false;
        }
        if(TextUtils.isEmpty(password)){
            edPass.setError("Please enter Password!");
            return false;
        }
        if(password.length()<10 && password.length()==20){
            edPass.setError("Minimum length of password is 10 character and maximum is 20 chracter!");
            return false;
        }


        return true;
    }

    }
