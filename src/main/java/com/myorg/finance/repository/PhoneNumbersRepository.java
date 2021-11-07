package com.myorg.finance.repository;

import com.myorg.finance.entity.PhoneNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumbersRepository  extends JpaRepository<PhoneNumberEntity,Long> {
}
