package com.xtremelabs.robolectric.shadows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Activity;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.WithTestDefaultsRunner;

@RunWith(WithTestDefaultsRunner.class)
public class TypedArrayTest {
    private android.content.res.TypedArray typedArray;

    @Before
    public void setUp() throws Exception {
        typedArray = Robolectric.newInstanceOf(android.content.res.TypedArray.class);
    }

    @Test
    public void getResources() throws Exception {
        assertNotNull(new Activity().obtainStyledAttributes(null).getResources());
    }
    
    @Test
    public void testBooleanDefaultValueWithNoAttributeSet() {
        assertTrue(typedArray.getBoolean(0, true));
    }
    
    @Test
    public void testIntDefaultValueWithNoAttributeSet() {
        assertEquals(27, typedArray.getInt(0, 27));
    }
    
    @Test
    public void testIntegerDefaultValueWithNoAttributeSet() {
        assertEquals(27, typedArray.getInteger(0, 27));
    }
    
    @Test
    public void testFloatDefaultValueWithNoAttributeSet() {
        assertEquals(1.0f, typedArray.getFloat(0, 1.0f), 0.05);
    }
}
