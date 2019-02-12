package com.meowgoo.spmia.license.test;

import com.meowgoo.spmia.license.SpmiaLicenseApplication;
import com.meowgoo.spmia.license.model.License;
import com.meowgoo.spmia.license.model.Organization;
import com.meowgoo.spmia.license.services.LicenseService;
import com.meowgoo.spmia.license.services.OrganizationService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Kevin Han
 * @version 0.0.1
 * @Title: SpmiaLicenseApplicationTests
 * @ProjectName spmia
 * @date 2019/2/12 13:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpmiaLicenseApplication.class)
public class SpmiaLicenseApplicationTests {
    @Autowired
    private LicenseService licenseService;

    @Autowired
    private OrganizationService organizationService;

    @Before
    public void before() {
        System.out.println("TEST BEFORE RUNNING...");
    }

    @After
    public void after() {
        System.out.println("TEST AFTER RUNNING...");
    }

    @Test
    public void initOrganization() throws Exception {
        organizationService.save(new Organization("dba3c33a-d144-4d6d-a34b-738c3b2a1087", "Human Resources Department", "HR", "hr@meowgoo.com", "13888800001"));
        organizationService.save(new Organization("25e2ca8e-59db-4874-a36a-b5e85dcc7115", "Research and Development Department", "R&D", "rd@meowgoo.com", "13888800002"));
    }

    @Test
    public void initLicense() throws Exception {
        licenseService.save(new License("278b7dc0-401d-4cfe-8e77-8b6a1b39e972", "dba3c33a-d144-4d6d-a34b-738c3b2a1087", "standard", "USER", 100, 0, " "));
        licenseService.save(new License("c93beb09-000d-4272-a774-e45c32173e8d", "dba3c33a-d144-4d6d-a34b-738c3b2a1087", "advanced", "USER", 100, 4, " "));
        licenseService.save(new License("22e42112-09a1-444c-93af-26fee658dcba", "25e2ca8e-59db-4874-a36a-b5e85dcc7115", "vip", "USER", 100, 4, " "));
        licenseService.save(new License("8f35d3bb-7bce-49b4-9279-47b59bbab60d", "25e2ca8e-59db-4874-a36a-b5e85dcc7115", "user", "EMPLOYEE", 100, 4, " "));
        licenseService.save(new License("b58e3d79-0185-46af-96e6-99f90712dc34", "25e2ca8e-59db-4874-a36a-b5e85dcc7115", "employee", "EMPLOYEE", 100, 4, " "));
        licenseService.save(new License("6e6b40f6-b475-41eb-8fe0-eefd3278f193", "25e2ca8e-59db-4874-a36a-b5e85dcc7115", "administrator", "MANAGER", 100, 4, " "));
    }
}
