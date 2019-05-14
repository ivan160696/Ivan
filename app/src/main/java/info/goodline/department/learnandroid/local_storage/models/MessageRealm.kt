package info.goodline.department.learnandroid.local_storage.models

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class MessageRealm : RealmModel {
    @PrimaryKey
    var id: Int = 0
    var date: Long = System.currentTimeMillis()
    var text: String = ""
    var user: UserRealm? = null
}