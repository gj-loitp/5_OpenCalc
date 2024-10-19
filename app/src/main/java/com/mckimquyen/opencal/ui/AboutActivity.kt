package com.mckimquyen.opencal.ui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mckimquyen.opencal.BuildConfig
import com.mckimquyen.opencal.R
import com.mckimquyen.opencal.databinding.AAboutBinding
import com.mckimquyen.opencal.db.MyPreferences
import com.mckimquyen.opencal.ext.moreApp
import com.mckimquyen.opencal.ext.openBrowserPolicy
import com.mckimquyen.opencal.ext.rateApp
import com.mckimquyen.opencal.ext.shareApp
import com.mckimquyen.opencal.model.Themes

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: AAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        // Themes
        val themes = Themes(this)
        themes.applyDayNightOverride()
        setTheme(themes.getTheme())

        // Change the status bar color
        if (MyPreferences(this).theme == 1) { // Amoled theme
            window.statusBarColor = ContextCompat.getColor(this, R.color.amoled_background_color)
        } else {
            window.statusBarColor = ContextCompat.getColor(this, R.color.background_color)
        }

        binding = AAboutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Set app version
        val versionName =
            this.getString(R.string.app_version_title) + " " + BuildConfig.VERSION_NAME
        binding.tvAboutAppVersion.text = versionName

        // back button
        binding.ivAboutBack.setOnClickListener {
            finish()
        }

        // Rate
        binding.tvAboutRate.setOnClickListener {
            rateApp(packageName)
        }
        binding.tvAboutMoreApp.setOnClickListener {
            moreApp()
        }
        binding.tvAboutShareApp.setOnClickListener {
            shareApp()
        }

        binding.tvAboutPrivacyPolicy.setOnClickListener {
            openBrowserPolicy()
        }

        var clickAppVersionCount = 0
        binding.tvAboutAppVersion.setOnClickListener {
            clickAppVersionCount++
            if (clickAppVersionCount > 3) {
                Toast.makeText(
                    this,
                    this.getString(R.string.thanks_for_using_app),
                    Toast.LENGTH_SHORT
                ).show()
                clickAppVersionCount = 0
            }
        }
    }

    override fun attachBaseContext(context: Context) {
        val override = Configuration(context.resources.configuration)
        override.fontScale = 1.0f
        applyOverrideConfiguration(override)
        super.attachBaseContext(context)
    }
}
