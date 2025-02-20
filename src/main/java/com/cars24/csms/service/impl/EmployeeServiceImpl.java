//ERRORS HERE NEED TO BE RESOLVED


package com.cars24.csms.service.impl;
import com.cars24.csms.data.dao.Impl.AppUserDoaImpl;
import com.cars24.csms.data.dao.Impl.EmployeeDaoImp;
import com.cars24.csms.data.resp.APIResponse;
import com.cars24.csms.data.resp.CreateEmployeeResponse;
import com.cars24.csms.exceptions.UserServiceException;
import com.cars24.csms.data.req.CreateEmployeeRequest;
import com.cars24.csms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDaoImp employeeDao;
    private final AppUserDoaImpl appUserDetailsDao;

    public ResponseEntity<APIResponse> createEmployee(CreateEmployeeRequest createEmployeeReq) {
        log.info("[createEmployee] IN SERVICE {}",createEmployeeReq);
        APIResponse apiRes = new APIResponse();
        boolean userExists = appUserDetailsDao.checkIfUserExists(createEmployeeReq.getEmail());
        log.info("[createEmployee] IN SERVICE userExists: {}",userExists);
        if(userExists){
            boolean userInEmployee = employeeDao.checkIfEmailExists(createEmployeeReq.getEmail());
            log.info("[createEmployee] IN SERVICE userInEmployee: {}",userInEmployee);

            if(!userInEmployee){
                apiRes.setStatus(HttpStatus.OK.value());
                apiRes.setSuccess(true);
                apiRes.setMessage("Profile creation Successful!");
                apiRes.setData(null);
                apiRes.setService("APP_USER - " + HttpStatus.OK.value());
                int userId = appUserDetailsDao.getUserId(createEmployeeReq.getEmail());
                employeeDao.createEmployee(createEmployeeReq, userId);
            }
            else {
                throw new UserServiceException("Profile already exists!");
            }
        }
        else {
            throw new UserServiceException("User does not exist!");
        }
        //        employeeDao.createEmployee(createEmployeeReq);
        return ResponseEntity.ok().body(apiRes);
    }


    @Override
    public CreateEmployeeResponse getEmployeeById(int id) {

        return employeeDao.getEmployeeById(id)
                .orElseThrow(() -> new UserServiceException("Employee with ID " + id + " not found!"));
    }



}
