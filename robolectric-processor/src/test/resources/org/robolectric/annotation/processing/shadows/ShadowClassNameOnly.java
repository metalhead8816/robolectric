package org.robolectric.annotation.processing.shadows;

import org.robolectric.annotation.Implements;
import org.robolectric.annotation.Resetter;

@Implements(className = "org.robolectric.annotation.processing.objects.AnyObject")
public class ShadowClassNameOnly {
  public static int resetCount = 0;
  @Resetter
  public static void anotherResetter() {
    resetCount++;
  }
}
