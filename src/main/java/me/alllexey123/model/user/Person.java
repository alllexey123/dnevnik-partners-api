package me.alllexey123.model.user;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Person {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private long userId;

    @SerializedName("userId_str")
    private String userIdStr;

    private String firstName;

    private String lastName;

    private String middleName;

    private String shortName;

    private String sex;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && userId == person.userId && Objects.equals(idStr, person.idStr) && Objects.equals(userIdStr, person.userIdStr) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(middleName, person.middleName) && Objects.equals(shortName, person.shortName) && Objects.equals(sex, person.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStr, userId, userIdStr, firstName, lastName, middleName, shortName, sex);
    }
}
