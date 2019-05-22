package comunicare;

//clasa chat: metode question, answer,
// care sa comunice intre ele
public class Chat {

    //verificam daca avem deschis canalul de comunicatie
    boolean isActionUnavailable = false;

    synchronized void question(String question) {
        if (isActionUnavailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(question);
        isActionUnavailable = true;
        notify();

    }

    synchronized void answer(String answer) {
        if (!isActionUnavailable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(answer);
        isActionUnavailable = false;
        notify();
    }
}
