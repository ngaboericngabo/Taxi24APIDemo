package com.bk.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bk.model.Invoice;

	/**
	 * @author Eric
	 *
	 */
	@Repository
	public interface  IInvoice  extends JpaRepository <Invoice, Long> {
		
}
