package com.tmu.amic.controller.response;

import com.tmu.amic.model.Project;
import com.tmu.amic.model.UserAccount;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserAccountResponse {

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private boolean isProjectManager;

    private Date createdAt;

    private Date updatedAt;

    public UserAccountResponse() {
    }

    public UserAccountResponse(String username, String password, String email, String firstName, String lastName, boolean isProjectManager, Date createdAt, Date updatedAt) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isProjectManager = isProjectManager;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public boolean isProjectManager() {
        return isProjectManager;
    }

    public void setProjectManager(boolean projectManager) {
        isProjectManager = projectManager;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccountResponse)) return false;
        UserAccountResponse that = (UserAccountResponse) o;
        return isProjectManager() == that.isProjectManager() &&
                Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                Objects.equals(getFirstName(), that.getFirstName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(getCreatedAt(), that.getCreatedAt()) &&
                Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public String toString() {
        return "UserAccountResponse{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isProjectManager=" + isProjectManager +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getEmail(), getFirstName(), getLastName(), isProjectManager(), getCreatedAt(), getUpdatedAt());
    }

    public UserAccountResponse convertToResponse(UserAccount userAccount) {
        UserAccountResponse userAccountResponse = new UserAccountResponse();
        userAccountResponse.setUsername(userAccount.getUsername());
        userAccountResponse.setPassword(userAccount.getPassword());
        userAccountResponse.setEmail(userAccount.getEmail());
        userAccountResponse.setFirstName(userAccount.getFirstName());
        userAccountResponse.setLastName(userAccount.getLastName());
        userAccountResponse.setProjectManager(userAccount.isProjectManager());
        userAccountResponse.setCreatedAt(userAccount.getCreatedAt());
        userAccountResponse.setUpdatedAt(userAccount.getUpdatedAt());
        return userAccountResponse;
    }

    public List<UserAccountResponse> convertToList(List<UserAccount> userAccountsList) {
        List<UserAccountResponse> responseList = new ArrayList<>();
        for (UserAccount userAccount : userAccountsList) {
            responseList.add(convertToResponse(userAccount));
        }
        return responseList;
    }
}
