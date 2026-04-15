package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProjectManagementTest {

    ProjectManagement project =
            new ProjectManagement(1, "DevTrack", "Not Started", 0);

    // Test Project Creation
    @Test
    public void testCreateProject() {
        assertEquals("DevTrack", project.createProject());
    }

    // Test Status Update
    @Test
    public void testUpdateProjectStatus() {
        String status = project.updateProjectStatus("In Progress");
        assertEquals("In Progress", status);
    }

    // Test Assign Team Members
    @Test
    public void testAssignTeamMembers() {
        int size = project.assignTeamMembers(4);
        assertEquals(4, size);
    }

    // Edge Case: Invalid Team Size
    @Test
    public void testInvalidTeamMembers() {
        assertThrows(IllegalArgumentException.class, () -> {
            project.assignTeamMembers(-2);
        });
    }

    // Edge Case: Empty Project Name
    @Test
    public void testEmptyProjectName() {
        ProjectManagement p =
                new ProjectManagement(2, "", "Not Started", 0);

        assertThrows(IllegalArgumentException.class, () -> {
            p.createProject();
        });
    }
}