package com.example.inittrack2

import android.app.Application

class GlobalsActivity : Application() {
    companion object{
        var global_styles = "Sepia"
        var global_toggle_background_colours_friend_enemy = "On"
        val NOTICE_RADIUS = 3
        val CAMPFIRE_DISTANCE = 2
    }
    override fun onCreate() {
        super.onCreate()
        // initialization code here
    }
}