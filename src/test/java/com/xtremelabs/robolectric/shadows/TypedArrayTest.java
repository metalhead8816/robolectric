package com.xtremelabs.robolectric.shadows;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.WithTestDefaultsRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    public void testBooleanDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(1);

        assertThat(typedArray.getBoolean(0, true), equalTo(true));
        assertThat(typedArray.getBoolean(0, false), equalTo(false));
    }

    @Test
    public void testIntDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getInt(0, 15), equalTo(15));
        assertThat(typedArray.getInteger(0, 24), equalTo(24));
    }

    @Test
    public void testFloatDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getFloat(0, 0.5f), equalTo(0.5f));
    }

    @Test
    public void testDimensionDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getDimension(0, 0.5f), equalTo(0.5f));
    }

    @Test
    public void testDimensionPixelOffsetDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getDimensionPixelOffset(0, 2), equalTo(2));
    }

    @Test
    public void testDimensionPixelSizeDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getDimensionPixelSize(0, 2), equalTo(2));
    }

    @Test
    public void testLayoutDimensionDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getLayoutDimension(0, 2), equalTo(2));
    }

    @Test
    public void testResourceIdDefaultValue() {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getResourceId(0, 2), equalTo(2));
    }

    @Test
    public void shouldGetAndSetStringAttributes() throws Exception {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add("expected value");

        assertThat(typedArray.getString(0), equalTo("expected value"));
    }

    @Test
    public void shouldGetAndSetIntegerAttributes() throws Exception {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(25);

        assertThat(typedArray.getInt(0, -1), equalTo(25));
    }

    @Test
    public void shouldGetAndSetBooleanAttributes() throws Exception {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(true);

        assertThat(typedArray.getBoolean(0, false), equalTo(true));
    }

    @Test
    public void shouldGetAndSetFloatAttributes() throws Exception {
        ShadowTypedArray shadowArray = Robolectric.shadowOf(typedArray);
        shadowArray.add(1.5f);

        assertThat(typedArray.getFloat(0, 0.0f), equalTo(1.5f));
    }
}
