package br.eti.kinoshita.tests.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class BC1 {

    public static void main(String[] args) throws Exception {
        LineIterator iter = IOUtils.lineIterator(BC1.class.getResourceAsStream("/test.txt"), (String) null);
        System.out.println(iter.next());
    }
}
