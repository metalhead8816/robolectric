package com.xtremelabs.robolectric.shadows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

import java.util.ArrayList;
import java.util.List;

@Implements(Parcel.class)
@SuppressWarnings("unchecked")
public class ShadowParcel {
    private final ArrayList parcelData = new ArrayList();
    private int index = 0;

    @Implementation
    public static Parcel obtain() {
        return Robolectric.newInstanceOf(Parcel.class);
    }

    @Implementation
    public void writeString(String str) {
        parcelData.add(str);
    }

    @Implementation
    public void writeInt(int i) {
        parcelData.add(i);
    }

    @Implementation
    public void writeLong(long i) {
        parcelData.add(i);
    }

    @Implementation
    public void writeFloat(float f) {
        parcelData.add(f);
    }

    @Implementation
    public void writeDouble(double f) {
        parcelData.add(f);
    }

    public void writeBoolean(boolean b) {
        parcelData.add(b);
    }

    public void writeChar(char b) {
        parcelData.add(b);
    }

    @Implementation
    @SuppressWarnings("unchecked")
    public void writeByte( byte b ) {
    	parcelData.add( b );
    }

    @Implementation
    public String readString() {
        return index < parcelData.size() ? (String) parcelData.get(index++) : null;
    }

    @Implementation
    public int readInt() {
        return index < parcelData.size() ? (Integer) parcelData.get(index++) : 0;
    }

    @Implementation
    public float readFloat() {
        return index < parcelData.size() ? (Float) parcelData.get(index++) : 0;
    }

    @Implementation
    public double readDouble() {
        return index < parcelData.size() ? (Double) parcelData.get(index++) : 0;
    }

    @Implementation
    public byte readByte() {
        return index < parcelData.size() ? (Byte) parcelData.get(index++) : 0;
    }

    public boolean readBoolean() {
        return index < parcelData.size() ? (Boolean) parcelData.get(index++) : false;
    }

    public char readChar() {
        return index < parcelData.size() ? (Character) parcelData.get(index++) : 0;
    }

    @Implementation
    public long readLong() {
        return index < parcelData.size() ? (Long) parcelData.get(index++) : 0;
    }

    @Implementation
    public Bundle readBundle() {
        return index < parcelData.size() ? (Bundle) parcelData.get(index++) : null;
    }

    @Implementation
    public Bundle readBundle(ClassLoader loader) {
        return readBundle();
    }

    @Implementation
    public void writeBundle(Bundle bundle) {
        parcelData.add(bundle);
    }

    @Implementation
    public void writeParcelable(Parcelable p, int flags) {
        parcelData.add(p);
    }

    @Implementation
    public Parcelable readParcelable(ClassLoader cl) {
        return index < parcelData.size() ? (Parcelable) parcelData.get(index++) : null;
    }

    @Implementation
    public void readBooleanArray(boolean[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readBoolean();
        }
    }

    @Implementation
    public void writeBooleanArray(boolean[] val) {
        writeInt(val.length);
        for (boolean b : val) writeBoolean(b);
    }

    @Implementation
    public boolean[] createBooleanArray() {
        int n = readInt();
        boolean[] val = new boolean[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readBoolean();
        }
        return val;
    }

    @Implementation
    public void readCharArray(char[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readChar();
        }
    }

    @Implementation
    public void writeCharArray(char[] val) {
        writeInt(val.length);
        for (char b : val) writeChar(b);
    }

    @Implementation
    public char[] createCharArray() {
        int n = readInt();
        char[] val = new char[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readChar();
        }
        return val;
    }

    @Implementation
    public void readFloatArray(float[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readFloat();
        }
    }

    @Implementation
    public void writeFloatArray(float[] val) {
        writeInt(val.length);
        for (float f : val) writeFloat(f);
    }

    @Implementation
    public float[] createFloatArray() {
        int n = readInt();
        float[] val = new float[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readFloat();
        }
        return val;
    }

    @Implementation
    public void writeDoubleArray(double[] val) {
        writeInt(val.length);
        for (double f : val) writeDouble(f);
    }

    @Implementation
    public void readDoubleArray(double[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readDouble();
        }
    }

    @Implementation
    public double[] createDoubleArray() {
        int n = readInt();
        double[] val = new double[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readDouble();
        }
        return val;
    }

    @Implementation
    public void writeIntArray(int[] val) {
        writeInt(val.length);
        for (int f : val) writeInt(f);
    }

    @Implementation
    public void readIntArray(int[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readInt();
        }
    }

    @Implementation
    public int[] createIntArray() {
        int n = readInt();
        int[] val = new int[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readInt();
        }
        return val;
    }

    @Implementation
    public void writeByteArray(byte[] val) {
        writeInt(val.length);
        for (byte f : val) writeByte(f);
    }

    @Implementation
    public void readByteArray(byte[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readByte();
        }
    }

    @Implementation
    public byte[] createByteArray() {
        int n = readInt();
        byte[] val = new byte[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readByte();
        }
        return val;
    }

    @Implementation
    public void writeLongArray(long[] val) {
        writeInt(val.length);
        for (long f : val) writeLong(f);
    }

    @Implementation
    public void readLongArray(long[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readLong();
        }
    }

    @Implementation
    public long[] createLongArray() {
        int n = readInt();
        long[] val = new long[n];
        for (int i = 0; i < val.length; i++) {
            val[i] = readLong();
        }
        return val;
    }

    @Implementation
    public void writeStringArray(String[] val) {
        writeInt(val.length);
        for (String f : val) writeString(f);
    }

    @Implementation
    public String[] createStringArray() {
        String[] array = null;

        int length = readInt();
        if (length >= 0) {
            array = new String[length];
            for (int i = 0; i < length; i++) {
                array[i] = readString();
            }
        }
        return array;
    }

    @Implementation
    public void readStringArray(String[] val) {
        int n = readInt();
        if (val.length != n) throw new RuntimeException("bad array lengths");
        for (int i = 0; i < val.length; i++) {
            val[i] = readString();
        }
    }

    @Implementation
    public void writeStringList(List<String> val) {
        int N = val.size();
        writeInt(N);
        for (int i = 0; i < N; i++) {
            writeString(val.get(i));
        }
    }

    @Implementation
    public ArrayList<String> createStringArrayList() {
        int N = readInt();
        if (N < 0) {
            return null;
        }
        ArrayList<String> l = new ArrayList<String>(N);
        while (N > 0) {
            l.add(readString());
            N--;
        }
        return l;
    }

    @Implementation
    public void readStringList(List<String> list) {
        int M = list.size();
        int N = readInt();
        int i = 0;
        for (; i < M && i < N; i++) {
            list.set(i, readString());
        }
        for (; i < N; i++) {
            list.add(readString());
        }
        for (; i < M; i++) {
            list.remove(N);
        }
    }

    public int getIndex() {
        return index;
    }

    public List getParcelData() {
        return parcelData;
    }
}
