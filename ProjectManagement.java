package com.example;
public class ProjectManagement {

    private int projectId;
    private String projectName;
    private String status;
    private int teamSize;

    // Constructor
    public ProjectManagement(int projectId, String projectName, String status, int teamSize) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
        this.teamSize = teamSize;
    }

    // Create Project
    public String createProject() {
        if (projectName == null || projectName.isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }
        return projectName;
    }

    // Update Project Status
    public String updateProjectStatus(String newStatus) {
        this.status = newStatus;
        return this.status;
    }

    // Assign Team Members
    public int assignTeamMembers(int members) {
        if (members < 0) {
            throw new IllegalArgumentException("Invalid team size");
        }
        this.teamSize = members;
        return this.teamSize;
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public int getTeamSize() {
        return teamSize;
    }
}