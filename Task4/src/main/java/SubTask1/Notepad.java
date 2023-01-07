package SubTask1;


import java.util.*;
import java.util.function.BiFunction;

public class Notepad {
    static Map<String, String> notePad = new HashMap<>();

    static void addNewNote(Note note) {
        BiFunction<String, String, String> func = (oldValue, newValue) -> oldValue + ", " + newValue;
        notePad.merge(note.getDate(), note.getValue(), func);
    }

    public void getInfo() {
        System.out.println(notePad);
    }

    static class Note implements noteInfo {
        private String date;
        private String task;


        public Note(String date, String task) {
            this.date = date;
            this.task = task;
            addNewNote(this);
        }

        @Override
        public String getDate() {
            return date;
        }

        @Override
        public String getValue() {
            return task;
        }
    }


    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        new Note("2022-DEC-12", "go to swimming pool");
        new Note("2022-DEC-12", "shopping");
        new Note("2022-DEC-10", "make dinner");

        notepad.getInfo();
    }
}

