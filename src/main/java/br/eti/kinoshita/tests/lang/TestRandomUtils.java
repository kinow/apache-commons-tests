package br.eti.kinoshita.tests.lang;

import org.apache.commons.lang3.RandomUtils;

public class TestRandomUtils {

    public static void main(String[] args) {
        double d = RandomUtils.nextDouble(1.0, 1.1);
        System.out.println(d);
    }
}
