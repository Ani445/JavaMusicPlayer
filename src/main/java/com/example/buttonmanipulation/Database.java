package com.example.buttonmanipulation;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    static Connection con;
    static String dbUsername = "root";
    static String dbPassword = "system";
    private static User currentUser;

    static {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/phoenix", dbUsername, dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        currentUser = new User();
    }

    public static User signIn(String username, String password) throws Exception {
        String sqlString = "select * from USER where USERNAME = ? and PASSWORD = ?";
        PreparedStatement pstmt = con.prepareStatement(sqlString);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet resultSet = pstmt.executeQuery();

        if(resultSet.next()) {
            currentUser = new User(resultSet.getString(1), resultSet.getString(2));
            currentUser.setFirstName(resultSet.getString(3));
            currentUser.setLastName(resultSet.getString(4));
            currentUser.setJoinDate(resultSet.getDate(5));
            return currentUser;
        }
        return null;
    }
    public static void signUp(User user) throws Exception {
        String sqlString = "insert into user (username, password, first_name, last_name) values (?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sqlString);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getFirstName());
        pstmt.setString(4, user.getLastName());
        pstmt.executeUpdate();
        currentUser = user;
    }
    public static void updateCurrentUserInfo(User user) throws Exception {
        String sqlString = "update user set PASSWORD = ?, FIRST_NAME = ?, LAST_NAME = ? where USERNAME = ?";
        PreparedStatement pstmt = con.prepareStatement(sqlString);
        pstmt.setString(1, user.getPassword());
        pstmt.setString(2, user.getFirstName());
        pstmt.setString(3, user.getLastName());
        pstmt.setString(4, user.getUsername());
        pstmt.executeUpdate();
        currentUser = user;
    }

    public static User getCurrentUser()
    {
        return  currentUser;
    }
    public static ArrayList<Song> getAllSongs() throws SQLException {
        String sqlString =
                """
                select T2.*, artist.first_name, artist.last_name from
                    (select T1.*, song_artist.ARTIST_ID from (select song.*, album.NAME as ALBUM from song left join album on song.ALBUM_ID = album.ALBUM_ID) T1
                        left join song_artist on T1.SONG_ID = song_artist.SONG_ID) T2 left join artist
                        on T2.ARTIST_ID = artist.ARTIST_ID
                        order by NAME;
                """;

        PreparedStatement preparedStatement = con.prepareStatement(sqlString);
        ArrayList <Song> list=  new ArrayList<>();

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            Song song = new Song(resultSet.getString(1),
                    resultSet.getString(2), resultSet.getString(3));
            song.setArtistFirstName(resultSet.getString(4));
            song.setArtistLastName(resultSet.getString(5));
//            song.setAl(resultSet.getString(6));
            list.add(song);
        }

        return list;
    }
}
