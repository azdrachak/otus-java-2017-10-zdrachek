package com.github.azdrachak.dataset;

public class UserDataSet extends DataSet {
    private final String name;

    private final int age;

    public UserDataSet(String name, Integer age) {
        this.id = 0;
        this.name = name;
        this.age = age;
    }

    public UserDataSet(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=\"" + name + "\"" +
                ", age=" + age +
                "}";
    }
}
