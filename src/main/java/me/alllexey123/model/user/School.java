package me.alllexey123.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class School {

    private String fullName;

    private String avatarSmall;

    private String city;

    private String municipality;

    private int regionId;

    private String markType;

    private int timeZone;

    @SerializedName("uses_avg")
    private boolean usesAvg;

    @SerializedName("uses_weighted_avg")
    private boolean usesWeightedAvg;

    private int id;

    @SerializedName("id_str")
    private String idStr;

    private String name;

    private String educationType;

    private String tsoRegionTreePath;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarSmall() {
        return avatarSmall;
    }

    public void setAvatarSmall(String avatarSmall) {
        this.avatarSmall = avatarSmall;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getMarkType() {
        return markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
    }

    public int getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(int timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isUsesAvg() {
        return usesAvg;
    }

    public void setUsesAvg(boolean usesAvg) {
        this.usesAvg = usesAvg;
    }

    public boolean isUsesWeightedAvg() {
        return usesWeightedAvg;
    }

    public void setUsesWeightedAvg(boolean usesWeightedAvg) {
        this.usesWeightedAvg = usesWeightedAvg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getTsoRegionTreePath() {
        return tsoRegionTreePath;
    }

    public void setTsoRegionTreePath(String tsoRegionTreePath) {
        this.tsoRegionTreePath = tsoRegionTreePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return regionId == school.regionId && timeZone == school.timeZone && usesAvg == school.usesAvg && usesWeightedAvg == school.usesWeightedAvg && id == school.id && Objects.equals(fullName, school.fullName) && Objects.equals(avatarSmall, school.avatarSmall) && Objects.equals(city, school.city) && Objects.equals(municipality, school.municipality) && Objects.equals(markType, school.markType) && Objects.equals(idStr, school.idStr) && Objects.equals(name, school.name) && Objects.equals(educationType, school.educationType) && Objects.equals(tsoRegionTreePath, school.tsoRegionTreePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, avatarSmall, city, municipality, regionId, markType, timeZone, usesAvg, usesWeightedAvg, id, idStr, name, educationType, tsoRegionTreePath);
    }
}
