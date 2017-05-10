package com.vnet.sms.common.constant;

public class VnetConstant {
	public static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";
	
	//========================ROLE USER=====================================
	public static final int END_USER = 1;                           // khach hang cuoi
	public static final int END_AGENT_USER = 2;                     // khach hang Dai Ly
	public static final int BUSINESS_USER = 3;       				// Bộ phận kinh doanh
	public static final int FOR_CONTROL_USER= 4;     				// Bộ phận đối soát
	public static final int ACCOUNTING_USER= 5;      				// Bộ phận kế toán
	public static final int REGISTER_TELCO_USER= 6;  				// Nhân viên đăng ký với telco
	public static final int BUSINESS_ADMINISTRATION_USER= 7;        // Quản trị kinh doanh
	public static final int OPERATOR_USER= 8;        				// Bộ phận vận hành
	public static final int ADMIN = 9;              				// Quản trị hệ thống
	public final static String USER_SESSION = "user";
	//========================END USER=====================================
	
	//========================USER STATUS=====================================
	public static final int USER_REJECT =-1;         // từ chối
	public static final int USER_PENDING = 0;        // đã đăng ký thành công nhưng chưa xác thực OTP (lưu được thông tin vào DB)
	public static final int USER_REGISTER_COMPLETE = 1;        // đã đăng ký thành công (đã xác thực OTP or những tài khoản có IP thuộc accept list)
	public static final int USER_CONFIRM = 2;        // được kích hoạt nhưng chưa change pass
	public static final int USER_ACTIVATE = 3;        // được kích hoạt và đã đổi pass / unlock account
	public static final int USER_LOCK_24H = 4;           // Tai khoan bi khóa 24h (đăng nhập quá 3 lần)
	public static final int USER_LOCK_ADMIN = 5;           // Tai khoan bi khóa bởi quản trị hệ thống
	
	
	public static final int FIRST_ACCESS = 1;    // lần đầu login or đăng ký
	public static final int MAX_ACCESS = 3;    // Số tối đa có thể login hoặc đăng ký
	public static final String NOTI_BLOCK_ACC = "Tài khoản của đã bạn bị khóa 24h";    // 
	//========================END USER=====================================

	//========================Excel=====================================
	public final static String NAME_COLUMN_EXCEL = "Tên khách hàng";
    public final static String MOBILE_COLUMN_EXCEL = "Số điện thoại";
    public final static String STT_COLUMN_EXCEL = "STT";
    
	public static final String PATTERN1 = "84(9\\d{8})";
	public static final String PATTERN2 = "84(1\\d{9})";
	public static final String PATTERN3 = "(09\\d{8})";
	public static final String PATTERN4 = "(01\\d{9})";
    //========================END USER=====================================
	
	//========================Alias=====================================
    public final static int ALIAS_SEND_REQUEST		 = 1;      // chuyển đến NV telco
    public final static int ALIAS_TO_TELCOS 		 = 2;          // Đã chuyển sang telcos
    public final static int ALIAS_RJECT 			 = -1;              // Hồ sơ bị từ chối
    public final static int ALIAS_CONFIRM			 = 3;			 // Telcos đã cấp
    public final static int ALIAS_DEACTIVATE	     = 4;			 // block alias
    //========================END ALIAS===================================
    
    
   //========================TEMPLATE=====================================
    public final static int TEMPLATE_SEND_REQUEST 		= 1;      // chuyển đến NV telco
    public final static int TEMPLATE_TO_TELCOS 			=2;          // Đã chuyển sang telcos
    public final static int TEMPLATE_RJECT 				=-1;              // Hồ sơ bị từ chối
    public final static int TEMPLATE_CONFIRM 			=3;			 // Telcos đã cấp
    public final static int TEMPLATE_ACTIVATE 			=4;			 // Đã được cấp phép
    //========================END TEMPLATE=====================================
    
    //========================STRING FOR RADOM PASSWORD======================
    public final static String STRING_UPPER 		= "QWERTYUIOPASDFGHJKLZXCVBNM";    
    public final static String STRING_LOWER 		= STRING_UPPER.toLowerCase();        
    public final static String STRING_NUMBER 		= "1234567890";            
    public final static String STRING_SPECIAL 		= "~!@#$%^*?"	;	
    public final static int PASSWORD_LENGTH 		= 8;
    public final static int PASSWORD_TYPE 			= 5;
    //========================END =====================================
    
    //========================KHIEU NAi / PHAN HOI=====================
    public final static String COMPLAINT_SEND = "Đã gửi";      // Đã gửi khiếu nại
    //========================END=====================================
    //=======================MAIL CONTENT=====================
    public final static String CONTENT_TITLE 		= "VNET SMS";
    public final static String CONTENT_CONFIRM_OTP 	= "Ma OTP dung de xac nhan dang nhap la:";    
    public final static String CONTENT_END 			= "Cam on ban da su dung dich vu. Moi thong tin xin lien he tai website : vkx.com.vn hoac he thong CallCenter 19006609.";  
    //========================END=====================================
    
    
    //========================PAGES===========================================
    public static final String PAGE_REDIRECT           =  "? faces-redirect=true";
	public static final String LOGIN_DEFAULT_RETURN    =  "/public/register.xhtml";
	public static final String PAGE_LOGIN              =  "/public/login.xhtml";
	public static final String PAGE_CHANGE_PASSWORD    = "/public/changePassword.xhtml";
	public static final String PAGE_REGISTER           = "/public/register.xhtml";
	public static final String PAGE_OTP                = "/public/otp.xhtml";
	
	
	public static final String PAGE_STATUS_MSG         = "/pages/protected/endUser/tabmessagestatus.xhtml";
	public static final String PAGE_SEND_MSG  		   = "/pages/protected/endUser/tabsentmessage.xhtml";
	public static final String PAGE_CONTACT_SUPPORT    = "/pages/protected/endUser/contactsupport.xhtml";
	public static final String PAGE_ALIAS              = "/pages/protected/endUser/alias.xhtml";
	public static final String PAGE_DIVISION_MONEY     = "/pages/protected/endUser/divisionmoney.xhtml";
	public static final String PAGE_DOCUMENT           = "/pages/protected/endUser/documents.xhtml";
	public static final String PAGE_DOCUMENT_TYPE      = "/pages/protected/endUser/documenttype.xhtml";
	public static final String PAGE_USER_PROFILE       = "/pages/protected/endUser/userprofile.xhtml";
	public static final String PAGE_SUCCESS            = "/pages/protected/endUser/success.xhtml";
	public static final String PAGE_ACCOUNTING         = "/pages/protected/accounting/accounting.xhtml";
	public static final String PAGE_WELCOME            = "/pages/protected/templates/welcome.xhtml";   
	public static final String HOME_PAGE               = "/public/home.xhtml"; 
	public static final String REDIRECT_TRUE           = "?faces-redirect=true";
	
	//========================END=====================================
	
	  public static final String STRING_A7                   = "aaaaaaa"; 
	  public static final String STRING_A6                   = "aaaaaa";
	  public static final String STRING_SPEC              = "^[]{}|~";
	 //========================BUNDLE KEY=====================================
	public static final String CONTACT_MANAGEMENT 		= "contactManagement";
	public static final String PHONE_BOOK_MANAGEMENT 	= "phoneBookManagement";
	public static final String MESSAGE_MANAGEMENT 		= "messageManagement";
	public static final String ALIAS_MANAGEMENT 		= "aliasManagement";
	public static final String TEMPLATE_MANAGEMENT 		= "templateManagement";
	public static final String ACCOUTING_MANAGEMENT 	= "templateManagement";
}
