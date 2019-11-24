package com.xebia.activityrecognition;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;

import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.google.android.gms.location.DetectedActivity;

import java.util.HashMap;

public class ActivityEventService extends HeadlessJsTaskService {
    @Nullable
    protected HeadlessJsTaskConfig getTaskConfig(Intent intent) {
      Bundle extras = intent.getExtras();

      // Create writableMap from Hashmap
      WritableMap params = Arguments.createMap();

      if (extras != null)
      {
          HashMap<String, Integer> hashMap = (HashMap<String, Integer>) extras.getSerializable("map");

          for (String key : hashMap.keySet()) {
              params.putInt(key, hashMap.get(key));
          }
      }


      return new HeadlessJsTaskConfig(
        "ActivityRecognized",
        extras != null ? params : null,
        5000,
      true);
    }
  }