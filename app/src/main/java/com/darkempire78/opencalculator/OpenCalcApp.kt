package com.darkempire78.opencalculator

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode

//TODO ic_launcher
//TODO rate app, more app, share app
//TODO policy
//TODO firebase
//TODO ad
//TODO leak canary
//TODO keystore
//TODO permission ad id

//https://github.com/tplloi/OpenCalc/tree/dev
class OpenCalcApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // if the theme is overriding the system, the first creation doesn't work properly
        val forceDayNight = MyPreferences(this).forceDayNight
        if (forceDayNight != MODE_NIGHT_UNSPECIFIED && forceDayNight != MODE_NIGHT_FOLLOW_SYSTEM)
            setDefaultNightMode(forceDayNight)
    }
}