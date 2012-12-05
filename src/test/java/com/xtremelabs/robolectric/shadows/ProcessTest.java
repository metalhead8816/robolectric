package com.xtremelabs.robolectric.shadows;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.WithTestDefaultsRunner;

@RunWith(WithTestDefaultsRunner.class)
public class ProcessTest {

    @Test
    public void testSetPid() {
        ShadowProcess.setPid(47);

        assertThat(android.os.Process.myPid(), equalTo(47));
    }
}
