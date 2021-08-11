package com.navitsa.hrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.navitsa.hrm.entity.PartnerBankAccount;

public interface PartnerBankAccountRepository  extends CrudRepository<PartnerBankAccount, String>{

	@Query(value = "SELECT b FROM PartnerBankAccount b WHERE b.branchID.bankid.bankid=:bankid")
	public List<PartnerBankAccount> getBankAccountByBank(@Param("bankid") String bankid);
		
}
