package Assignment;

import java.util.Scanner;

public class NhanVienKinhDoanh extends NhanVien {
	private double luongKinhDoanh;

	public NhanVienKinhDoanh(String hoTen, double luongCoBan, double luongKinhDoanh) {
		super(hoTen, luongCoBan);
		this.luongKinhDoanh = luongKinhDoanh;
	}

	public double getLuongKinhDoanh() {
		return luongKinhDoanh;
	}

	public void setLuongKinhDoanh(double luongKinhDoanh) {
		this.luongKinhDoanh = luongKinhDoanh;
	}

	public double luong() {
		return getLuongCoBan() + getLuongKinhDoanh();
	}

	public void insertNV() {
		Scanner sc = new Scanner(System.in);

		super.insertNV();
		// Nhập Lương kinh doanh
		while (true) {
			System.out.print("Nhập Lương kinh doanh: ");
			try {
				setLuongKinhDoanh(Double.parseDouble(sc.nextLine()));
				if (getLuongKinhDoanh() <= 0) {
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
		System.out.println("\tLương kinh doanh: " + getLuongKinhDoanh());
	}
}
