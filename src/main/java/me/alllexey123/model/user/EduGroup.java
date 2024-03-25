package me.alllexey123.model.user;

import com.google.gson.annotations.SerializedName;
import me.alllexey123.model.work.Subject;

import java.util.List;
import java.util.Objects;

public class EduGroup {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private List<Long> parentIds;

    @SerializedName("parentIds_str")
    private List<String> parentIdsStr;

    private String type;

    private String name;

    private String fullName;

    private int parallel;

    private long timetable;

    @SerializedName("timetable_str")
    private String timetableStr;

    private String status;

    @SerializedName("studyyear")
    private int studyYear;

    private List<Subject> subjects;

    private String journalType;

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

    public List<Long> getParentIds() {
        return parentIds;
    }

    public void setParentIds(List<Long> parentIds) {
        this.parentIds = parentIds;
    }

    public List<String> getParentIdsStr() {
        return parentIdsStr;
    }

    public void setParentIdsStr(List<String> parentIdsStr) {
        this.parentIdsStr = parentIdsStr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getParallel() {
        return parallel;
    }

    public void setParallel(int parallel) {
        this.parallel = parallel;
    }

    public long getTimetable() {
        return timetable;
    }

    public void setTimetable(long timetable) {
        this.timetable = timetable;
    }

    public String getTimetableStr() {
        return timetableStr;
    }

    public void setTimetableStr(String timetableStr) {
        this.timetableStr = timetableStr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getJournalType() {
        return journalType;
    }

    public void setJournalType(String journalType) {
        this.journalType = journalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EduGroup eduGroup = (EduGroup) o;
        return id == eduGroup.id && parallel == eduGroup.parallel && timetable == eduGroup.timetable && studyYear == eduGroup.studyYear && Objects.equals(idStr, eduGroup.idStr) && Objects.equals(parentIds, eduGroup.parentIds) && Objects.equals(parentIdsStr, eduGroup.parentIdsStr) && Objects.equals(type, eduGroup.type) && Objects.equals(name, eduGroup.name) && Objects.equals(fullName, eduGroup.fullName) && Objects.equals(timetableStr, eduGroup.timetableStr) && Objects.equals(status, eduGroup.status) && Objects.equals(subjects, eduGroup.subjects) && Objects.equals(journalType, eduGroup.journalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStr, parentIds, parentIdsStr, type, name, fullName, parallel, timetable, timetableStr, status, studyYear, subjects, journalType);
    }
}
