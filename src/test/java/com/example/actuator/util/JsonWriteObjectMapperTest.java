package com.example.actuator.util;

import com.example.actuator.dto.Address;
import com.example.actuator.dto.Employee;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JsonWriteObjectMapperTest {

    Employee emp = new Employee();
    @Before
    public void setUpEmployee() {
      Address address=new Address();
      address.setStreet("Lake Park Road");
      address.setCity("Phoenix");
      address.setZipCode(85003);
      emp.setId(124);
      emp.setName("Alice Celci");
      emp.setAge(24);
      emp.setSalary(new BigDecimal(1800));
      emp.setDesignation("UI Designer");
      emp.setAddress(address);
      emp.setPhoneNumbers(new long[]{246802});
      Map<String, String> infoMap = new HashMap<>();
      infoMap.put("gender", "Female");
      infoMap.put("maritialstatus", "Unmarried");
      emp.setPersonalInformation(infoMap);
    }

    @Test
    public void writeEmployeeToJsonWithObjectMapper() {
        JsonWriteObjectMapper jsonWriteObjectMapper = new JsonWriteObjectMapper();
        jsonWriteObjectMapper.witeEmployeeToJsonWithObjectMapper(emp);
    }
}