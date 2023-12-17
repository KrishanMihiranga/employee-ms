package lk.linex.emloyeems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue indicates that the value for the primary key will be generated automatically.
    private int empId;
    private String empName;
    private String empAddress;
    private String mNumber;
}

