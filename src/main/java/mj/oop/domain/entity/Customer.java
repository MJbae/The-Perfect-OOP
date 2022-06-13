package mj.oop.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("Customer")
public class Customer extends User {
    private String customerGrade;

    @Builder
    public Customer(Long id, String name, String email, String password, String customerGrade) {
        super(id, name, email, password);
        this.customerGrade = customerGrade;
    }

    @Builder
    public Customer(String name, String email, String password, String customerGrade) {
        super(name, email, password);
        this.customerGrade = customerGrade;
    }
}
