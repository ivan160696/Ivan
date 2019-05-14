package info.goodline.department.learnandroid.local_storage.models

data class Message(var id: Int = 0, var date: Long, var text: String, var user: User? = null)