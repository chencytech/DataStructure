package com.chaytech.datastructure;


public class Person implements Comparable<Person>{
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        if (age > o.getAge()) return 1;
        if (age < o.getAge()) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "age_" + age + "_name_" + name;
    }
}
