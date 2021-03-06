package com.marianhello.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.marianhello.bgloc.Config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by finch on 29.11.2016.
 */

public class ConfigMapper {
    public static Config mapToConfig(ReadableMap options) {
        Config config = new Config();
        if (options.hasKey("stationaryRadius")) config.setStationaryRadius((float) options.getDouble("stationaryRadius"));
        if (options.hasKey("distanceFilter")) config.setDistanceFilter(options.getInt("distanceFilter"));
        if (options.hasKey("desiredAccuracy")) config.setDesiredAccuracy(options.getInt("desiredAccuracy"));
        if (options.hasKey("debug")) config.setDebugging(options.getBoolean("debug"));
        if (options.hasKey("notificationTitle")) config.setNotificationTitle(options.getString("notificationTitle"));
        if (options.hasKey("notificationText")) config.setNotificationText(options.getString("notificationText"));
        if (options.hasKey("notificationIconLarge")) config.setLargeNotificationIcon(options.getString("notificationIconLarge"));
        if (options.hasKey("notificationIconSmall")) config.setSmallNotificationIcon(options.getString("notificationIconSmall"));
        if (options.hasKey("notificationIconColor")) config.setNotificationIconColor(options.getString("notificationIconColor"));
        if (options.hasKey("stopOnTerminate")) config.setStopOnTerminate(options.getBoolean("stopOnTerminate"));
        if (options.hasKey("startOnBoot")) config.setStartOnBoot(options.getBoolean("startOnBoot"));
        if (options.hasKey("startForeground")) config.setStartForeground(options.getBoolean("startForeground"));
        if (options.hasKey("locationProvider")) config.setLocationProvider(options.getInt("locationProvider"));
        if (options.hasKey("interval")) config.setInterval(options.getInt("interval"));
        if (options.hasKey("fastestInterval")) config.setFastestInterval(options.getInt("fastestInterval"));
        if (options.hasKey("activitiesInterval")) config.setActivitiesInterval(options.getInt("activitiesInterval"));
        if (options.hasKey("stopOnStillActivity")) config.setStopOnStillActivity(options.getBoolean("stopOnStillActivity"));
        if (options.hasKey("url")) config.setUrl(options.getString("url"));
        if (options.hasKey("syncUrl")) config.setSyncUrl(options.getString("syncUrl"));
        if (options.hasKey("syncThreshold")) config.setSyncThreshold(options.getInt("syncThreshold"));
        if (options.hasKey("httpHeaders")) {
            HashMap httpHeaders = new HashMap<String, String>();
            ReadableMap rm = options.getMap("httpHeaders");
            ReadableMapKeySetIterator it = rm.keySetIterator();

            while (it.hasNextKey()) {
                String key = it.nextKey();
                httpHeaders.put(key, rm.getString(key));
            }

            config.setHttpHeaders(httpHeaders);
        }
        if (options.hasKey("maxLocations")) config.setMaxLocations(options.getInt("maxLocations"));

        return config;
    }

    public static ReadableMap configToMap(Config config) {
        WritableMap out = Arguments.createMap();
        WritableMap httpHeaders = Arguments.createMap();
        out.putDouble("stationaryRadius", config.getStationaryRadius());
        out.putInt("distanceFilter", config.getDistanceFilter());
        out.putInt("desiredAccuracy", config.getDesiredAccuracy());
        out.putBoolean("debug", config.isDebugging());
        out.putString("notificationTitle", config.getNotificationTitle());
        out.putString("notificationText", config.getNotificationText());
        out.putString("notificationIconLarge", config.getLargeNotificationIcon());
        out.putString("notificationIconSmall", config.getSmallNotificationIcon());
        out.putString("notificationIconColor", config.getNotificationIconColor());
        out.putBoolean("stopOnTerminate", config.getStopOnTerminate());
        out.putBoolean("startOnBoot", config.getStartOnBoot());
        out.putBoolean("startForeground", config.getStartForeground());
        out.putInt("locationProvider", config.getLocationProvider());
        out.putInt("interval", config.getInterval());
        out.putInt("fastestInterval", config.getFastestInterval());
        out.putInt("activitiesInterval", config.getActivitiesInterval());
        out.putBoolean("stopOnStillActivity", config.getStopOnStillActivity());
        out.putString("url", config.getUrl());
        out.putString("syncUrl", config.getSyncUrl());
        out.putInt("syncThreshold", config.getSyncThreshold());
        // httpHeaders
        Iterator<Map.Entry<String, String>> it = config.getHttpHeaders().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> pair = it.next();
            httpHeaders.putString(pair.getKey(), pair.getValue());
        }
        out.putMap("httpHeaders", httpHeaders);
        out.putInt("maxLocations", config.getMaxLocations());

        return out;
    }
}
