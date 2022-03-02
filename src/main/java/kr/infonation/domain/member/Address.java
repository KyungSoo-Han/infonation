package kr.infonation.domain.member;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String zipCode;
    private String zipAddr1;
    private String zipAddr2;

    //JPA 스펙상 만들어 놓은 것(@Entity, @Embeddable 등)
    public Address() {

    }

    public Address(String zipCode, String zipAddr1, String zipAddr2) {
        this.zipCode = zipCode;
        this.zipAddr1 = zipAddr1;
        this.zipAddr2 = zipAddr2;
    }

}
