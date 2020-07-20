package Assignment;

import java.util.Scanner;

public class NhanVienHanhChinh extends NhanVien {
	private double ngayCong;

	public NhanVienHanhChinh(String hoTen, double luongCoBan, double ngayCong) {
		super(hoTen, luongCoBan);
		this.ngayCong = ngayCong;
	}

	public double getNgayCong() {
		return ngayCong;
	}

	public void setNgayCong(double ngayCong) {
		this.ngayCong = ngayCong;
	}

	public double luong() {
		return getLuongCoBan() * getNgayCong();
	}

	public void insertNV() {
		Scanner sc = new Scanner(System.in);

		super.insertNV();
		// Nhập số ngày công
		while (true) {
			System.out.print("Nhập số ngày công: ");
			try {
				setNgayCong(Double.parseDouble(sc.nextLine()));
				if (getNgayCong() <= 0) {
					System.out.println("Số ngày công vừa nhập không hợp lệ! Nhập lại!!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhập Số ngày công sai rồi! Nhập lại xem nào!!");
				continue;
			}
		}
	}

	public void display() {
		super.display();
		System.out.println("\tSố Ngày công: " + getNgayCong());
	}
}
