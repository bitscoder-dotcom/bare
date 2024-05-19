package com.bitcoder_dotcom.bare.exercise2;

import org.springframework.stereotype.Component;

/**
 * Given two tables (T1 and T2) below, write a Structured Query Language (MySql | Postgres |
 * Oracle) that when executed returns the ordered records in T1 but NOT in T2, as Output.
 */
@Component
public class Exercise2 {


    public void executeQuery() {
        String sql = "SELECT * FROM T1 WHERE NOT EXISTS (SELECT 1 FROM T2 WHERE T2.id = T1.id) ORDER BY T1.id";

    }

    private static class MyRow {
        private final int id;
        private final String name;
        private final int age;

        public MyRow(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "MyRow{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}