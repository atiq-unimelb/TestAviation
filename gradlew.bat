<?xml version="1.0" encoding="utf-8"?>
<!-- Copyright (C) 2010 The Android Open Source Project

     Licensed under the Apache License, Version 2.0 (the "License");
     you may not use this file except in compliance with the License.
     You may obtain a copy of the License at
  
          http://www.apache.org/licenses/LICENSE-2.0
  
     Unless required by applicable law or agreed to in writing, software
     distributed under the License is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     See the License for the specific language governing permissions and
     limitations under the License.
-->

<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item android:state_multiline="true" android:state_window_focused="false" android:state_enabled="true"  android:drawable="@drawable/textfield_multiline_default_holo_dark" />
    <item android:state_multiline="true" android:state_window_focused="false" android:state_enabled="false" android:drawable="@drawable/textfield_multiline_disabled_holo_dark" />
    <item android:state_multiline="true" android:state_enabled="true" android:state_focused="true" android:drawable="@drawable/textfield_multiline_activated_holo_dark" />
    <item android:state_multiline="true" android:state_enabled="true" android:state_activated="true" android:drawable="@drawable/textfield_multiline_focused_holo_dark" />
    <item android:state_multiline="true" android:state_enabled="true" android:drawable="@drawable/textfield_multiline_default_holo_dark" />
    <item android:state_multiline="true" android:state_focused="true" android:drawable="@drawable/textfield_multiline_disabled_focused_holo_dark" />
    <item android:state_multiline="true" android:drawable="@drawable/textfield_multiline_disabled_holo_dark" />

    <item android:state_window_focused="false" android:state_enabled="true" android:drawable="@drawable/textfield_default_holo_dark" />
    <item android:state_window_focused="false" android:state_enabled="false" android:drawable="@drawable/textfield_disabled_holo_dark" />
    <item android:state_enabled="true" android:state_focused="true" android:drawable="@drawable/textfield_activated_holo_dark" />
    <item