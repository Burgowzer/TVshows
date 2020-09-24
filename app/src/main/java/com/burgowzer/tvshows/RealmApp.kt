package com.burgowzer.tvshows

import android.app.Application
import io.realm.Realm


class RealmApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }


}