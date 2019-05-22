package comunicare;

public class T2 implements Runnable {

    Chat chat;
    String[] answers = {
            "Hi",
            "I am good, what about you?",
            "Great!"
    };

    public T2(Chat chat) {
        this.chat = chat;
        new Thread(this, "Answers-Thread").start();
    }

    @Override
    public void run() {
        for (String temp : answers) {
            chat.answer(temp);
        }
    }
}
