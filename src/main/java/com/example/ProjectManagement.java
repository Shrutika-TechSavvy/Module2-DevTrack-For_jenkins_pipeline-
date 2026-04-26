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

    // ================= CREATE PROJECT =================
    public String createProject() {

        if (projectName == null || projectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be empty");
        }

        return projectName;
    }

    // ================= UPDATE STATUS =================
    public String updateProjectStatus(String newStatus) {

        // Allow null (as per your test case)
        if (newStatus == null) {
            this.status = null;
            return null;
        }

        this.status = newStatus;
        return status;
    }

    public String getStatus() {
        return status;
    }

    // ================= TEAM MANAGEMENT =================
    public int assignTeamMembers(int teamSize) {

        if (teamSize < 0) {
            throw new IllegalArgumentException("Team size cannot be negative");
        }

        this.teamSize = teamSize;
        return this.teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
