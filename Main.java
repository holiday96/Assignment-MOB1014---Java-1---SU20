package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Main {
	static HashMap<String, NhanVien> danhSachNhanVien = new HashMap<>();
	static HashMap<String, Double> listSalary = new HashMap<>(); // Chứa key NhanVien - value Lương NhanVien
	static Scanner sc = new Scanner(System.in);

	/**
	 * 1/ Nhập Danh sách Nhân viên
	 */
	public static void NhapNhanVienHanhChinh() {
		while (true) {
			System.out.println("\n======== NHÂN VIÊN HÀNH CHÍNH ========");

			System.out.print("\nNhập Mã Nhân viên: ");
			String maNV = sc.nextLine();

			if (danhSachNhanVien.containsKey(maNV)) {
				System.out.println("\nMã Nhân viên đã tồn tại! Mời nhập lại!!");
				continue;
			}

			NhanVienHanhChinh nvhc = new NhanVienHanhChinh(null, 0, 0);
			nvhc.insertNV();
			danhSachNhanVien.put(maNV, nvhc);
			listSalary.put(maNV, nvhc.luong());
			break;
		}
	}

	public static void NhapNhanVienKinhDoanh() {
		while (true) {
			System.out.println("\n======== NHÂN VIÊN KINH DOANH ========");

			System.out.print("\nNhập Mã Nhân viên: ");
			String maNV = sc.nextLine();

			if (danhSachNhanVien.containsKey(maNV)) {
				System.out.println("\nMã Nhân viên đã tồn tại! Mời nhập lại!!");
				continue;
			}

			NhanVienKinhDoanh nvkd = new NhanVienKinhDoanh(null, 0, 0);
			nvkd.insertNV();
			danhSachNhanVien.put(maNV, nvkd);
			listSalary.put(maNV, nvkd.luong());
			break;
		}
	}

	public static void NhapNhanVienMoi() {
		while (true) {
			System.out.println("\n======== NHẬP NHÂN VIÊN ========");
			System.out.println("\n1/ Nhân viên Hành chính.");
			System.out.println("2/ Nhân viên Kinh doanh.");
			System.out.println("0/ Quay lại Menu chính.");
			System.out.print("\nNhập chức năng: ");

			String o = sc.nextLine();
			;

			switch (o) {
			case "1": {
				NhapNhanVienHanhChinh();
				break;
			}
			case "2": {
				NhapNhanVienKinhDoanh();
				break;
			}
			case "0":
			case "o":
			case "O": {
				Menu();
				break;
			}
			default:
				System.out.println("Nhập liệu sai! Nhập lại đê!!");
				continue;
			}
		}
	}

	/**
	 * 2/ Xuất Danh sách Nhân viên
	 */
	public static void XuatDanhSachNhanVien() {
		System.out.println("\n======== DANH SÁCH NHÂN VIÊN ========");
		danhSachNhanVien.keySet().forEach((i) -> {
			System.out.println("\nMã Nhân viên: " + i);
			XuatNhanVien(i);
		});
	}

	public static void XuatNhanVien(String key) {
		System.out.println("Họ tên: " + danhSachNhanVien.get(key).getHoTen());
		System.out.println("Lương cơ bản: " + danhSachNhanVien.get(key).getLuongCoBan());
	}

	/**
	 * 3/ Tìm kiếm và hiển thị nhân viên theo lương
	 */
	public static void TimKiemNhanVien() {
		System.out.println("\n======== TÌM KIẾM NHÂN VIÊN ========");
		System.out.print("\nNhập Mã Nhân viên cần tìm: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy!!!\nMã Nhân viên: " + key);
			XuatNhanVien(key);
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 4/ Xoá Nhân viên theo mã nhập từ bàn phím
	 */
	public static void XoaNhanVien() {
		System.out.println("\n======== XOÁ NHÂN VIÊN ========");
		System.out.print("\nNhập Mã Nhân viên cần xoá: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy Nhân viên chứa Mã: " + key);
			danhSachNhanVien.remove(key);
			System.out.println("Đã xoá thành công");
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 5/ Cập nhật thông tin nhân viên
	 */
	public static void updateInfo() {
		System.out.println("\n======== CẬP NHẬT THÔNG TIN NHÂN VIÊN ========");
		System.out.print("\nNhập Mã Nhân viên cần cập nhật: ");
		String key = sc.nextLine();
		if (danhSachNhanVien.containsKey(key)) {
			System.out.println("\nĐã tìm thấy Nhân viên chứa Mã: " + key);
			System.out.println("Bắt đầu Cập nhật!");
			danhSachNhanVien.get(key).insertNV();
			System.out.println("====> Cập nhật thành công <====");
		} else
			System.out.println("\nKhông tìm thấy Nhân viên chứa Mã Nhân viên: " + key);
	}

	/**
	 * 6/ Sắp xếp nhân viên theo họ tên
	 */

	public static void SortByName() {
		// Khởi tạo 1 set entries
		Set<Entry<String, NhanVien>> entries = danhSachNhanVien.entrySet();

		// Convert Set to List
		List<Entry<String, NhanVien>> listEntries = new ArrayList<>(entries);

		// Sắp xếp List
		Collections.sort(listEntries, (o1, o2) -> o1.getValue().getHoTen().compareTo(o2.getValue().getHoTen()));

		// Tạo một LinkedHashMap và put entry từ List đã sắp xếp sang
		LinkedHashMap<String, NhanVien> sortedMap = new LinkedHashMap<>(listEntries.size());
//		for (Entry<String, NhanVien> entry : listEntries) {
//			sortedMap.put(entry.getKey(), entry.getValue());
//		}
		listEntries.forEach((Entry<String, NhanVien> entry) -> sortedMap.put(entry.getKey(), entry.getValue()));
		System.out.println("Sắp xếp nhân viên thành công");
		System.out.println("\n======== DANH SÁCH NHÂN VIÊN SAU KHI SẮP XẾP ========");
		Set<Entry<String, NhanVien>> sortedEntries = sortedMap.entrySet();
		for (Entry<String, NhanVien> mapping : sortedEntries) {
			System.out.println("\nMã Nhân viên: " + mapping.getKey());
			System.out.println("Họ tên: " + mapping.getValue().getHoTen());
			System.out.println("Lương cơ bản: " + mapping.getValue().getLuongCoBan());
		}

	}

	/**
	 * 7/ Sắp xếp nhân viên theo thu nhập
	 */

	public static Set<Entry<String, NhanVien>> SortByMoney() {
		// Khởi tạo 1 Set các entry chứa các cặp key-value của HashMap
		Set<Entry<String, Double>> entriesSalary = listSalary.entrySet();

		// Convert Set to List
		List<Entry<String, Double>> listEntries = new ArrayList<Map.Entry<String, Double>>(entriesSalary);

		// Sort
		Collections.sort(listEntries, (o1, o2) -> (int) (o1.getValue() - o2.getValue())); // sortAscending
//		Collections.reverse(listEntries); // sortDescending

		// Tạo một LinkedHashMap và put entry từ List đã sắp xếp sang
		LinkedHashMap<String, NhanVien> descListSalary = new LinkedHashMap<>(listEntries.size());
		listEntries.forEach((entry) -> descListSalary.put(entry.getKey(), danhSachNhanVien.get(entry.getKey())));

		System.out.println("Sắp xếp nhân viên thành công");
		System.out.println("\n======== DANH SÁCH NHÂN VIÊN SAU KHI SẮP XẾP ========");
		Set<Entry<String, NhanVien>> sortedSalary = descListSalary.entrySet();
		for (Entry<String, NhanVien> mapping : sortedSalary) {
			System.out.println("\nMã Nhân viên: " + mapping.getKey());
			System.out.println("Họ tên: " + mapping.getValue().getHoTen());
			System.out.println("Lương cơ bản: " + mapping.getValue().getLuongCoBan());
			for (Entry<String, Double> entry : listEntries) {
				if (entry.getKey().equals(mapping.getKey())) {
					System.out.println("Lương thu nhập: " + entry.getValue());
					break;
				}
			}
		}
		return sortedSalary;
	}

	/**
	 * 8/ Xuất 5 nhân viên có thu nhập cao nhất công ty
	 */
	public static void TopNhanVien() {
		// Khởi tạo 1 Set các entry chứa các cặp key-value của HashMap
		Set<Entry<String, Double>> entriesSalary = listSalary.entrySet();

		// Convert Set to List
		List<Entry<String, Double>> listEntries = new ArrayList<Map.Entry<String, Double>>(entriesSalary);

		// Sort
		Collections.sort(listEntries, (o1, o2) -> (int) (o1.getValue() - o2.getValue())); // sortAscending
		Collections.reverse(listEntries); // sortDescending

		// Tạo một LinkedHashMap và put entry từ List đã sắp xếp sang
		LinkedHashMap<String, NhanVien> descListSalary = new LinkedHashMap<>(listEntries.size());
		listEntries.forEach((entry) -> descListSalary.put(entry.getKey(), danhSachNhanVien.get(entry.getKey())));

		System.out.println("\n======== TOP 5 NHÂN VIÊN CÓ THU NHẬP CAO NHẤT CÔNG TY ========");
		Set<Entry<String, NhanVien>> sortedSalary = descListSalary.entrySet();
		int i = 0;
		for (Entry<String, NhanVien> mapping : sortedSalary) {
			if (i == 5)
				break;
			System.out.println("\nMã Nhân viên: " + mapping.getKey());
			System.out.println("Họ tên: " + mapping.getValue().getHoTen());
			System.out.println("Lương cơ bản: " + mapping.getValue().getLuongCoBan());
			for (Entry<String, Double> entry : listEntries) {
				if (entry.getKey().equals(mapping.getKey())) {
					System.out.println("Lương thu nhập: " + entry.getValue());
					break;
				}
			}
			i++;
		}
	}

	// Hàm check chuỗi chứa toàn bộ ký tự chữ hay k??
	public boolean isAlphabet(String str) {
		for (char c : str.toCharArray()) {
			if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c == 32))
				continue;
			else
				return false;
		}
		return true;
	}

	// ********************* MENU **********************
	public static void Menu() {
		String o = "";

		while (o != "o" || o != "0") {
			System.out.println("\n==========================================================================");
			System.out.println("|	1/ Nhập Danh sách Nhân viên.					 |");
			System.out.println("|	2/ Xuất Danh sách Nhân viên.					 |");
			System.out.println("|	3/ Tìm kiếm và hiển thị nhân viên theo lương.			 |");
			System.out.println("|	4/ Xoá Nhân viên theo mã nhập từ bàn phím.			 |");
			System.out.println("|	5/ Cập nhật thông tin nhân viên theo mã nhập từ bàn phím.	 |");
			System.out.println("|	6/ Sắp xếp nhân viên theo họ tên.				 |");
			System.out.println("|	7/ Sắp xếp nhân viên theo thu nhập.	 			 |");
			System.out.println("|	8/ Xuất 5 nhân viên có thu nhập cao nhất công ty. 		 |");
			System.out.println("|	0/ Thoát chương trình						 |");
			System.out.println("==========================================================================");
			System.out.print("\nNhập phím chức năng: ");

			o = new Scanner(System.in).nextLine();

			switch (o) {
			case "1": {
				NhapNhanVienMoi();
				break;
			}
			case "2": {
				XuatDanhSachNhanVien();
				break;
			}
			case "3": {
				TimKiemNhanVien();
				break;
			}
			case "4": {
				XoaNhanVien();
				break;
			}
			case "5": {
				updateInfo();
				break;
			}
			case "6": {
				SortByName();
				break;
			}
			case "7": {
				SortByMoney();
				break;
			}
			case "8": {
				TopNhanVien();
				break;
			}
			case "0":
			case "o":
			case "O": {
				System.exit(0);
			}
			default:
				System.out.println("Nhập liệu sai! Nhập lại đê!!");
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Menu();
	}
}
