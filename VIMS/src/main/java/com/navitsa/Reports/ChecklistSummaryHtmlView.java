package com.navitsa.Reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component("abc")
public class ChecklistSummaryHtmlView extends AbstractView {

	private JasperReport ChecklistReport;

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        List<ChecklistSummaryBean> list = (List<ChecklistSummaryBean>) model.get("cheklistSummary");
        
        //data source
        JRDataSource dataSource = getDataSource(list);
        //compile jrxml template and get report
        JasperReport report = getReport();
        //fill the report with data source objects
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, dataSource);
        
        //export to html
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
		
	}
	
	private JRDataSource getDataSource(List<ChecklistSummaryBean> list) {
		// TODO Auto-generated method stub
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(list);
        return dataSource;
	}

	private JasperReport getReport() throws JRException {
		// TODO Auto-generated method stub
		 if (ChecklistReport == null) {//compile only once lazily
	            InputStream stream = getClass().getResourceAsStream("/checklistTempReport.jrxml");
	            ChecklistReport = JasperCompileManager.compileReport(stream);
	        }
	        return ChecklistReport;
	}

}
