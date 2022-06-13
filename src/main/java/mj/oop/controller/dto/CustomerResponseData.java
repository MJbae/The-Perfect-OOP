package mj.oop.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mj.oop.domain.entity.Customer;


@Getter
public class CustomerResponseData extends UserResponseData {
    private String customerGrade;

    @JsonCreator
    public CustomerResponseData(@JsonProperty("id") Long id, @JsonProperty("name") String name,
                                @JsonProperty("email") String email, @JsonProperty("password") String password,
                                @JsonProperty("customerGrade") String customerGrade) {
        super(id, name, email, password);
        this.customerGrade = customerGrade;
    }


    public static CustomerResponseData from(Customer user) {
        return new CustomerResponseData(user.getId(), user.getName(), user.getEmail(),
                user.getPassword(), user.getCustomerGrade());
    }
}
