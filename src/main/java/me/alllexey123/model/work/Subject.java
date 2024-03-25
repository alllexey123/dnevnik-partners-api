package me.alllexey123.model.work;

import java.util.Objects;

public class Subject {

    private long id;

    private String idStr;

    private String name;

    private String knowledgeArea;

    private Long fgosSubjectId;

    private Long espSubjectName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnowledgeArea() {
        return knowledgeArea;
    }

    public void setKnowledgeArea(String knowledgeArea) {
        this.knowledgeArea = knowledgeArea;
    }

    public Long getFgosSubjectId() {
        return fgosSubjectId;
    }

    public void setFgosSubjectId(Long fgosSubjectId) {
        this.fgosSubjectId = fgosSubjectId;
    }

    public Long getEspSubjectName() {
        return espSubjectName;
    }

    public void setEspSubjectName(Long espSubjectName) {
        this.espSubjectName = espSubjectName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id == subject.id && Objects.equals(idStr, subject.idStr) && Objects.equals(name, subject.name) && Objects.equals(knowledgeArea, subject.knowledgeArea) && Objects.equals(fgosSubjectId, subject.fgosSubjectId) && Objects.equals(espSubjectName, subject.espSubjectName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStr, name, knowledgeArea, fgosSubjectId, espSubjectName);
    }
}
