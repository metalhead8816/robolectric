package com.xtremelabs.robolectric.shadows;

import android.content.res.Resources;
import android.content.res.TypedArray;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"UnusedDeclaration"})
@Implements(TypedArray.class)
public class ShadowTypedArray {
    private List<Object> values = new ArrayList<Object>();

    @Implementation
    public Resources getResources() {
        return Robolectric.application.getResources();
    }

    @Implementation
    public boolean getBoolean(int index, boolean defValue) {
        Object value = values.get(index);
        return (value instanceof Boolean) ? (Boolean) value : defValue;
    }

    @Implementation
    public float getFloat(int index, float defValue) {
        Object value = values.get(index);
        return (value instanceof Float) ? (Float) value : defValue;
    }

    @Implementation
    public int getInt(int index, int defValue) {
        return getInteger(index, defValue);
    }

    @Implementation
    public int getInteger(int index, int defValue) {
        Object value = values.get(index);
        return (value instanceof Integer) ? (Integer) value : defValue;
    }

    @Implementation
    public float getDimension(int index, float defValue) {
        return getFloat(index, defValue);
    }

    @Implementation
    public int getDimensionPixelOffset(int index, int defValue) {
        return getInteger(index, defValue);
    }

    @Implementation
    public int getDimensionPixelSize(int index, int defValue) {
        return getInteger(index, defValue);
    }

    @Implementation
    public int getLayoutDimension(int index, int defValue) {
        return getInteger(index, defValue);
    }

    @Implementation
    public int getResourceId(int index, int defValue) {
        return getInteger(index, defValue);
    }

    public void add(Object attributeValue) {
        values.add(attributeValue);
    }

    @Implementation
    public java.lang.String getString(int index) {
        return (java.lang.String) values.get(index);
    }
}
