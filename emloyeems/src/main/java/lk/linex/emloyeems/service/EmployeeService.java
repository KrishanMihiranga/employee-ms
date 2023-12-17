package lk.linex.emloyeems.service;

import jakarta.transaction.Transactional;
import lk.linex.emloyeems.dto.EmployeeDTO;
import lk.linex.emloyeems.entity.Employee;
import lk.linex.emloyeems.repo.EmployeeRepo;
import lk.linex.emloyeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ModelMapper modelMapper;

    public String saveEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(employeeDTO.getEmpId())){
            return VarList.RSP_DUPLICATED;
        }else {
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }
    }

    public String updateEmployee(EmployeeDTO employeeDTO){
        if (employeeRepo.existsById(employeeDTO.getEmpId())){
            employeeRepo.save(modelMapper.map(employeeDTO, Employee.class));
            return VarList.RSP_SUCCESS;
        }else {
            return VarList.RSP_NO_DATA_FOUND;
        }
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList =  employeeRepo.findAll();
        return modelMapper.map(employeeList, new TypeToken<ArrayList<EmployeeDTO>>(){}.getType());
    }

    public EmployeeDTO searchEmployee(int empId){
        if(employeeRepo.existsById(empId)){
            Employee employee = employeeRepo.findById(empId).orElse(null);
            return modelMapper.map(employee, EmployeeDTO.class);
        }else{
            return null;
        }
    }
    public String deleteEmployee(int empId){
        if(employeeRepo.existsById(empId)){
            employeeRepo.deleteById(empId);
            return VarList.RSP_SUCCESS;
        }else{
            return VarList.RSP_NO_DATA_FOUND;
        }
    }
}
