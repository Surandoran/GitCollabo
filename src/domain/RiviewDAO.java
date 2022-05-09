package domain;

import cosmeticdto.DTO;
import cosmeticdto.RiviewDTO;
import domain.DAO;

public class RiviewDAO extends DAO {
    int result;

    public boolean Inqury(RiviewDTO dto) {    //조회
        try {
            //SQL 전송 객체
            pstmt = conn.prepareStatement("select * from riview_tbl");

            //SQL 실행
            rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getString("name") + "\t" + rs.getString("price") + "\t" + rs.getString("volume") + "\t" + rs.getString("riview"
                        )
                );

            }
            if (result != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean Insert(RiviewDTO dto) {    //삽입
        try {
            pstmt = conn.prepareStatement("insert into riview_tbl values(?,?,?,?)");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPrice());
            pstmt.setString(3, dto.getVolume());
            pstmt.setString(4, dto.getRiview());

            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean Update(RiviewDTO dto) {
        try {
            //SQL전송 객체
            pstmt = conn.prepareStatement("update riview_Tbl set name=?,price=?,volume=?,riview=? where name=?");
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getPrice());
            pstmt.setString(3, dto.getVolume());
            pstmt.setString(4, dto.getRiview());

            //SQL전송
            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean Delete(RiviewDTO dto) {
        //연결
        try {
            //SQL전송객체 생성
            pstmt = conn.prepareStatement("delete from riview_tbl where name=?");
            pstmt.setString(1, dto.getName());

            //SQL 전송
            result = pstmt.executeUpdate();

            if (result != 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {pstmt.close();} catch (Exception e1) {e1.printStackTrace();}
        }
        return false;

    }

}
