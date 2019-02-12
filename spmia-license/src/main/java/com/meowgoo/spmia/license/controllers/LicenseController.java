package com.meowgoo.spmia.license.controllers;

import com.meowgoo.spmia.license.model.License;
import com.meowgoo.spmia.license.model.Organization;
import com.meowgoo.spmia.license.services.LicenseService;
import com.meowgoo.spmia.license.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Kevin Han
 * @version 0.0.1
 * @Title: LicenseController
 * @ProjectName spmia
 * @date 2019/1/21 11:23
 */
@RestController
@RequestMapping(value = "/organization/{organizationId}/license")
public class LicenseController {
    @Autowired
    private LicenseService licenseService;

    @Autowired
    private OrganizationService organizationService;

    @PostMapping(value = "/")
    public License postStandard(@RequestBody License license) {
        try {
            license.setId(UUID.randomUUID().toString());
            license = licenseService.save(license);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

    @PutMapping(value = "/")
    public License putStandard(@RequestBody License license) {
        try {
            if (null == licenseService.findById(license.getId()).orElse(null)) {
                return null;
            }
            license = licenseService.save(license);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license;
    }

    @DeleteMapping(value = "/{id}")
    public Boolean delStandard(@PathVariable String id) {
        try {
            licenseService.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping(value = "/list")
    public List<License> getLicenseList() {
        List<License> licenseList = null;
        try {
            licenseList = licenseService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return licenseList;
    }

    @GetMapping(value = "/{licenseId}")
    public License getLicenseList(
            @PathVariable("organizationId") String organizationId,
            @PathVariable("licenseId") String licenseId) {
        Optional<License> license = null;
        Optional<Organization> organization = null;
        try {
            license = licenseService.findById(licenseId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return license.orElse(null);
    }


}
