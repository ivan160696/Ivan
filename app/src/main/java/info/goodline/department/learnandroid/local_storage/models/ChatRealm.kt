package info.goodline.department.learnandroid.local_storage.models

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class ChatRealm : RealmModel {
    @PrimaryKey
    var id: Long = 0L
    var name: String = ""
    var messages: RealmList<MessageRealm>? = null
}