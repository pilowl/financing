package com.klix.financing.domain.bankapplication.mapper;

import org.mapstruct.Mapper;

import com.klix.financing.domain.bankapplication.model.BankName;
import com.klix.financing.domain.bankapplication.repository.entity.Bank;

@Mapper(componentModel = "spring")
public interface BankApplicationMapper {
    BankName mapBankEntityToBankName(Bank bank);
}
