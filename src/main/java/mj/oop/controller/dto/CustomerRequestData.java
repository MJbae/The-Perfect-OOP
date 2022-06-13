package mj.oop.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import mj.oop.controller.validator.Password;
import mj.oop.domain.entity.Customer;


@Getter
public class CustomerRequestData extends UserRequestData {
    @Password
    private final String customerGrade;

    @Builder
    @JsonCreator
    public CustomerRequestData(@JsonProperty("name") String name, @JsonProperty("email") String email,
                               @JsonProperty("password") String password, @JsonProperty("customerGrade") String customerGrade) {
        super(name, email, password);
        this.customerGrade = customerGrade;
    }

    public Customer toEntity() {
        return Customer.builder()
                .name(getName())
                .email(getEmail())
                .password(getPassword())
                .customerGrade(getCustomerGrade())
                .build();
    }
}
