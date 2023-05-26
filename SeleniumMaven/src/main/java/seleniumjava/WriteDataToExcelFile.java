package seleniumjava;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.testng.annotations.Test;
import java.io.FileOutputStream;
import java.io.IOException;


public class WriteDataToExcelFile {
	int k;
	String[] names= {"Uday","uday","iuDI","ihafbiF","IUDGFI","UVFUDVF","uuFDFV","JHJvFKJVF","HDFJLvdf","lidFGLfg","ilFGLIUgf","ildgfliGF","IHFgfliGFI","iudgfiDF","IHdflGVDDFLG","IUsdfilgSDFIUU","OUGdligDLIFG","IUgfilDDIU","IUGIOgfoiu","iufigsdifgsdf","iusdligDGSD","KDIUHSDDIUH","hsgoihiagh","ihgohago","kjsgiahg","oiHDipuhgadigu","hdgoahsd","ohgiagsi","o;iihsddoahsdg","oisdshfiaghd","iuhdiiahsg","shoahdsgoi","lhg;oahfg","klbdlkghasgh","ahgohagoih","ouhgohasogh","ohoghaofgh","oihgohaog","ohssgohafgoh","ohdgohasoghaso","oiihgohagh","kjsgiags","oiHohafgoh","kbzsg","kjbkgbasg","jhSglhdl","khsdkhdskh","oihfoAHF"};
	@Test
	public void writeDataToExcel() throws IOException
	{
		HSSFWorkbook workbook=new HSSFWorkbook();
		HSSFSheet sheet=workbook.createSheet("LoginDetails");
		for(int i=0;i<10;i++)
		{
		HSSFRow row=sheet.createRow(i);
		for(int j=0;j<4;j++)
		{
		HSSFCell cell=row.createCell(j);
		cell.setCellValue(names[k]);
		k++;
		}
		}
		File fos=new File("C:\\Users\\lenovo\\Desktop\\Excel files\\EnterLoginDetails.xls");
		workbook.write(fos);
	}

}
