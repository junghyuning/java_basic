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
      _dao=new Team01DAOImpl();
   }
   
   public static Team01DAOImpl getDAO() {
      return _dao;
   }   

   @Override
   public List<Team01DTO> selectPstoreList(String product) {
      Connection con =null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<Team01DTO> storeList = new ArrayList<>();
      
      try {
         con = getConnection();
         String sql = "select c.products, s.name, s.floor, s.phone from store s inner join category c on s.pno = c.pno where c.products = ?";
         pstmt=con.prepareStatement(sql);
         pstmt.setString(1, product);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            Team01DTO store = new Team01DTO();
            
            store.setProducts("products");
            store.setName("name");
            store.setFloor("floor");
            store.setPhone("phone");
         }
      
      } catch (Exception e) {
         // TODO: handle exception
      }finally {
        close(con, pstmt, rs);
     }
        
      
      return storeList;
   }
   
   @Override
   public List<Team01DTO> selectCategoriesList(String categories) {
      Connection con =null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      List<Team01DTO> storeList = new ArrayList<>();
      
      try {
         con = getConnection();
         String sql = "select c.products, s.name, s.floor, s.phone from store s inner join categories c on s.pno = c.pno where c.category = ?";
         pstmt=con.prepareStatement(sql);
         pstmt.setString(1, categories);
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            Team01DTO store = new Team01DTO();
            
            store.setProducts("products");
            store.setName("name");
            store.setFloor("floor");
            store.setPhone("phone");
         }
      
      } catch (Exception e) {
         // TODO: handle exception
      }finally {
        close(con, pstmt, rs);
     }
        
      
      return storeList;
   }

   @Override
   public Team01DTO selectStore(String storeName) {
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      Team01DTO store=null;
      
      try {
         con=getConnection();
         
         String sql="select * from store where name=?";
         pstmt=con.prepareStatement(sql);
       pstmt.setString(1, storeName);
         
       rs=pstmt.executeQuery();
       
       while(rs.next()) {
          store=new Team01DTO();
          store.setFloor(rs.getString("floor"));
          store.setName(rs.getString("name"));
          store.setPhone(rs.getString("phone"));
          store.setProducts(rs.getString("products"));
         
       }
         
         
      }catch (SQLException e) {
         System.out.println("[에러]selectStore 메소드의 SQL 오류 = "+e.getMessage());
   }finally {
      close(con, pstmt, rs);
   }
      
      return store;
   }


   @Override
   public List<Team01DTO> selectAllStore() {
      Connection con=null;
      PreparedStatement pstmt=null;
      ResultSet rs=null;
      List<Team01DTO> storeList=new ArrayList<>();
      try {
      con=getConnection();
      
      String sql="select products, name, floor, phone from store inner join categories on store.pno = categories.pno";
      pstmt=con.prepareStatement(sql);
      rs=pstmt.executeQuery();
      
      if(rs.next()) {
         do { Team01DTO store=new Team01DTO();
         store.setProducts(rs.getString("products"));
         store.setFloor(rs.getString("floor"));
         store.setName(rs.getString("name"));
         store.setPhone(rs.getString("phone"));
         storeList.add(store);
         
            
         }while(rs.next());
      }else {
         System.out.println("가게 정보가 없습니다.");
      }
   } catch (SQLException e) {
      System.out.println("[에러]selectAllStore() 메소드의 SQL 오류 = "+e.getMessage());
   }
      finally {
         close(con, pstmt, rs);
      }
      
      
      return storeList;
   }



}