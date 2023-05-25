package departmentGuide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Team01DAOImpl extends JdbcDAO implements Team01DAO {
	private static Team01DAOImpl _dao;

	public Team01DAOImpl() {
	}

	static {
		_dao = new Team01DAOImpl();
	}

	public static Team01DAOImpl getDAO() {
		return _dao;
	}

	// 중분류로 선별한 테이블 객체를 불러와 dto객체 리스트에 저장하기 위한 메서드.
	@Override
	public List<Team01DTO> selectPstoreList(String product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> storeList = new ArrayList<>();

		try {
			con = getConnection();
			String sql = "select c.products, s.name, s.floor, s.phone from store s inner join categories c on s.pno = c.pno where c.products = ? order by floor";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO store = new Team01DTO();

				store.setProducts(rs.getString("products"));
				store.setName(rs.getString("name"));
				store.setFloor(rs.getString("floor"));
				store.setPhone(rs.getString("phone"));
				storeList.add(store);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(con, pstmt, rs);
		}

		return storeList; // dto리스트의 객체를 반환한다.
	}

	// 대분류로 선별한 테이블 객체를 불러와 출력하기 위한 메서드.
	@Override
	public List<Team01DTO> selectCategoriesList(String categories) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> storeList = new ArrayList<>();

		try {
			con = getConnection();
			String sql = "select c.products, s.name, s.floor, s.phone from store s inner join categories c on s.pno = c.pno where c.category = ? order by products";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, categories);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO store = new Team01DTO();
				store.setProducts(rs.getString("products"));
				store.setName(rs.getString("name"));
				store.setFloor(rs.getString("floor"));
				store.setPhone(rs.getString("phone"));
				storeList.add(store);
				storeList.add(store);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(con, pstmt, rs);
		}

		return storeList;// 대분류선별 리스트 객체를 반환
	}


	// 모든가게를 출력하기 위한 메서드 / 상정정보를 담은 resultset의 리스트 객체를 생성하고 저장함.
	@Override
	public List<Team01DTO> selectAllStore() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> storeList = new ArrayList<>();
		try {
			con = getConnection();

			String sql = "select products, name, floor, phone from store inner join categories on store.pno = categories.pno order by floor";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				do {
					Team01DTO store = new Team01DTO();
					store.setProducts(rs.getString("products"));
					store.setFloor(rs.getString("floor"));
					store.setName(rs.getString("name"));
					store.setPhone(rs.getString("phone"));
					storeList.add(store);

				} while (rs.next());
			} else {
				System.out.println("가게 정보가 없습니다.");
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectAllStore() 메소드의 SQL 오류 = " + e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}

		return storeList;
	}

	/**************************************
	 * 추가
	 ***************************************************/
	// combobox에 불러올 가게 리스트를 불러오기 위한 메서드 // 결과값을 불러와서 단일행
	public List<Team01DTO> cList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> cList = new ArrayList<>();

		try {
			con = getConnection();
			String sql = "select distinct category from categories";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO cName = new Team01DTO();
				cName.setCategories(rs.getString("category"));
				cList.add(cName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return cList;
	}
	//combobox에서 대분류 선택 후, 중분류 목록을 추리기 위한 메서드
	@Override
	public List<Team01DTO> pList(String category) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> pList = new ArrayList<>();

		try {
			con = getConnection();
			String sql = "select products from categories where category=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO pName = new Team01DTO();
				pName.setProducts(rs.getString("products"));
				pList.add(pName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return pList;
	}
	//특정 글자를 포함하는 상호명을 검색하기 위한 메서드
	@Override
	public List<Team01DTO> searchSNameList(String sName) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> storeList = new ArrayList<>();
		String wildCard = "%"+sName+"%";
		try {
			con = getConnection();
			String sql = "select products, name, floor, phone from store inner join categories on store.pno = categories.pno where name like ? order by floor";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, wildCard);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO store = new Team01DTO();
				store.setProducts(rs.getString("products"));
				store.setName(rs.getString("name"));
				store.setFloor(rs.getString("floor"));
				store.setPhone(rs.getString("phone"));
				storeList.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return storeList;
	}

	// 층 button을 눌러 층을 전환하기 위한 메서드
	@Override
	public List<Team01DTO> pushFButton(String floor) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Team01DTO> floorSList = new ArrayList<>();
		try {
			con = getConnection();
			String sql = "select products, name, floor, phone from store inner join categories on store.pno = categories.pno where floor = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, floor);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Team01DTO store = new Team01DTO();
				store.setProducts(rs.getString("products"));
				store.setName(rs.getString("name"));
				store.setFloor(rs.getString("floor"));
				store.setPhone(rs.getString("phone"));
				floorSList.add(store);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}

		return floorSList;
	}
	
	
}