package lk.linex.emloyeems.service;

import jakarta.transaction.Transactional;
import lk.linex.emloyeems.dto.EmployeeDTO;
import lk.linex.emloyeems.entity.Employee;
import lk.linex.emloyeems.repo.EmployeeRepo;
import lk.linex.emloyeems.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
