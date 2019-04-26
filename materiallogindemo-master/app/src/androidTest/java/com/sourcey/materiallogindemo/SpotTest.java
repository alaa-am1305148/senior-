package com.sourcey.materiallogindemo;

import junit.framework.TestCase;

/**
 * Created by Alaa on 4/19/2019.
 */
public class SpotTest extends TestCase {
    public void testGetZoneName() throws Exception {
    }

    public void testGetStatus() throws Exception {
    }

    public void testGetSpotNo() throws Exception {
        Spot spot = new Spot("CAAS", "available", 1);
        int expected = spot.getSpotNo();
        int actual = 1;
        assertEquals(expected,actual);
    }

}