package com.meowgoo.spmia.license.services;

import com.meowgoo.spmia.license.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Kevin Han
 * @version 0.0.1
 * @Title: LicenseService
 * @ProjectName spmia
 * @date 2019/2/12 11:29
 */
public interface LicenseService extends JpaRepository<License, String> {
}
