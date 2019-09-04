package org.lanqiao.jd.entity;


public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String telephone;

    private String sex;

    private String email;

    private String idcard;

    private boolean userStatus;

    public User() {
    }

    public User(String userName, boolean userStatus) {
        this.userName = userName;
        this.userStatus = userStatus;
    }

    public User(String email, boolean userStatus, String nullValue) {
        this.email = email;
        this.userStatus = userStatus;
    }

    public User(String telephone, boolean userStatus, int nullValue) {
        this.telephone = telephone;
        this.userStatus = userStatus;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String email, int emailnullValue) {
        this.email = email;
    }

    public User(String telephone, String telenullValue) {
        this.telephone = telephone;
    }

    public User(String userName, String password, String telephone, String email) {
        this.userName = userName;
        this.password = password;
        this.telephone = telephone;
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", idcard='" + idcard + '\'' +
                ", userStatus='" + userStatus + '\'' +
                '}';
    }
}