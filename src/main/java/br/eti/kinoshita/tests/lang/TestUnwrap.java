package br.eti.kinoshita.tests.lang;

import org.apache.commons.lang3.StringUtils;

public class TestUnwrap {

    public static void main(String[] args) {
        System.out.println("Result: " + StringUtils.unwrap("aa", "a"));
        System.out.println("Result: " + StringUtils.unwrap("a", "a"));
    }
}
