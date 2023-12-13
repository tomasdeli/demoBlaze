package report;

import java.util.Calendar;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {
	/*** VARIABLES ***/
	private static final String type_file = ".html";
	
	private static Calendar date = Calendar.getInstance();
	private static int year = date.get(Calendar.YEAR);
	private static int month = date.get(Calendar.MONTH) + 1;
	private static int day = date.get(Calendar.DAY_OF_MONTH);
	private static int hour = date.get(Calendar.HOUR_OF_DAY);
	private static int minute = date.get(Calendar.MINUTE);
	private static int second = date.get(Calendar.SECOND);
	private static String dateFormatted = year + "-" + month + "-" + day + "-" + hour + ";" + minute + ";" + second;
	
	private static String report_name = "REPORT " + dateFormatted;
	
	private static String reports_path = "C:\\Users\\PC\\Desktop\\Documentos\\QA\\Workspace\\testProject\\src\\test\\resources\\reports\\" + report_name + "\\" + report_name + type_file;
	/*** REPORTS ***/
	private static ExtentReports report = new ExtentReports();
	private static ExtentSparkReporter spark = new ExtentSparkReporter(reports_path);
	
	/*** METHODS ***/
	public static ExtentReports configurate() {
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Report Test");
		
		report.attachReporter(spark);
		
		return report;
	}
}