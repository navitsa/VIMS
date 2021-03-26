package com.navitsa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "test_wise_print")
public class TestWisePrintOrder {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private int id;

	@EmbeddedId
	private Ck_testWisePrintOrderId ck_testWisePrintOrderId;
	
	@Column(name="report_path")
	private String reportPath;
	
	@Column(name="printing_order")
	private int printingOrder;

	public Ck_testWisePrintOrderId getCk_testWisePrintOrderId() {
		return ck_testWisePrintOrderId;
	}

	public void setCk_testWisePrintOrderId(Ck_testWisePrintOrderId ck_testWisePrintOrderId) {
		this.ck_testWisePrintOrderId = ck_testWisePrintOrderId;
	}

	public String getReportPath() {
		return reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public int getPrintingOrder() {
		return printingOrder;
	}

	public void setPrintingOrder(int printingOrder) {
		this.printingOrder = printingOrder;
	}

	public TestWisePrintOrder(Ck_testWisePrintOrderId ck_testWisePrintOrderId, String reportPath, int printingOrder) {
		super();
		this.ck_testWisePrintOrderId = ck_testWisePrintOrderId;
		this.reportPath = reportPath;
		this.printingOrder = printingOrder;
	}

	public TestWisePrintOrder() {
		super();
	}
	
}
