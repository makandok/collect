package org.odk.collect.android.activities;

/*
 * Copyright (C) 2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import org.odk.collect.android.R;
import org.odk.collect.android.R.string;
import org.odk.collect.android.logic.GlobalConstants;

import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

/**
 * An example of tab content that launches an activity via
 * {@link android.widget.TabHost.TabSpec#setContent(android.content.Intent)}
 */
public class FormManagerTabs extends TabActivity {

    private static TextView tvl;
    private static TextView tvr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getString(R.string.app_name) + " > " + getString(R.string.manage_forms));

        final TabHost tabHost = getTabHost();
        tabHost.setBackgroundColor(Color.BLACK);

        Intent local = new Intent(this, LocalFormManager.class);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(getString(R.string.local_forms))
                .setContent(local));

        Intent remote = new Intent(this, RemoteFormManager.class);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(getString(R.string.remote_forms))
                .setContent(remote));

        // hack to set font size
        LinearLayout ll = (LinearLayout) tabHost.getChildAt(0);
        TabWidget tw = (TabWidget) ll.getChildAt(0);

        RelativeLayout rls = (RelativeLayout) tw.getChildAt(0);
        tvl = (TextView) rls.getChildAt(1);
        tvl.setTextSize(GlobalConstants.APPLICATION_FONTSIZE + 12);
        tvl.setPadding(0, 0, 0, 6);

        RelativeLayout rlc = (RelativeLayout) tw.getChildAt(1);
        tvr = (TextView) rlc.getChildAt(1);
        tvr.setTextSize(GlobalConstants.APPLICATION_FONTSIZE + 12);
        tvr.setPadding(0, 0, 0, 6);

    }


    public static void setTabHeader(String string, String tab) {
        if (tab.equals("tab1")) {
            tvl.setText(string);
        } else if (tab.equals("tab2")) {
            tvr.setText(string);
        }

    }



}