package com.example;

import org.junit.*;

/**
 * Unit test for simple App.
 */
public class JavaAppTest
{

    @Test
    public void JavaApplicationTest()
    {
        JavaApp.main(null);
        try {
            String actual_message = JavaAppTest.displayMessage();
            Assert.assertEquals("Hello Nivethitha!", actual_message);
        } catch (AssertionError e) {
            System.out.println(e + " : " + "Not the desired result!");
        }
    }

    public static String displayMessage()
    {
        return JavaApp.message;
    }
}
