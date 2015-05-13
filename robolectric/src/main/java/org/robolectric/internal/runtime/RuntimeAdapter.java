package org.robolectric.internal.runtime;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/**
 * Interface between Robolectric runtime and shadows-core.
 */
public interface RuntimeAdapter {
  void callActivityAttach(Object component, Context baseContext, Class<?> activityThreadClass, Application application, Intent intent, ActivityInfo activityInfo, String activityTitle, Class<?> nonConfigurationInstancesClass);
}
