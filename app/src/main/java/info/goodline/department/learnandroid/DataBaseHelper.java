package info.goodline.department.learnandroid;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import info.goodline.department.learnandroid.recycler_view.chat.ChatItem;
import info.goodline.department.learnandroid.recycler_view.google_play.App;
import info.goodline.department.learnandroid.recycler_view.google_play.Category;

public class DataBaseHelper {

    private static List<User> users;
    private static List<Comment> commentsJon;
    private static List<Comment> commentsLisa;
    public static final int USER_JON = 0;
    public static final int USER_LISA = 1;

    public static List<ChatItem> chats = Arrays.asList(
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "— It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "— Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "— A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "— Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "— Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "— It’s the one week of the year in which you get the chance to take…"),
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "— It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "— Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "— A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "— Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "— Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "— It’s the one week of the year in which you get the chance to take…"),
            new ChatItem("Birthday gift", R.drawable.userpic, "Sandra Adams ",
                    "— It’s the one week of the year in which you get the chance to take…"),

            new ChatItem("Gym and pool time ", R.drawable.userpic1, "Ray Neal ",
                    "— Healthy, robust, contracting, healthy, robust and contracting like a lung."),

            new ChatItem("Write the report", R.drawable.userpic2, "Carrie Mann ",
                    "— A wonderful serenity has taken possession of my entire soul, like…"),

            new ChatItem("Recipe to try", R.drawable.userpic3, "Lelia Colon ",
                    "— Speaking of which, Peter really wants you to come in on Friday."),

            new ChatItem("Brunch with friends", R.drawable.userpic4, "to Trevor, Andrew, Sandra ",
                    "— Images span the screen in ribbons, which expand with "),

            new ChatItem("Birthday gift", R.drawable.userpic5, "Sandra Adams  ",
                    "— It’s the one week of the year in which you get the chance to take…")


    );


