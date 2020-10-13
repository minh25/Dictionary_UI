package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    private int MAX_SIZE = 200000;
    private int size = 0;
    public Word[] list = new Word[MAX_SIZE];

    public Dictionary(Word[] list) {
        this.list = list;
    }

    public Dictionary() {}

    public static void main(String[] args) throws IOException, ParseException {
        Dictionary x;
        x = math.LoadJson();
        System.out.println(x.getSize());
        Scanner in = new Scanner(System.in);
        while (true) {
            String key = in.next();
            if (key.toLowerCase().equals("add")) {
                String t = in.next();
                String content = in.nextLine();
                Word X = new Word(t, content);
                System.out.println(X);
                System.out.println(math.binarySearch(x, 0, x.getSize() - 1, X.get_target()));
                x.add(X);
                x.save();
            } else {
                if (key.toLowerCase().equals("delete")) {
                    String t = in.next();
                    Word X = new Word(t);
                    System.out.println(X);
                    System.out.println(math.binarySearch(x, 0, x.getSize() - 1, X.get_target()));
                    x.delete(X);
                    x.save();
                } else {
                    x.Find(key).print();
                }
            }
        }
    }

    /**
     * get the word in list b its index using for Finding function
     */
    public Word get(final int index) {
        return this.list[index];
    }

    /**
     * get the current size of the dictionary.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * check whether the dictionary is Empty or not.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    public void sort(){
        Arrays.sort(list,0,size-1);
    }

    /** don't touch :) */
    private void Expand() {
        this.MAX_SIZE *= 2;
        Word[] x = this.list.clone();
        this.list = new Word[this.MAX_SIZE];
        System.arraycopy(x, 0, this.list, 0, x.length);
    }

    /**
     * find some best match words with key.
     */
    public Dictionary Find(String key) {
        return math.FindIn(key, this);
    }
    /** don't touch:) */
    public boolean push(Object o) {
        if (o instanceof Word) {

            Word x = (Word) o;
            if (size == MAX_SIZE) {
                this.Expand();
            }
            list[size] = x;
            size += 1;
            return true;
        }
        return false;
    }
    /** delete a word from dictionary */
    public boolean delete(Word key) {
        int pos = math.binarySearch(this, 0, size - 1, key.get_target().toLowerCase());
        if (pos == -1) {
            System.out.println("not found word " + key.get_target());
            return false;
        } else {
            for (int i = pos; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            size--;
            System.out.println("deleted " + key.get_target());
            return true;
        }
    }
    /** add a word to dictionary or fix content of a word return true if add return false if fix */
    public boolean add(Word src) {
        int pos = math.binarySearch(this, 0, size - 1, src.get_target().toLowerCase());
        System.out.println(src.get_target().toLowerCase());
        if (pos != -1) {
            System.out.println(
                    "the content of word " + src.get_target() + " will be changed into " + src.get_content());
            list[pos].set_content(src.get_content());

            return false;
        } else {
            System.out.println("the word " + src.get_target() + " will be added to the data");
            int i;
            for (i = 0; i < size; i++) {
                if (list[i].compareTo(src) > 0) break;
            }
            if (size == MAX_SIZE) this.Expand();
            size++;
            for (int j = size; j > i; j--) {
                list[j] = list[j - 1];
            }
            list[i] = src;
            return true;
        }
    }
    /** save this dictionary to file in data */
    public void save() throws ParseException, IOException {
        JSONArray t = new JSONArray();
        for (int i = 0; i < size; i++) {
            t.add(list[i].toJson());
        }
        math.save(t);
    }
    /** print dictionary to console screen */
    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.list[i].get_target() + " : " + this.list[i].get_content());
        }
    }
}
