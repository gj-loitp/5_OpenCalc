package com.roy

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_UNSPECIFIED
import androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode
import com.roy.db.MyPreferences

//TODO firebase
//TODO ad
//TODO leak canary
//TODO keystore
//TODO permission ad id

//done
//ic_launcher
//policy
//rate app, more app, share app

//https://github.com/tplloi/OpenCalc/tree/dev
class OpenCalcApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // if the theme is overriding the system, the first creation doesn't work properly
        val forceDayNight = MyPreferences(this).forceDayNight
        if (forceDayNight != MODE_NIGHT_UNSPECIFIED && forceDayNight != MODE_NIGHT_FOLLOW_SYSTEM) {
            setDefaultNightMode(forceDayNight)
        }
    }
}
