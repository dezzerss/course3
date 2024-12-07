import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        editor.addText("Привет, ");
        history.save(editor.save());
        System.out.println("Текущий текст: " + editor.getText());

        editor.addText("мир!");
        history.save(editor.save());
        System.out.println("Текущий текст: " + editor.getText());

        editor.deleteText(4);
        System.out.println("Текущий текст после удаления: " + editor.getText());

        editor.restore(history.getLast());
        System.out.println("Восстановленный текст: " + editor.getText());

        editor.restore(history.get(0));
        System.out.println("Восстановленный текст (первое состояние): " + editor.getText());
    }
}

class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class TextEditor {
    private StringBuilder text;

    public TextEditor() {
        this.text = new StringBuilder();
    }

    public void addText(String newText) {
        text.append(newText);
    }

    public void deleteText(int length) {
        if (length > text.length()) {
            text.setLength(0);
        } else {
            text.delete(text.length() - length, text.length());
        }
    }

    public String getText() {
        return text.toString();
    }

    public TextMemento save() {
        return new TextMemento(text.toString());
    }

    public void restore(TextMemento memento) {
        text = new StringBuilder(memento.getText());
    }
}

class TextEditorHistory {
    private final List<TextMemento> history = new ArrayList<>();

    public void save(TextMemento memento) {
        history.add(memento);
    }

    public TextMemento get(int index) {
        if (index < 0 || index >= history.size()) {
            throw new IndexOutOfBoundsException("Нет сохраненного состояния с таким индексом.");
        }
        return history.get(index);
    }

    public TextMemento getLast() {
        if (history.isEmpty()) {
            throw new IllegalStateException("История пуста.");
        }
        return history.get(history.size() - 1);
    }
}