package com.project.fixedasset.repositories;

import com.project.fixedasset.FinancialInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Financial_information_repo extends JpaRepository<FinancialInformation, Long> {
}
