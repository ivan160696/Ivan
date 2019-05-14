package info.goodline.department.learnandroid.local_storage.extensions

import info.goodline.department.learnandroid.local_storage.models.User
import info.goodline.department.learnandroid.local_storage.models.UserRealm

fun UserRealm.map2Data() = User(this.id, this.name, this.avatarUrl)

fun User.map2Realm(): UserRealm {
    val userRealm = UserRealm()
    userRealm.id = this.id
    userRealm.name = this.name
    userRealm.avatarUrl = this.avatarUrl
    return userRealm
}