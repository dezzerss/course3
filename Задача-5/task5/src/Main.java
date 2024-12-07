import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User alice = new User("Алиса");
        User bob = new User("Боб");

        Follower charlie = new Follower("Чарли");
        Follower diana = new Follower("Диана");

        alice.subscribe(charlie);
        alice.subscribe(diana);

        bob.subscribe(charlie);

        alice.post("Всем привет! Это моя первая публикация.");
        alice.comment("Спасибо за поддержку!");
        bob.like("Алиса");

        alice.unsubscribe(diana);

        alice.post("Еще одна публикация только для подписчиков!");
    }
}

interface Observer {
    void update(String message);
}

interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers(String message);
}

class User implements Subject {
    private String name;
    private List<Observer> followers;

    public User(String name) {
        this.name = name;
        this.followers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void subscribe(Observer observer) {
        followers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        followers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer follower : followers) {
            follower.update(message);
        }
    }

    public void post(String content) {
        System.out.println(name + " опубликовал(а): " + content);
        notifyObservers(name + " опубликовал(а): " + content);
    }

    public void comment(String comment) {
        System.out.println(name + " оставил(а) комментарий: " + comment);
        notifyObservers(name + " оставил(а) комментарий: " + comment);
    }

    public void like(String postOwner) {
        System.out.println(name + " лайкнул(а) публикацию " + postOwner);
        notifyObservers(name + " лайкнул(а) публикацию " + postOwner);
    }
}

class Follower implements Observer {
    private String name;

    public Follower(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил(а) уведомление: " + message);
    }
}

