package com.xtremelabs.robolectric.shadows;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@Implements(TypedArray.class)
public class ShadowTypedArray {
    private int[] attrs;
    private AttributeSet attributes;
    
    @Implementation
    public Resources getResources() {
        return Robolectric.application.getResources();
    }

    @Implementation
    public boolean getBoolean(int index, boolean defValue) {
        if (attributes == null) {
            return defValue;
        }
        return attributes.getAttributeBooleanValue(attrs[index], defValue);
    }

    @Implementation
    public float getFloat(int index, float defValue) {
        if (attributes == null) {
            return defValue;
        }
        return attributes.getAttributeFloatValue(attrs[index], defValue);
    }

    @Implementation
    public int getInt(int index, int defValue) {
        return getInteger(index, defValue);
    }

    @Implementation
    public int getInteger(int index, int defValue) {
        if (attributes == null) {
            return defValue;
        }
        return attributes.getAttributeIntValue(attrs[index], defValue);
    }

    @Implementation
    public java.lang.String getString(int index) {
        if (attributes == null) {
            return null;
        }
        return attributes.getAttributeValue(attrs[index]);
    }
    
    public void setAttributes(AttributeSet attributes, int[] attrs) {
        this.attributes = attributes;
        this.attrs = attrs;
    }
}
