package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Project Management Test Suite")
public class ProjectManagementTest {

    ProjectManagement project;

    // Runs before each test
    @BeforeEach
    void setUp() {
        project = new ProjectManagement(1, "DevTrack", "Not Started", 0);
    }

    // ========================= CREATE PROJECT =========================
    @Nested
    @DisplayName("Create Project Tests")
    class CreateProjectTests {

        @Test
        @DisplayName("Valid project creation")
        void testCreateProjectValid() {
            assertEquals("DevTrack", project.createProject());
        }

        @Test
        @DisplayName("Empty project name should throw exception")
        void testEmptyProjectName() {
            ProjectManagement p = new ProjectManagement(2, "", "Not Started", 0);
            assertThrows(IllegalArgumentException.class, p::createProject);
        }

        @Test
        @DisplayName("Null project name should throw exception")
        void testNullProjectName() {
            ProjectManagement p = new ProjectManagement(3, null, "Not Started", 0);
            assertThrows(IllegalArgumentException.class, p::createProject);
        }

        @Test
        @DisplayName("Check project name not empty using assertFalse")
        void testProjectNameNotEmpty() {
            assertFalse(project.createProject().isEmpty());
        }
    }

    // ========================= STATUS =========================
    @Nested
    @DisplayName("Project Status Tests")
    class StatusTests {

        @Test
        @DisplayName("Update status correctly")
        void testUpdateStatus() {
            String status = project.updateProjectStatus("In Progress");
            assertEquals("In Progress", status);
        }

        @Test
        @DisplayName("Check status getter")
        void testGetStatus() {
            project.updateProjectStatus("Completed");
            assertEquals("Completed", project.getStatus());
        }

        @Test
        @DisplayName("Check status is not empty using assertTrue")
        void testStatusNotEmpty() {
            project.updateProjectStatus("In Progress");
            assertTrue(project.getStatus().length() > 0);
        }

        @ParameterizedTest
        @ValueSource(strings = {"In Progress", "Completed", "On Hold"})
        @DisplayName("Multiple status values test")
        void testMultipleStatuses(String input) {
            assertEquals(input, project.updateProjectStatus(input));
        }

        @Test
        @DisplayName("Null status update")
        void testNullStatusUpdate() {
            String status = project.updateProjectStatus(null);
            assertNull(status);
        }
    }

    // ========================= TEAM =========================
    @Nested
    @DisplayName("Team Assignment Tests")
    class TeamTests {

        @Test
        @DisplayName("Valid team assignment")
        void testAssignTeam() {
            assertEquals(5, project.assignTeamMembers(5));
        }

        @Test
        @DisplayName("Zero team members allowed")
        void testZeroTeam() {
            assertEquals(0, project.assignTeamMembers(0));
        }

        @Test
        @DisplayName("Negative team size should throw exception")
        void testNegativeTeam() {
            assertThrows(IllegalArgumentException.class,
                    () -> project.assignTeamMembers(-1));
        }

        @Test
        @DisplayName("Check team size getter")
        void testTeamGetter() {
            project.assignTeamMembers(3);
            assertEquals(3, project.getTeamSize());
        }

        @Test
        @DisplayName("Boundary test for large team size")
        void testLargeTeamSize() {
            assertEquals(1000, project.assignTeamMembers(1000));
        }

        @Test
        @DisplayName("Loop test for multiple team sizes")
        void testMultipleTeamSizesLoop() {
            for (int i = 0; i <= 5; i++) {
                int result = project.assignTeamMembers(i);
                assertEquals(i, result);
            }
        }

        @Test
        @DisplayName("Check team size using assertTrue")
        void testTeamSizePositive() {
            project.assignTeamMembers(2);
            assertTrue(project.getTeamSize() > 0);
        }
    }

    // ========================= WORKFLOW =========================
    @Test
    @DisplayName("Full workflow test")
    void testFullWorkflow() {

        assertAll("Workflow Test",
                () -> assertEquals("DevTrack", project.createProject()),
                () -> assertEquals("In Progress",
                        project.updateProjectStatus("In Progress")),
                () -> assertEquals(4, project.assignTeamMembers(4))
        );
    }
}
