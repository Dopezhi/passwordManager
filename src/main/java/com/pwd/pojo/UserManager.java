package com.pwd.pojo;

public class UserManager {
    private Integer id;

    private Integer managerId;

    private String managerName;

    private String managerPwd;

    private String managerEmail;

    private String managerQuestion;

    private String managerAnswer;

    private Integer managerRole;

    public UserManager(Integer id, Integer managerId, String managerName, String managerPwd, String managerEmail, String managerQuestion, String managerAnswer, Integer managerRole) {
        this.id = id;
        this.managerId = managerId;
        this.managerName = managerName;
        this.managerPwd = managerPwd;
        this.managerEmail = managerEmail;
        this.managerQuestion = managerQuestion;
        this.managerAnswer = managerAnswer;
        this.managerRole = managerRole;
    }

    public UserManager() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd == null ? null : managerPwd.trim();
    }

    public String getManagerEmail() {
        return managerEmail;
    }

    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail == null ? null : managerEmail.trim();
    }

    public String getManagerQuestion() {
        return managerQuestion;
    }

    public void setManagerQuestion(String managerQuestion) {
        this.managerQuestion = managerQuestion == null ? null : managerQuestion.trim();
    }

    public String getManagerAnswer() {
        return managerAnswer;
    }

    public void setManagerAnswer(String managerAnswer) {
        this.managerAnswer = managerAnswer == null ? null : managerAnswer.trim();
    }

    public Integer getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(Integer managerRole) {
        this.managerRole = managerRole;
    }
}