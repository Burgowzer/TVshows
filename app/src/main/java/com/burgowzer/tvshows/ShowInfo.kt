package com.burgowzer.tvshows

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass

open class ShowInfo: RealmObject() {

    var showTitle:String=""
    var showDescription:String=""
}