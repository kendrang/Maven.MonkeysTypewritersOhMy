package io.zipcoder;

import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }
    public void run() {
        try {
            while (stringIterator.hasNext()) {
                sleep(100);
                if (stringIterator.hasNext()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.stringIterator.next()).append(" ");
                    copied += sb.toString();
//                        System.out.println(Thread.currentThread().getName());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
