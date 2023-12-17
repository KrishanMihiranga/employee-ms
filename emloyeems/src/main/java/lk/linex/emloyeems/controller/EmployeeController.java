package lk.linex.emloyeems.controller;

import lk.linex.emloyeems.dto.EmployeeDTO;
import lk.linex.emloyeems.dto.ResponseDTO;
import lk.linex.emloyeems.service.EmployeeService;
import lk.linex.emloyeems.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ResponseDTO responseDTO;

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO){
            try {
                String res = employeeService.saveEmployee(employeeDTO);
                if (res.equals("00")){
                    responseDTO.setCode(VarList.RSP_SUCCESS);
                    responseDTO.setMessage("Success");
                    responseDTO.setContent(employeeDTO);
                    return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
                }else if(res.equals("06")){
                    responseDTO.setCode(VarList.RSP_DUPLICATED);
                    responseDTO.setMessage("Employee Registered");
                    responseDTO.setContent(employeeDTO);
                    return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
                }else{
                    responseDTO.setCode(VarList.RSP_FAIL);
                    responseDTO.setMessage("Error");
                    responseDTO.setContent(null);
                    return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
                }
            }catch (Exception e){
                responseDTO.setCode(VarList.RSP_ERROR);
                responseDTO.setMessage(e.getMessage());
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }

    @PutMapping(value = "/updateEmployee")
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        try {
            String res = employeeService.updateEmployee(employeeDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }else if(res.equals("01")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("NOT A Registered Employee");
                responseDTO.setContent(employeeDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else{
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
