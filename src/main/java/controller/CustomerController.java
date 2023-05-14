package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.KhachHangDAO;
import model.KhachHang;
import util.Email;
import util.Encode;
import util.RandomNumber;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/customer-controller")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String action = request.getParameter("action");
		if (action.equals("sign-in")) {
			signIn(request, response);
		} else if (action.equals("sign-out")) {
			signOut(request, response);
		} else if (action.equals("sign-up")) {
			signUp(request, response);
		} else if (action.equals("change-pwd")) {
			changePassword(request, response);
		} else if (action.equals("change-customer-infor")) {
			changeCustomerInfor(request, response);
		} else if (action.equals("xac-thuc")) {
			confirmAccount(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String username = request.getParameter("username");
			String pwd = request.getParameter("password");
			pwd = Encode.ToSHA1(pwd);
			KhachHang khachHang = new KhachHang();
			khachHang.setTenDangNhap(username);
			khachHang.setMatKhau(pwd);
			KhachHangDAO khDAO = new KhachHangDAO();
			KhachHang kh = khDAO.selectByUsernameAndPwd(khachHang);
			String url = "";
			if (kh != null && kh.isDaXacThuc()) {
				HttpSession session = request.getSession();
				session.setAttribute("khachHang", kh);
				url = "/index.jsp";
			} else if (kh != null && !kh.isDaXacThuc()) {
				request.setAttribute("error", "Tài khoản của bạn chưa xác thực. Vui lòng kiểm tra email để thực hiện thao tác!");
				url = "/customer/signin.jsp";
			} else {
				request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
				url = "/customer/signin.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void signOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();
			
			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
			response.sendRedirect(url + "/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void signUp(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("rePassword");
			String fullName = request.getParameter("fullName");
			String birthdate = request.getParameter("birthdate");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String orderAddress = request.getParameter("orderAddress");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			String getMessage = request.getParameter("getMessage");
			
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			request.setAttribute("rePassword", rePassword);
			request.setAttribute("fullName", fullName);
			request.setAttribute("birthdate", birthdate);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("orderAddress", orderAddress);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("sdt", sdt);
			request.setAttribute("email", email);
			request.setAttribute("getMessage", getMessage);
			
			String url ="";
			String error = "";
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			
			if (khachHangDAO.checkUsernameExist(username)) {
				error += "Tên đăng nhập đã tồn tại, vui lòng thử tên khác. <br>";
			}
			
			if (password.length() < 8) {
				error += "Mật khẩu phải lớn hơn 8 ký tự <br>";
			}
			
			if (!password.equals(rePassword)) {
				error += "Mật khẩu không khớp. <br>";
			} else {
				password = Encode.ToSHA1(password);
			}
			
			if (sdt.length() < 10) {
				error += "Số điện thoại không hợp lệ <br>";
			}
			
			// Catch error of email
			Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
			Matcher emailMatcher = emailPattern.matcher(email);
			if (!emailMatcher.matches()) {
				error += "Email không hợp lệ <br>";
			}
			
			request.setAttribute("error", error);
			
			if (error.length() > 0) {
				url = "/customer/RegisterForm.jsp";
			} else {
				Random random = new Random();
				String customerId = System.currentTimeMillis() + random.nextInt(1000) + "";
				KhachHang customer = new KhachHang(customerId, username, password, fullName, gender, address, orderAddress, deliveryAddress, java.sql.Date.valueOf(birthdate), sdt, email, (getMessage!=null));
				if (khachHangDAO.insert(customer) > 0) {
					String maXacThuc = RandomNumber.getRandomNumber();
					
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);
					c.add(Calendar.DATE, 1);
					Timestamp thoiGianHieuLucXacThuc = new Timestamp(c.getTimeInMillis());
					
					boolean daXacThuc = false;
					
					customer.setMaXacThuc(maXacThuc);
					customer.setThoiGianHieuLucMaXacThuc(thoiGianHieuLucXacThuc);
					customer.setXacThucEmail(daXacThuc);
					
					if (khachHangDAO.updateVerifyInformation(customer) > 0) {
						Email.sendEmail(customer.getEmail(), "Xác thực tài khoản tại Book Store", getContent(customer));
					}
				}
				url = "/customer/successSignUp.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String reNewPassword = request.getParameter("reNewPassword");
			
			String oldPassword_SHA1 = Encode.ToSHA1(oldPassword);
			String msg = "";
			String url = "/customer/ChangePassword.jsp";
			
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("khachHang");
			KhachHang khachHang = null;
			
			if (obj != null) {
				khachHang = (KhachHang) obj;
			}
			if (khachHang == null) {
				msg = "Vui lòng đăng nhập!";
			} else {
				if (!oldPassword_SHA1.equals(khachHang.getMatKhau())) {
					msg = "Mật khẩu không đúng!";
				} else {
					if (!newPassword.equals(reNewPassword)) {
						msg = "Mật khẩu không khớp";
					} else {
						newPassword = Encode.ToSHA1(newPassword);
						khachHang.setMatKhau(newPassword);
						KhachHangDAO khDAO = new KhachHangDAO();
						if (khDAO.changePassword(khachHang)) {
							msg = "Mật khẩu thay đổi thành công";
						} else {
							msg = "Quá trình thay đổi mật khẩu không thành công";
						}
					}
				}
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void changeCustomerInfor(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			String fullName = request.getParameter("fullName");
			String birthdate = request.getParameter("birthdate");
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String orderAddress = request.getParameter("orderAddress");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String sdt = request.getParameter("sdt");
			String email = request.getParameter("email");
			String getMessage = request.getParameter("getMessage");
			
			request.setAttribute("fullName", fullName);
			request.setAttribute("birthdate", birthdate);
			request.setAttribute("gender", gender);
			request.setAttribute("address", address);
			request.setAttribute("orderAddress", orderAddress);
			request.setAttribute("deliveryAddress", deliveryAddress);
			request.setAttribute("sdt", sdt);
			request.setAttribute("email", email);
			request.setAttribute("getMessage", getMessage);
			
			Object obj = request.getSession().getAttribute("khachHang");
			KhachHang kh = null;
			
			KhachHangDAO khDAO = new KhachHangDAO();
			String msg = "";
			String url = "/customer/ChangeInfor.jsp";
			
			if (obj != null) {
				kh = (KhachHang) obj;
			}
			
			if (kh != null) {
				String customerId = kh.getMaKhachHang();
				KhachHang newCustomer = new KhachHang(customerId, "", "", fullName, gender, address, orderAddress, deliveryAddress, Date.valueOf(birthdate), sdt, email, getMessage!=null);
				khDAO.updateInfor(newCustomer);
				KhachHang updatedCustomer = khDAO.selectById(newCustomer);
				request.getSession().setAttribute("khachHang", updatedCustomer);
				msg = "Cập nhật thông tin thành công";
			}
			request.setAttribute("msg", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void confirmAccount(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maKhachHang = request.getParameter("maKhachHang");
			String maXacThuc = request.getParameter("maXacThuc");
			
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			System.out.println(currentTime);
			
			KhachHangDAO khachHangDAO = new KhachHangDAO();
			
			KhachHang kh = new KhachHang();
			kh.setMaKhachHang(maKhachHang);
			KhachHang khachHang = khachHangDAO.selectById(kh);
			
			String msg = "";
			if (kh != null) {
				if (currentTime.compareTo(khachHang.getThoiGianHieuLucMaXacThuc()) < 0) {
					if (khachHang.getMaXacThuc().equals(maXacThuc)) {
						khachHang.setXacThucEmail(true);
						khachHangDAO.updateVerifyInformation(khachHang);
						msg = "Xác thực tài khoản thành công";
					}
				} else {
					msg = "Đã quá thời gian xác thực, vui lòng đăng ký tài khoản mới";
				}
			}
			
			String url = "/customer/notifications.jsp";
			request.setAttribute("notifications", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getContent(KhachHang kh) {
		String link = "http://localhost:8080/JSP_14_Session/customer-controller?action=xac-thuc&maKhachHang=" + kh.getMaKhachHang()+"&maXacThuc="+kh.getMaXacThuc();
		String content = "<p>TITV.vn xin ch&agrave;o bạn <strong>"+kh.getTenKH()+"</strong>,</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"+kh.getMaXacThuc()+"</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\""+link+"\">"+link+"</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
		
		return content;
	}
	
}
