package info.goodline.department.learnandroid.recycler_view.chat;

public class ChatItem {

    private int avatar;
    private String title;
    private String lastUserName;
    private String lastMessage;

    public ChatItem(String title, int avatar, String lastUserName, String lastMessage) {
        this.avatar = avatar;
        this.lastMessage = lastMessage;
        this.lastUserName = lastUserName;
        this.title = title;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getTitle() {
        return title;
    }

    public String getLastUserName() {
        return lastUserName;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