    private static List<Category> googlePlayApps = Arrays.asList(
            new Category("Good Line - Лидер интернет-рынка Кузбасса", Arrays.asList(
                    new App("https://lh3.googleusercontent.com/noI0vfBQ8QQET9toHYpkPGstOTJ6EJW1YyUpb1Ab7U077Il7PMGju1nRPleGRlr2BA=s180",
                            "Good Line — техподдержка и оплата услуг.", 20),
                    new App("https://lh3.googleusercontent.com/PM6rEeTpUhPFnjAA-oRlP6svz6QzjgrXFTdnDlF2qLWfiNFFYoQhV7To_LZa-MWW0Zo=s180",
                            "ЖКХ Кузбасс. Оплата за квартиру", 20),
                    new App("https://lh3.googleusercontent.com/U1g4TnIfoZxj1p5gaLYkYy6ABuEIKI8AdphIRw3rdOrkJvuVbK1bFjlQELC9187_ykY=s180",
                            "Видеоконтроль", 20),
                    new App("https://lh3.googleusercontent.com/tZkNTXnJmJzsKVLZ23X1-d9kgwCHIkYz7ikUxOQb74Hny0ALnq_ypSSwZjt-MaVOiA=s180",
                            "Датчик спокойствия", 20),
                    new App("https://lh3.googleusercontent.com/DJqVRIGySVOJiMJWNENr3-TSE40Q08CDb-cCMRIYNfLFrHf1yvz7l0agstaG4dy9yqY=s180",
                            "Афиша Кемерово", 20),
                    new App("https://lh3.googleusercontent.com/UdeonsCN5zfSgCLP6EpHOi8BYu1KV7QLCjbhMabZWQmHiIKUZkh9anrG4jBszjAAnqY=s180",
                            "Онлайн-дозор", 20),
                    new App("https://lh3.googleusercontent.com/0sB5xPXHUNIglsIVPH1Yzd-OZWm-NsjlsRX5Kaw4D6Py15SdmY3yp0iwaMSccCQqJ_8=s180",
                            "Большое ТВ — фильмы, сериалы, мультики и ТВ онлайн", 20)
            )),
            new Category("Связь и социальные", Arrays.asList(
                    new App("https://lh3.googleusercontent.com/aYbdIM1abwyVSUZLDKoE0CDZGRhlkpsaPOg9tNnBktUQYsXflwknnOn2Ge1Yr7rImGk=s180",
                            "Instagram", 42),
                    new App("https://lh3.ggpht.com/mp86vbELnqLi2FzvhiKdPX31_oiTRLNyeK8x4IIrbF5eD1D5RdnVwjQP0hwMNR_JdA=s180",
                            "WhatsApp Messenger", 20),
                    new App("https://lh3.googleusercontent.com/8OiHVtg9BUN9Ms3LjD7RBhWGimOBSUoo7hdPymXcl-nIXeqA3C6La7qK59squ-emgQ=s180",
                            "ВКонтакте — социальная сеть", 37),
                    new App("https://lh3.googleusercontent.com/5mPU4oU3EIbuAotT3o9iEqFz_1CrmcJlMwjKvAqoLvQtbW2t0o_91Z8fSMQEQMHc5eur=s180",
                            "Скайп — бесплатные мгновенные сообщения и видеозв", 33),
                    new App("https://lh3.ggpht.com/vdK_CsMSsJoYvJpYgaj91fiJ1T8rnSHHbXL0Em378kQaaf_BGyvUek2aU9z2qbxJCAFV=s180",
                            "Snapchat", 33)
            )),


            new Category("Google LLC", Arrays.asList(
                    new App("https://lh3.googleusercontent.com/N-AY2XwXafWq4TQWfua6VyjPVQvTGRdz9CKOHaBl2nu2GVg7zxS886X5giZ9yY2qIjPh=s180",
                            "Google+", 20),
                    new App("https://lh3.ggpht.com/DY9VpGNRSHoICKJVpIy9dMjgm7TOb3lTveLtsv4got8aqbLGpSS4w5xXiR7VBe-mr_M=s180",
                            "Google Keep – заметки и списки", 20),
                    new App("https://lh3.ggpht.com/e3oZddUHSC6EcnxC80rl_6HbY94sM63dn6KrEXJ-C4GIUN-t1XM0uYA_WUwyhbIHmVMH=s180",
                            "Google Таблицы", 20),
                    new App("https://lh3.ggpht.com/-wROmWQVYTcjs3G6H0lYkBK2nPGYsY75Ik2IXTmOO2Oo0SMgbDtnF0eqz-BRR1hRQg=s180",
                            "Google Документы", 20),
                    new App("https://lh3.googleusercontent.com/Ned_Tu_ge6GgJZ_lIO_5mieIEmjDpq9kfgD05wapmvzcInvT4qQMxhxq_hEazf8ZsqA=s180",
                            "YouTube", 20),
                    new App("https://lh3.ggpht.com/k7Z4J1IIXXJnC2NRnFfJNlkn7kZge4Zx-Yv5uqYf4222tx74wXDzW24OvOxlcpw0KcQ=s180",
                            "Google Диск", 20),
                    new App("https://lh3.ggpht.com/oGR9I1X9No3SfFEXrq655tETtVVzI3jIphhmEVPGPEVuM5gfwh8lOGWHQFf6gjSTvw=s180",
                            "Google Календарь", 20)
            ))
    );


    public static void initDatabase() {
        users = new ArrayList<>();
        commentsJon = new ArrayList<>();
        commentsLisa = new ArrayList<>();

        User jon = new User();
        jon.setId(USER_JON);
        jon.setName("Jon");
        jon.setEmail("jon@mail.com");

        User lisa = new User();
        lisa.setId(USER_LISA);
        lisa.setName("Lisa");
        lisa.setEmail("lisa@mail.com");

        users.add(jon);
        users.add(lisa);

        for (int i = 1; i < 4; i++) {
            commentsJon.add(new Comment("Comment #" + i + " from Jon"));
            commentsLisa.add(new Comment("Comment #" + i + " from Lisa"));
        }


    }

    @Nullable
    public static List<Comment> getCommentsByUserId(int userId) {
        switch (userId) {
            case USER_JON:
                return commentsJon;
            case USER_LISA:
                return commentsLisa;
        }

        return null;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static ChatItem createChat() {
        Random r = new Random();
        // Получить случайное значение позиции для нового чата
        int positionNewChat = r.nextInt(chats.size() - 1);
        // Вернуть чат с рандомной позицией
        return chats.get(positionNewChat);
    }

    public static List<Category> getGooglePlayApps() {
        return googlePlayApps;
    }
}
