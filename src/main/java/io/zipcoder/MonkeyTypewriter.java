package io.zipcoder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.

        UnsafeCopier badCopy = new UnsafeCopier(introduction);
        SafeCopier safeCopy = new SafeCopier(introduction);

        Thread[] theMonkeys = new Thread[5];
        Thread[] smartMonkeys = new Thread[5];
        for (int i = 0 ; i < 5 ; i++){
            theMonkeys[i] = new Thread(badCopy);
            smartMonkeys[i] = new Thread(safeCopy);
        }


        for (Thread monkey : theMonkeys){
            monkey.start();
        }
        for (Thread monkey : theMonkeys){
            try { monkey.join();}
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (Thread smonkey : smartMonkeys){
            smonkey.start();
        }
        for (Thread smonkey : smartMonkeys){
            try { smonkey.join();}
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        // Print out the copied versions here.
        System.out.println("\nUnsafe : \n=======");
        System.out.println(badCopy.copied);
        System.out.println("\nSafe: \n=======");
        System.out.println(safeCopy.copied);
    }
}