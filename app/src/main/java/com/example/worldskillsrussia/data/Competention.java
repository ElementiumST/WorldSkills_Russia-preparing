package com.example.worldskillsrussia.data;

public class Competention {
    private int id;
    private String name;
    private String discription;
    public Competention(int id, String name, String discription) {
        this.id = id;
        this.discription = discription;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
}
