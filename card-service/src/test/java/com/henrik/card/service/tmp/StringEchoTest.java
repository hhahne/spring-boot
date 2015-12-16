package com.henrik.card.service.tmp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * Created by henrikhahne on 15/12/15.
 */
public class StringEchoTest {

    StringEcho echo;

    @Before
    public void setUp() {
        echo = new StringEcho();
    }

    @Test
    public void testEchoNull() {
        assertNull(echo.doEcho(null));
    }
}
