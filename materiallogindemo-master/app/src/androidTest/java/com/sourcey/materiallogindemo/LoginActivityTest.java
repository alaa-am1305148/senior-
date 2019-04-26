package com.sourcey.materiallogindemo;

import junit.framework.TestCase;

/**
 * Created by Alaa on 4/19/2019.
 */
public class LoginActivityTest extends TestCase {
    public void testValidate() throws Exception {

       boolean actual =  LoginActivity.validate("alaa123@gmail.com", "alaa123");
       boolean expected = true;
       assertEquals(expected,actual);

    }

}