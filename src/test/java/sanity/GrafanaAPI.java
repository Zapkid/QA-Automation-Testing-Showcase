package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;

//@Listeners(utilities.Listeners.class)
public class GrafanaAPI extends CommonOps {

    @Test(description = "Test 01: Get Team From Grafana")
    @Description("This Test Verify Team Property")
    public void test01_verifyTeam() {
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[0].name"), "Kuku Group");
    }

    @Test(description = "Test 02: Add Team And Verify")
    @Description("This Test Adds a Team to Grafana and Verify it")
    public void test02_addTeamAndVerify() {
        ApiFlows.postTeam("YoniTeam", "yoni@team.com");
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].name"), "YoniTeam");
    }

    @Test(description = "Test 03: Update Team And Verify")
    @Description("This Test Updates a Team in Grafana and Verify it")
    public void test03_updateTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.updateTeam("YoniTeam", "yoni@atidcollege.co.il", id);
        Verifications.verifyText(ApiFlows.getTeamProperty("teams[1].email"), "yoni@atidcollege.co.il");
    }

    @Test(description = "Test 04: Delete Team And Verify")
    @Description("This Test Deletes a Team in Grafana and Verify it")
    public void test04_deleteTeamAndVerify() {
        String id = ApiFlows.getTeamProperty("teams[1].id");
        ApiFlows.deleteTeam(id);
        Verifications.verifyText(ApiFlows.getTeamProperty("totalCount"), "1");
    }
}
