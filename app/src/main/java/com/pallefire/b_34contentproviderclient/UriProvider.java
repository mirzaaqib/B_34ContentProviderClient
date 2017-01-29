package com.pallefire.b_34contentproviderclient;

import android.net.Uri;

/**
 * Created by Mirzaaqibbeg on 29-01-2017.
 */
// the purpose of this file to declare column name & URI's(uniform resource identifier) for your table
public class UriProvider {
   //a.here first declare the column name,& this file should be share with other Application
    //these are the column name for the first table
    public static final String _ID="_id"; //integer data type
    public static final String NAME="sname";  //string data type
    public static final String SUB="ssub";   //string data type

    // prepare URI for student information table, with authority,& table name which specify the application who's is going to take the data

    public static final Uri STUDENT_URI=Uri.parse("content://com.techpalle.b34/student");
}
