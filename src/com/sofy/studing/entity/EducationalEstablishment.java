package com.sofy.studing.entity;

import java.util.Arrays;

public class EducationalEstablishment {
    private String name;
    private Groupe[] groupes;

    public EducationalEstablishment(String name, Groupe[] groupes) {
        this.name = name;
        this.groupes = groupes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Groupe[] getGroupes() {
        return groupes;
    }

    public void setGroupes(Groupe[] groupes) {
        this.groupes = groupes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EducationalEstablishment{");
        sb.append("name='").append(name).append('\'');
        sb.append(", groupes=").append(Arrays.toString(groupes));
        sb.append('}');
        return sb.toString();
    }
}
