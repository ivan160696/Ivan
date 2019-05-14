package info.goodline.department.learnandroid.local_storage

import info.goodline.department.learnandroid.R
import info.goodline.department.learnandroid.local_storage.extensions.map2DataList
import info.goodline.department.learnandroid.local_storage.extensions.map2Realm
import info.goodline.department.learnandroid.local_storage.models.Chat
import info.goodline.department.learnandroid.local_storage.models.ChatRealm
import info.goodline.department.learnandroid.local_storage.models.Message
import info.goodline.department.learnandroid.local_storage.models.User
import io.realm.Realm


class ChatRepository {

    fun loadChats(): MutableList<Chat> {
        Realm.getDefaultInstance().use { realm ->
            val results = realm
                    .where(ChatRealm::class.java)
                    .findAll()

            return realm.copyFromRealm(results).map2DataList()
        }
    }

    fun saveChat(chat: Chat) {
        Realm.getDefaultInstance().use { realm ->
            realm.beginTransaction()
            // Важный момент - При использовании copyToRealmOrUpdate если записи в бд нет, то она добавится, если
            // по первичному ключу запись будет найдена, то realm обновит ее
            realm.copyFromRealm(realm.copyToRealmOrUpdate(chat.map2Realm()))
            realm.commitTransaction()
        }
    }

    fun deleteChat(chat: Chat) {
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction {
                val result = it.where(ChatRealm::class.java)
                        .equalTo("id", chat.id)
                        .findAll()
                result.deleteAllFromRealm()
            }
        }
    }


    companion object {
        private val fakeUsers = mutableListOf(
                User(1, "Sandra Adams", R.drawable.userpic),
                User(2, "Ray Neal", R.drawable.userpic1),
                User(3, "Carrie Mann", R.drawable.userpic2),
                User(4, "Lelia Colon", R.drawable.userpic3),
                User(5, "Andrew Tomson", R.drawable.userpic4),
                User(6, "Trevor Nil", R.drawable.userpic5)
        )

        private val titleChats = mutableListOf(
                "Birthday gift",
                "Gym and pool time",
                "Write the report",
                "Recipe to try",
                "Brunch with friends"
        )

        private val fakeMessagesText = mutableListOf(
                "— It’s the one week of the year in which you get the chance to take…",
                "— Healthy, robust, contracting, healthy, robust and contracting like a lung.",
                "— A wonderful serenity has taken possession of my entire soul, like…",
                "— Speaking of which, Peter really wants you to come in on Friday.",
                "— Images span the screen in ribbons, which expand with"
        )

        fun getRandomChat() = Chat(
                System.currentTimeMillis(),
                titleChats[(0 until titleChats.size).random()],
                mutableListOf(getRandomFakeMessage())
        )


        fun getRandomFakeMessage() = Message(
                (0..900).random(),
                System.currentTimeMillis(),
                fakeMessagesText[(0 until fakeMessagesText.size).random()],
                getRandomFakeUser()
        )

        fun getRandomFakeUser(): User {
            // Получить случайное значение позиции для нового чата
            val positionNewChat = (0 until fakeUsers.size).random()
            // Вернуть чат с рандомной позицией
            return fakeUsers[positionNewChat]
        }
    }

}