package com.navitsa.Reports;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.navitsa.entity.VisualChecklistDetail;
import com.navitsa.entity.VisualChecklistMaster;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

@Component("xyz")
public class ChecklistReport extends AbstractView {

	private JasperReport ChecklistReport;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        List<VisualChecklistDetail> detailList = (List<VisualChecklistDetail>) model.get("audit");
        VisualChecklistMaster genaralData = (VisualChecklistMaster) model.get("genaral");
        
        //data source
        JRDataSource dataSource = getDataSource(detailList);
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

	private JasperReport getReport() throws JRException {
		// TODO Auto-generated method stub
		
		 if (ChecklistReport == null) {//compile only once lazily
			 
	            InputStream stream = getClass().getResourceAsStream("/checklistReport.jrxml");
	            ChecklistReport = JasperCompileManager.compileReport(stream);
	            
	        }
	        return ChecklistReport;
	}

	private JRDataSource getDataSource(List<VisualChecklistDetail> detailList) {
		// TODO Auto-generated method stub
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(detailList);
        return dataSource;
	}

}
