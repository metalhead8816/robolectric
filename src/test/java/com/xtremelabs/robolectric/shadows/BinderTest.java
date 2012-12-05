package com.xtremelabs.robolectric.shadows;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.os.Binder;

import com.xtremelabs.robolectric.WithTestDefaultsRunner;

@RunWith(WithTestDefaultsRunner.class)
public class BinderTest {

    @Test
    public void testSetCallingPid() {
        ShadowBinder.setCallingPid(47);

        assertThat(Binder.getCallingPid(), equalTo(47));
    }

    @Test
    public void testCallingProcessIsJvmProcessId() {
        int pid = Binder.getCallingPid();

        assertThat(pid, equalTo(android.os.Process.myPid()));
    }
}
