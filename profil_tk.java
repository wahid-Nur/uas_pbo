/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.*;
import koneksi.koneksi_db;
/**
 *
 * @author Acer
 */
public class profil_tk implements Toko {
    
      @Override
    public Data insert(Data data) throws SQLException {
        PreparedStatement st = koneksi_db.getConnection().prepareStatement("insert into tbl_bajuGamis values(?,?,?,?)");
        st.setString(1, data.getKode());
        st.setString(2, data.getWarna());
        st.setString(3, data.getUkuran());
        st.setString(4, data.getMerk());
        st.setInt(5, data.getJumlah());
        st.setInt(6, data.getHarga());
        st.executeUpdate();

        return data;
    }

    @Override
    public void update(Data data) throws SQLException {
        PreparedStatement st = koneksi_db.getConnection().prepareStatement("update tbl_bajuGamis set warna=?,ukuran=?,merk=?,jumlah=?,harga=? where kode=?");

        st.setString(1, data.getWarna());
        st.setString(2, data.getUkuran());
        st.setString(3, data.getMerk());
        st.setInt(4, data.getJumlah());
        st.setInt(5, data.getHarga());
        st.setString(6, data.getKode());
        st.executeUpdate();

    }

    @Override
    public void delete(String kode) throws SQLException {
        PreparedStatement st = koneksi_db.getConnection().prepareStatement("delete from tbl_bajuGamis  where kode=?");
        st.setString(1, kode);
        st.executeUpdate();
    }

    @Override
    public List getAll() throws SQLException {
        Statement st = koneksi_db.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from tbl_bajuGamis");
        List list = new ArrayList();
        while (rs.next()) {
            Data d = new Data();
            d.setKode(rs.getString("kode"));
            d.setWarna(rs.getString("warna"));
            d.setUkuran(rs.getString("ukuran"));
            d.setMerk(rs.getString("merk"));
            d.setJumlah(rs.getInt("jumlah"));
            d.setHarga(rs.getInt("harga"));
            list.add(d);
        }
        return list;
    }
}
