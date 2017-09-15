package com.exams.rectangle.config;

/**
 * Created by rodicad on 15/09/2017.
 */
public class StartupParameters {
    private final String number_rectangles;

    public StartupParameters() {
        this.number_rectangles =   System.getProperty( "rectangles" );
    }

    public String getNumber_rectangles() {
        return this.number_rectangles;
    }
}
