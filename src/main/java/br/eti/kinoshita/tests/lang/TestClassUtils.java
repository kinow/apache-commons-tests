package br.eti.kinoshita.tests.lang;

import org.apache.commons.lang3.ClassUtils;

public class TestClassUtils {

    public static void main(String[] args) {
        final String className = "br.eti.kinoshita.tests.lang.TestClassUtils";
        System.out.println(ClassUtils.getAbbreviatedName(className, className.length()));
        System.out.println(ClassUtils.getAbbreviatedName(TestClassUtils.class, TestClassUtils.class.getCanonicalName().length()));
        // prints:
        // b.eti.kinoshita.tests.lang.TestClassUtils
        // so the br was abbreviated...
        System.out.println(ClassUtils.getAbbreviatedName("ab.de.Ghij", 10));
    }
}
