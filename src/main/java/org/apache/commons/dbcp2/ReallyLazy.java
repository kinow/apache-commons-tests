package org.apache.commons.dbcp2;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ReallyLazy {

    private final static String TEMPLATE1 = "" +
            "    @Test\n" + 
            "    public void METHOD_NAME() throws Exception {\n" + 
            "        try {\n" + 
            "            delegate.METHOD(PARAM);\n" + 
            "        } catch (SQLException e) {}\n" + 
            "        verify(obj, times(1)).METHOD(PARAM);\n" + 
            "    }\n";

    public static void main(String[] args) throws Exception {
        Class<Statement> ref = Statement.class;
        Method[] ms = ref.getDeclaredMethods();
        HashSet<Method> metaMethods = new HashSet<>();
        for (Method m : ms) {
            metaMethods.add(m);
        }
        Class<DelegatingStatement> c = DelegatingStatement.class;
        ms = c.getDeclaredMethods();
        HashSet<Method> delegateMethods = new HashSet<>();
        for (Method m : ms) {
            for (Method meta : metaMethods)
                if (meta.getName()
                        .equals(m.getName())) {
                    delegateMethods.add(m);
                    break;
                }
        }
        List<Method> methods = new ArrayList<>(delegateMethods);
        Collections.sort(methods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getName()
                        .compareTo(o2.getName());
            }
        });
        for (Method method : methods) {
            List<String> paramValue = new ArrayList<>();
            String testMethod = "test" + Character.toUpperCase(method.getName()
                    .charAt(0)) + method.getName()
                            .substring(1);
            Class<?>[] params = method.getParameterTypes();
            for (Class<?> param : params) {
                if (param == int.class || param == Integer.class) {
                    paramValue.add("1");
                    testMethod += "Integer";
                } else if (param == int[].class || param == Integer[].class) {
                    paramValue.add("(int[]) null");
                    testMethod += "IntegerArray";
                } else if (param == short.class || param == Short.class) {
                    paramValue.add("(short) 1");
                    testMethod += "Short";
                } else if (param == long.class || param == Long.class) {
                    paramValue.add("1l");
                    testMethod += "Long";
                } else if (param == float.class || param == Float.class) {
                    paramValue.add("1.0f");
                    testMethod += "Float";
                } else if (param == double.class || param == Double.class) {
                    paramValue.add("1.0d");
                    testMethod += "Double";
                } else if (param == byte.class || param == Byte.class) {
                    paramValue.add("(byte) 1");
                    testMethod += "Byte";
                } else if (param == String.class) {
                    paramValue.add("\"foo\"");
                    testMethod += "String";
                } else if (param == String[].class) {
                    paramValue.add("(String[]) null");
                    testMethod += "StringArray";
                } else if (param == java.util.Calendar.class) {
                    paramValue.add("(java.util.Calendar) null");
                    testMethod += "Calendar";
                } else if (param == Map.class) {
                    paramValue.add("(java.util.Map) null");
                    testMethod += "Map";
                } else if (param == Class.class) {
                    paramValue.add("Object.class");
                    testMethod += "Class";
                } else if (param == boolean.class || param == Boolean.class) {
                    paramValue.add("Boolean.TRUE");
                    testMethod += "Boolean";
                } else if (param == java.io.InputStream.class) {
                    paramValue.add("(java.io.InputStream) null");
                    testMethod += "InputStream";
                } else if (param == BigDecimal.class) {
                    paramValue.add("java.math.BigDecimal.valueOf(1.0d)");
                    testMethod += "BigDecimal";
                } else if (param == java.sql.Blob.class) {
                    paramValue.add("(java.sql.Blob) null");
                    testMethod += "Blob";
                } else if (param == java.sql.Clob.class) {
                    paramValue.add("(java.sql.Clob) null");
                    testMethod += "Clob";
                } else if (param == java.sql.NClob.class) {
                    paramValue.add("(java.sql.NClob) null");
                    testMethod += "NClob";
                } else if (param == byte[].class || param == Byte[].class) {
                    paramValue.add("new byte[] { 1 }");
                    testMethod += "ByteArray";
                } else if (param == java.io.Reader.class) {
                    paramValue.add("(java.io.StringReader) null");
                    testMethod += "Reader";
                } else if (param == java.sql.Date.class) {
                    paramValue.add("new java.sql.Date(1529827548745l)");
                    testMethod += "SqlDate";
                } else if (param == Object.class) {
                    paramValue.add("System.err");
                    testMethod += "Object";
                } else if (param == java.net.URL.class) {
                    paramValue.add("(java.net.URL) null");
                    testMethod += "Url";
                } else if (param.getName().contains("java.sql")) {
                    paramValue.add("(" + param.getName() + ") null");
                    testMethod += Class.forName(param.getName()).getSimpleName();
                } else {
                    System.out.println(method);
                    System.out.println(param);
                    throw new RuntimeException(method.getName() + " - " + param.getName() + " - " + param.getClass());
                }

            }
            String out = TEMPLATE1.replaceAll("METHOD_NAME", testMethod)
                    .replaceAll("PARAM", String.join(",", paramValue))
                    .replaceAll("METHOD", method.getName());
            System.out.println(out);
        }
    }

}
