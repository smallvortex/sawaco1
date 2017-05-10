package com.vnet.sms.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.sun.media.sound.InvalidFormatException;
import com.vnet.sms.common.constant.VnetConstant;

public class ReadExcelFile {
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
    public static Vector ReadCSV(String fileName) {
        Vector cellVectorHolder = new Vector();

        try {
            FileInputStream myInput = new FileInputStream(fileName);

            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(0);

            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector cellStoreVector = new Vector();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    cellStoreVector.addElement(myCell);
                }
                cellVectorHolder.addElement(cellStoreVector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }
/**
 * 
 * @param fileName
 * @param sheetIndex
 * @return
 */
    public static Vector ReadCSV(String fileName, int sheetIndex) {
        Vector cellVectorHolder = new Vector();

        try {
            FileInputStream myInput = new FileInputStream(fileName);

            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

            HSSFSheet mySheet = myWorkBook.getSheetAt(sheetIndex);

            Iterator rowIter = mySheet.rowIterator();

            while (rowIter.hasNext()) {
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector cellStoreVector = new Vector();
                while (cellIter.hasNext()) {
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    cellStoreVector.addElement(myCell);
                }
                cellVectorHolder.addElement(cellStoreVector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellVectorHolder;
    }
/**
 * 
 * @param firstRow
 * @return
 */
    public static Map<String, Integer> getIndexesOfColumnNamesNew(Row firstRow) {
        Map<String, Integer> indexesOfColumnNames = new HashMap<String, Integer>();
        try {
            Iterator cellIter = firstRow.cellIterator();

            while (cellIter.hasNext()) {
                Cell myCell = (Cell) cellIter.next();
                int columnIndex = myCell.getColumnIndex();
                String columnName = myCell.getStringCellValue();
                indexesOfColumnNames.put(columnName, columnIndex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexesOfColumnNames;
    }

   /**
    * 
    * @param firstRow
    * @return
    */
    public static Map<String, Integer> getIndexesOfColumnNames(HSSFRow firstRow) {
        Map<String, Integer> indexesOfColumnNames = new HashMap<String, Integer>();
        try {
            Iterator cellIter = firstRow.cellIterator();

            while (cellIter.hasNext()) {
                HSSFCell myCell = (HSSFCell) cellIter.next();
                int columnIndex = myCell.getColumnIndex();
                String columnName = myCell.getStringCellValue();
                indexesOfColumnNames.put(columnName, columnIndex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return indexesOfColumnNames;
    }
/**
 * 
 * @param row
 * @param cellIndex
 * @param dataType
 * @return
 */
    public static Object getCellValueNew(Row row, int cellIndex, int dataType) {
        Object value ="EmptyString";
        try {
            Cell myCell = row.getCell(cellIndex);
            if (myCell == null) {
                return value;
            }
            if (myCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                value = myCell.getBooleanCellValue();
            }
            if (myCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                value = myCell.getNumericCellValue();
                if (dataType == Types.BIGINT) {
                    value = new BigInteger(value.toString());
                }
                if (dataType == Types.NVARCHAR) {
                    BigDecimal bigDecimalValue = new BigDecimal(value.toString());
                    BigInteger bigIntValue = bigDecimalValue.toBigInteger();
                    BigDecimal remainder = bigDecimalValue.remainder(new BigDecimal(bigIntValue));

                    if (remainder.compareTo(new BigDecimal(0.0)) == 0) {
                        value = bigIntValue.toString();
                    } else {
                        value = bigDecimalValue.toString();
                    }
                }
                if (dataType == Types.DATE) {
                    value = myCell.toString();
                }
            }

            if (myCell.getCellType() == Cell.CELL_TYPE_STRING) {
                value = myCell.getStringCellValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
/**
 * 
 * @param row
 * @param cellIndex
 * @param dataType
 * @return
 */
    public static Object getCellValue(HSSFRow row, int cellIndex, int dataType) {
        Object value = "EMPTY_STRING";
        try {
            HSSFCell myCell = row.getCell(cellIndex);
            if (myCell == null) {
                return value;
            }
            if (myCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
                value = myCell.getBooleanCellValue();
            }
            if (myCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                value = myCell.getNumericCellValue();
                if (dataType == Types.BIGINT) {
                    value = new BigInteger(value.toString());
                }
                if (dataType == Types.NVARCHAR) {
                    BigDecimal bigDecimalValue = new BigDecimal(value.toString());
                    BigInteger bigIntValue = bigDecimalValue.toBigInteger();
                    BigDecimal remainder = bigDecimalValue.remainder(new BigDecimal(bigIntValue));

                    if (remainder.compareTo(new BigDecimal(0.0)) == 0) {
                        value = bigIntValue.toString();
                    } else {
                        value = bigDecimalValue.toString();
                    }
                }
                if (dataType == Types.DATE) {
                    value = myCell.toString();
                }
            }

            if (myCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                value = myCell.getStringCellValue();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
/**
 * 
 * @param fileName
 * @param sheetIndex
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 */
    public static HSSFSheet getSheet(String fileName, int sheetIndex) throws FileNotFoundException, IOException {

        FileInputStream myInput = new FileInputStream(fileName);

        POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

        HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
        return myWorkBook.getSheetAt(sheetIndex);
    }
/*
    public static Sheet getSheetNew(String fileName, int sheetIndex) throws FileNotFoundException, IOException, InvalidFormatException {

        InputStream inputStream = new FileInputStream(fileName);
//        POIFSFileSystem fileSystem = new POIFSFileSystem(inputStream);
//        OPCPackage opc = OPCPackage.open(inputStream);
//        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        
       Workbook workBook = WorkbookFactory.create(inputStream);
        return workBook.getSheetAt(sheetIndex);
    }*/
    
    public static Sheet getSheetForRead(String fileName, int sheetIndex) throws FileNotFoundException, IOException, InvalidFormatException {
    	InputStream inputStream = new FileInputStream(fileName);
    	HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
    	HSSFSheet sheet = workbook.getSheetAt(0);
    	return sheet;
    }
    
    /**
     * 
     * @param fileName
     * @return
     */
    private static String getCustomerListFromExcel(String fileName) {
        System.err.println("start getCustomerListFromExcel");
//        HashMap<Integer, CustomerModel> customerList = new HashMap<Integer, CustomerModel>();
        String listMobile = "";
        try {
            HSSFSheet mySheet = ReadExcelFile.getSheet(fileName, 0);
            HSSFRow firstRow = (HSSFRow) mySheet.getRow(0);
            Map<String, Integer> indexesOfColumnNames = ReadExcelFile.getIndexesOfColumnNames(firstRow);

            if (!indexesOfColumnNames.isEmpty()) {
                Iterator rowIt = mySheet.rowIterator();
                while (rowIt.hasNext()) {
                    HSSFRow myRow = (HSSFRow) rowIt.next();
                    if (myRow.equals(firstRow)) {
                        continue;
                    } else {
                        Object id = ReadExcelFile.getCellValue(myRow, indexesOfColumnNames.get("AA"), Types.NVARCHAR);
                        if (id != null && !"".equals(id.toString())) {
                        	//Font font = new Font("Arial", Font.PLAIN, 12);
                           // CustomerModel customer = new CustomerModel();
                        	System.out.println("STT:::"+ReadExcelFile.getCellValue(myRow, indexesOfColumnNames.get("AA"), Types.VARCHAR).toString());
                            System.out.println("Name:::"+ReadExcelFile.getCellValue(myRow, indexesOfColumnNames.get("BB"), Types.NVARCHAR).toString());
                            System.out.println("Moblie:::"+ReadExcelFile.getCellValue(myRow, indexesOfColumnNames.get("CC"), Types.NVARCHAR).toString());
                        }
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("getCustomerListFromExcel" + ex.toString());
        } catch (IOException ex) {
            System.err.println("getCustomerListFromExcel" + ex.toString());
        }
        System.out.println("list mobile == " + listMobile);
        return listMobile;
    }
    
    
    /**
     *  Khi muốn tra về cả số điện thoại đúng và không đúng format 
     * @param fileName
     * @return
     */
    private static ArrayList<String> getCustomerListFromExcelNew(String fileName) {
      ArrayList list = new ArrayList();
      String listMobile = "";
      ArrayList<ArrayList<Object>> errList = new ArrayList<ArrayList<Object>>();
      try {
          Sheet mySheet = ReadExcelFile.getSheet(fileName, 0);
          int count = 0;
          Row firstRow = (Row) mySheet.getRow(0);
          Map<String, Integer> indexesOfColumnNames = ReadExcelFile.getIndexesOfColumnNamesNew(firstRow);
          if (indexesOfColumnNames.containsKey(VnetConstant.STT_COLUMN_EXCEL) && indexesOfColumnNames.containsKey(VnetConstant.MOBILE_COLUMN_EXCEL)) {
              if (!indexesOfColumnNames.isEmpty()) {
                  Iterator rowIt = mySheet.rowIterator();
                  while (rowIt.hasNext()) {
                      Row myRow = (Row) rowIt.next();
                      if (myRow.equals(firstRow)) {
                          continue;
                      } else {
                          Object id = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.STT_COLUMN_EXCEL), Types.NVARCHAR);
                          if (id != null && !"".equals(id.toString())) {
                              String name = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.NAME_COLUMN_EXCEL), Types.NVARCHAR).toString();
                              String mobileNumber = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.MOBILE_COLUMN_EXCEL), Types.NVARCHAR).toString();
                              if (checkPhoneNumber(mobileNumber)) {
                                  listMobile = listMobile + mobileNumber + ";";
                              } else {
                                  count++;
                                  ArrayList<Object> oneRow = new ArrayList<Object>();
                                  oneRow.add(count);
                                  oneRow.add(name);
                                  oneRow.add(mobileNumber);
                                  errList.add(oneRow);
                              }

                          }

                      }
                  }
              }
              list.add(listMobile);
              list.add(errList);
          } else {
              return null;
          }

      } catch (InvalidFormatException ex) {
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }

      return list;
  }
    
    /**
     *  Khi muốn tra về cả số điện thoại đúng và không đúng format 
     * @param fileName
     * @return
     */
    public static String getListMobileFromExcel(String fileName) {
      String listMobile = "";
      try {
          Sheet mySheet = ReadExcelFile.getSheet(fileName, 0);
          Row firstRow = (Row) mySheet.getRow(0);
          Map<String, Integer> indexesOfColumnNames = ReadExcelFile.getIndexesOfColumnNamesNew(firstRow);
          if (indexesOfColumnNames.containsKey(VnetConstant.STT_COLUMN_EXCEL) && indexesOfColumnNames.containsKey(VnetConstant.MOBILE_COLUMN_EXCEL)) {
              if (!indexesOfColumnNames.isEmpty()) {
                  Iterator rowIt = mySheet.rowIterator();
                  while (rowIt.hasNext()) {
                      Row myRow = (Row) rowIt.next();
                      if (myRow.equals(firstRow)) {
                          continue;
                      } else {
                          Object id = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.STT_COLUMN_EXCEL), Types.NVARCHAR);
                          if (id != null && !"".equals(id.toString())) {
                              String name = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.NAME_COLUMN_EXCEL), Types.NVARCHAR).toString();
                              String mobileNumber = ReadExcelFile.getCellValueNew(myRow, indexesOfColumnNames.get(VnetConstant.MOBILE_COLUMN_EXCEL), Types.NVARCHAR).toString();
                              if (checkPhoneNumber(mobileNumber)) {
                                  listMobile = listMobile + mobileNumber + ";";
                              } else {
                                  continue;
                              }

                          }

                      }
                  }
              }
          } else {
              return null;
          }

      } catch (InvalidFormatException ex) {
      } catch (FileNotFoundException ex) {
      } catch (IOException ex) {
      }

      return listMobile;
  }
    
    public static boolean checkPhoneNumber(String phone) {
        if (phone == null || "".equals(phone.trim())) {
            return false;
        }
        if (phone.matches(VnetConstant.PATTERN1) || phone.matches(VnetConstant.PATTERN2)) {
            return true;
        }
        return false;
    }
    

//    public static void main(String[] arg) {
//        System.out.println("list mobile == ");
//        String pathFile = "C:\\Users\\vtnghia\\Desktop\\DanhsachKH_MIC.xls";
//        System.out.println("Kết quả::"+getListMobileFromExcel(pathFile));
//    }

}
