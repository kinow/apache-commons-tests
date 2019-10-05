package br.eti.kinoshita.tests.lang;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class TestToStringStyle {

    private final static class Car {
        public String brand;
        public String model;
        public int year;
        
        @Override
        public String toString() {
            ToStringBuilder.setDefaultStyle(ToStringStyle.JSON_STYLE);
            return new ToStringBuilder(this)
                    .append("brand", brand)
                    .append("model", model)
                    .append("year", year)
                    .toString();
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.brand = "Toyota";
        car1.model = "Corolla";
        car1.year = 1999;
        System.out.println(car1);
        // TODO: deprecated? LANG-1366
    }

}
