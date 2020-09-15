package com.diendev.jobbatch.domain;

public class TargetData {
    private Long id;

    private String name;

    public TargetData(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TargetData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
