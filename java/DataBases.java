package com.example.corona19app;

import android.provider.BaseColumns;

public final class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String USERID = "userid";
        public static final String Birthday = "birthday";
        public static final String NAME ="name";
        public static final String AGE = "age";
        public static final String PHONE ="phone";
        public static final String PASSWORD ="password";
        public static final String _TABLENAME0 = "usertable";
        public static final String _CREATE0 = "Create table if not exists"+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +USERID+" text not null , "
                +Birthday+" integer not null , "
                +AGE+" integer not null , "
                +NAME+" text not null , "
                +PASSWORD + "integer not null"
                +PHONE+" text not null );";

    }
}
