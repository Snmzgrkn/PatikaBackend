package Week_07.RENTACAR.dao;

import Week_07.RENTACAR.core.Db;
import Week_07.RENTACAR.entity.Book;
import Week_07.RENTACAR.entity.Car;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BookDao {
    private Connection connection;
    private CarDao carDao;
    public BookDao(){
        this.connection = Db.getInstance();
        this.carDao = new CarDao();
    }

    public Book getById(int id){
        Book obj = null;
        String query = "SELECT * FROM public.book WHERE book_id = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) obj = this.match(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return obj;
    }



    public ArrayList<Book> findAll() {
        return this.selectByQuery("SELECT * FROM public.book ORDER BY book_id ASC");

    }


    public boolean save(Book book) {
        String query = "INSERT INTO public.book " +
                "(" +
                "book_car_id, " +
                "book_name, " +
                "book_idno, " +
                "book_mpno," +
                "book_mail," +
                "book_strt_date," +
                "book_fnsh_date," +
                "book_prc," +
                "book_case," +
                "book_note" + // Virgül kaldırıldı
                ")"+
                " VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.connection.prepareStatement(query);
            ps.setInt(1, book.getCar_id());
            ps.setString(2, book.getName());
            ps.setString(3, book.getIdno());
            ps.setString(4, book.getMpno());
            ps.setString(5, book.getMail());
            ps.setDate(6, Date.valueOf(book.getStrt_date()));
            ps.setDate(7, Date.valueOf(book.getFnsh_date()));
            ps.setInt(8, book.getPrc());
            ps.setString(9, book.getbCase());
            ps.setString(10, book.getNote());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Eğer en az bir satır etkilendiyse true döner
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Hata durumunda false döndür
        }
    }

    public boolean delete(int id) {
        String query = "DELETE FROM public.book WHERE book_id = ?";
        try {
            PreparedStatement prepared = this.connection.prepareStatement(query);
            prepared.setInt(1, id);
            return prepared.executeUpdate() != -1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }
    public ArrayList<Book> selectByQuery(String query) {
        ArrayList<Book> books = new ArrayList<>();
        try {
            ResultSet rs = this.connection.createStatement().executeQuery(query);
            while (rs.next()) {
                books.add(this.match(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book match(ResultSet rs) throws SQLException{
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setbCase(rs.getString("book_case"));
        book.setCar_id(rs.getInt("book_car_id"));
        book.setName(rs.getString("book_name"));
        book.setStrt_date(LocalDate.parse(rs.getString("book_strt_date")));
        book.setFnsh_date(LocalDate.parse(rs.getString("book_fnsh_date")));
        book.setCar(this.carDao.getById(rs.getInt("book_car_id")));
        book.setIdno(rs.getString("book_idno"));
        book.setMpno(rs.getString("book_mpno"));
        book.setMail(rs.getString("book_mail"));
        book.setNote(rs.getString("book_note"));
        book.setPrc(rs.getInt("book_prc"));
        return book;
    }
}
