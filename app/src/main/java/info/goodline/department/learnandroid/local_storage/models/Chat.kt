package info.goodline.department.learnandroid.local_storage.models

data class Chat(var id: Long = 0L, var name: String, var messages: MutableList<Message>? = null)