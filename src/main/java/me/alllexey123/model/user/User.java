package me.alllexey123.model.user;

import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;

public class User {

    private long id;

    @SerializedName("id_str")
    private String idStr;

    private long personId;

    @SerializedName("personId_str")
    private String personIdStr;

    private String name;

    private String email;

    private String login;

    private String fullName;

    private String middleName;

    private String lastName;

    private String shortName;

    private String locale;

    private String timezone;

    private String sex;

    private String photoSmall;

    private String photoMedium;

    private String photoLarge;

    private OffsetDateTime birthday;

    private List<Role> roles;

    private String phone;

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

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonIdStr() {
        return personIdStr;
    }

    public void setPersonIdStr(String personIdStr) {
        this.personIdStr = personIdStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(String photoSmall) {
        this.photoSmall = photoSmall;
    }

    public String getPhotoMedium() {
        return photoMedium;
    }

    public void setPhotoMedium(String photoMedium) {
        this.photoMedium = photoMedium;
    }

    public String getPhotoLarge() {
        return photoLarge;
    }

    public void setPhotoLarge(String photoLarge) {
        this.photoLarge = photoLarge;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(OffsetDateTime birthday) {
        this.birthday = birthday;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && personId == user.personId && Objects.equals(idStr, user.idStr) && Objects.equals(personIdStr, user.personIdStr) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(login, user.login) && Objects.equals(fullName, user.fullName) && Objects.equals(middleName, user.middleName) && Objects.equals(lastName, user.lastName) && Objects.equals(shortName, user.shortName) && Objects.equals(locale, user.locale) && Objects.equals(timezone, user.timezone) && Objects.equals(sex, user.sex) && Objects.equals(photoSmall, user.photoSmall) && Objects.equals(photoMedium, user.photoMedium) && Objects.equals(photoLarge, user.photoLarge) && Objects.equals(birthday, user.birthday) && Objects.equals(roles, user.roles) && Objects.equals(phone, user.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idStr, personId, personIdStr, name, email, login, fullName, middleName, lastName, shortName, locale, timezone, sex, photoSmall, photoMedium, photoLarge, birthday, roles, phone);
    }
}
