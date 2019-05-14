package info.goodline.department.learnandroid.local_storage.extensions

import info.goodline.department.learnandroid.local_storage.models.Chat
import info.goodline.department.learnandroid.local_storage.models.ChatRealm
import io.realm.RealmList

fun ChatRealm.map2Data() = Chat(this.id, this.name, this.messages?.map2DataList())

fun Chat.map2Realm(): ChatRealm {
    val chatRealm = ChatRealm()
    chatRealm.id = this.id
    chatRealm.name = this.name
    chatRealm.messages = this.messages?.map2RealmList()
    return chatRealm
}

fun MutableList<Chat>.map2RealmList(): RealmList<ChatRealm> {
    val rl = RealmList<ChatRealm>()
    this.forEach { rl.add(it.map2Realm()) }
    return rl
}

fun MutableList<ChatRealm>.map2DataList(): MutableList<Chat> {
    val l = ArrayList<Chat>()
    this.forEach { l.add(it.map2Data()) }
    return l
}