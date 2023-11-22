package com.example.StudentReg;


import java.util.regex.Pattern;

public enum RegularExpressions {

        FIRST_NAME( "^(?:[A-Za-z]+\\s?)+$"),
        LAST_NAME( "^(?:[A-Za-z]+\\s?)+$"),
        ID ("^\\d"),
        AGE ("^\\d{1,3}$");


        private final String regex;

        RegularExpressions(String regex) {
            this.regex = regex;
        }

        public Pattern getPattern() {
            return Pattern.compile(this.regex);
        }
    }

