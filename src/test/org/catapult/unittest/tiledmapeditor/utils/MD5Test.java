package org.catapult.unittest.tiledmapeditor.utils;

import java.security.NoSuchAlgorithmException;

import org.catapult.app.tiledmapeditor.utils.MD5;
import org.junit.Assert;
import org.junit.Test;

public class MD5Test {

	@Test
    public void testMD5Generating() throws NoSuchAlgorithmException {
        String txt = "Hello World";
        Assert.assertEquals("b10a8db164e0754105b7a99be72e3fe5", MD5.getMD5Hex(txt));
    }
}