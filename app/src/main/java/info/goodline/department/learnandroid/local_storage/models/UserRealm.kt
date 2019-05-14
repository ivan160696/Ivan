package info.goodline.department.learnandroid.local_storage.models

import io.realm.RealmModel
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class UserRealm : RealmModel {
    @PrimaryKey
    var id: Int = 0
    var name: String = ""
    var avatarUrl: Int = 0
}