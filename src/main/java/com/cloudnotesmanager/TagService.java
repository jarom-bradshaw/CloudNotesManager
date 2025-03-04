package com.cloudnotesmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagService {

    public boolean addTagToFile(int fileId, String tagName) {
        String sql = "INSERT INTO Tags (fileId, name) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fileId);
            pstmt.setString(2, tagName);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<File> searchFilesByTag(String tagName) {
        List<File> files = new ArrayList<>();
        String sql = "SELECT f.* FROM Files f JOIN Tags t ON f.id = t.fileId WHERE t.name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, tagName);
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
