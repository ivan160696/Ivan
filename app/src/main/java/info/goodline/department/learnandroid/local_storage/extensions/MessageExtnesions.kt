package info.goodline.department.learnandroid.local_storage.extensions

import info.goodline.department.learnandroid.local_storage.models.Message
import info.goodline.department.learnandroid.local_storage.models.MessageRealm
import io.realm.RealmList

fun MessageRealm.map2Data() = Message(this.id, this.date, this.text, this.user?.map2Data())

fun Message.map2Realm(): MessageRealm {
    val messageRealm = MessageRealm()
    messageRealm.id = this.id
    messageRealm.date = this.date
    messageRealm.text = this.text
    messageRealm.user = this.user?.map2Realm()
    return messageRealm
}

fun MutableList<Message>.map2RealmList(): RealmList<MessageRealm> {
    val rl = RealmList<MessageRealm>()
    this.forEach { rl.add(it.map2Realm()) }
    return rl
}

fun MutableList<MessageRealm>.map2DataList(): MutableList<Message> {
    val l = ArrayList<Message>()
    this.forEach { l.add(it.map2Data()) }
    return l
}