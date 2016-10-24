/*
 * LocationInformation.java
 * PagedCardView
 *
 * Appvation Pty Ltd
 * 202/147 Pirie Street
 * ADELAIDE SA 5000
 * w: www.appvation.com
 * p: +61 8 7200 5577
 *
 * Copyright © 2016 Appvation Pty. Ltd. All rights reserved.
 */

package com.appvation.pagedcardview;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationInformation {
    static LocationInformation create(String name, String address) {
        return new AutoValue_LocationInformation(name, address);
    }

    @NonNull
    public abstract String getName();

    @NonNull
    public abstract String getAddress();
}
