package Assignment;

import java.util.Scanner;

public class NhanVien extends Main {
	private String maNV;
	private String hoTen;
	private double LuongCoBan;

	public NhanVien(String hoTen, double luongCoBan) {
		super();
		this.hoTen = hoTen;
		LuongCoBan = luongCoBan;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public double getLuongCoBan() {
		return LuongCoBan;
	}

	public void setLuongCoBan(double luongCoBan) {
		LuongCoBan = luongCoBan;
	}

	public void insertNV() {
		Scanner sc = new Scanner(System.in);

		// Nhập Họ tên
		while (true) {
			System.out.print("Nhập Họ tên: ");
			setHoTen(sc.nextLine());

			if (!isAlphabet(getHoTen()) || getHoTen().isEmpty()) {
				System.out.println("Nhập dữ liệu sai! Chỉ được nhập ký tự chữ cái!! Mời nhập lại!!!");
				continue;
			} else
				break;
		}

		// Nhập Mức Lương cơ bản
		while (true) {
			System.out.print("Nhập Mức lương cơ bản: ");
			try {
				setLuongCoBan(Double.parseDouble(sc.nextLine()));
				if (getLuongCoBan() <= 0) {
					System.out.println("Mức lương vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Mức lương sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
	}

	public void display() {
		System.out.println("Nhân viên 1: ");
		System.out.println("\tHọ tên: " + getHoTen());
		System.out.println("\tLương cơ bản: " + getLuongCoBan());
	}
}
