package data;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

public class Data {
	/*** VARIABLES ***/
	private static final String base_path = "C:\\Users\\PC\\Desktop\\Documentos\\QA\\Workspace\\testProject\\src\\test\\resources\\data";

	/*** METHODS ***/
	// Read Excel
	public Object[][] data(String path, String sheet) {
		new ExcelUtils(path, sheet);

		int rowCount = ExcelUtils.getRowCount();
		int colCount = ExcelUtils.getColCount();

		Object dt[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = ExcelUtils.getCellData(i, j);

				dt[i - 1][j] = cellData;
			}
		}

		return dt;
	}

	// Login Cases
	@DataProvider(name = "Login")
	public Object[][] getDataLogin() {
		String path = "\\login\\login.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}

	@DataProvider(name = "LoginUsernameIncorrect")
	public Object[][] getDataLoginUsrIncorrect() {
		String path = "\\login\\loginUsernameIncorrect.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}
	
	@DataProvider(name = "LoginPasswordIncorrect")
	public Object[][] getDataLoginPassIncorrect() {
		String path = "\\login\\loginPasswordIncorrect.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}
	
	@DataProvider(name = "LoginUsernameOrPasswordNull")
	public Object[][] getDataLoginUsrOrPassNull() {
		String path = "\\login\\loginUsernameOrPasswordNull.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}

	// Register Cases
	@DataProvider(name = "Register")
	public Object[][] getDataRegister() {
		String path = "\\register\\register.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}

	@DataProvider(name = "RegisterUsernameExistent")
	public Object[][] getDataRegisterUsrExistent() {
		String path = "\\register\\registerUsernameExistent.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}
	
	@DataProvider(name = "RegisterUsernameOrPasswordNull")
	public Object[][] getDataRegisterUsrOrPassNull() {
		String path = "\\register\\registerUsernameOrPasswordNull.xlsx";
		Object dt[][] = data(base_path + path, "Data");

		return dt;
	}
}
