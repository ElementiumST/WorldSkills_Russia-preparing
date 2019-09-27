package com.example.worldskillsrussia.data;

import java.util.List;

public class CompGroup {
    private int id;
    private String name;
    private List<Competention> comps;

    public CompGroup(int id, String name, List<Competention> comps){
        this.id = id;
        this.name = name;
        this.comps = comps;

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

    public List<Competention> getComps() {
        return comps;
    }

    public void setComps(List<Competention> comps) {
        this.comps = comps;
    }
}
