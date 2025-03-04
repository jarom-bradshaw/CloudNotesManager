package com.cloudnotesmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public boolean uploadFile(String name, String path, int userId, int folderId) {
        String sql = "INSERT INTO Files (name, path, userId, folderId, uploadTimestamp) VALUES (?, ?, ?, ?, NOW())";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, path);
            pstmt.setInt(3, userId);
            pstmt.setInt(4, folderId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<File> getFilesByUser(int userId) {
        List<File> files = new ArrayList<>();
        String sql = "SELECT * FROM Files WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                File file = new File();
                file.setId(rs.getInt("id"));
                file.setName(rs.getString("name"));
                file.setPath(rs.getString("path"));
                file.setUserId(rs.getInt("userId"));
                file.setFolderId(rs.getInt("folderId"));
                file.setUploadTimestamp(rs.getString("uploadTimestamp"));
                files.add(file);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return files;
    }
}
