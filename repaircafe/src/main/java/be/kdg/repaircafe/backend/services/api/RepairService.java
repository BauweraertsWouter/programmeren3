/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.kdg.repaircafe.backend.services.api;

import be.kdg.repaircafe.backend.dom.repairs.Repair;
import be.kdg.repaircafe.backend.dom.repairs.RepairDetails;
import be.kdg.repaircafe.backend.persistence.criteria.SearchCriterium;
import be.kdg.repaircafe.backend.services.exceptions.RepairServiceException;
import be.kdg.repaircafe.backend.services.exceptions.UserServiceException;

import java.util.List;

/**
 * @author wouter
 */
public interface RepairService
{
    // https://programmeren3-repaircafe.rhcloud.com/repair-cafe-applicatie/repair-cafe-backend/backend-service-layer/

    Repair findRepairById(Integer repairId) throws RepairServiceException;

    List<Repair> findAll();

    List<Repair> findRepairsByUserId(Integer userId) throws UserServiceException;

    List<Repair> findRepairsByCriteria(List<SearchCriterium> searchCriteriums) throws RepairServiceException;

    Repair saveRepair(Integer userId, Repair repair) throws UserServiceException;

    Repair updateRepair(Repair repair);

    void deleteRepair(Integer repairId) throws RepairServiceException;

    void updateRepairStatus(Integer repairId, RepairDetails.Status newStatus);

}
