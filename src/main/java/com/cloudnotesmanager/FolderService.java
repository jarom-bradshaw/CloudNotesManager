package com.cloudnotesmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FolderService {

    public boolean createFolder(String name, int parentId, int userId) {
        String sql = "INSERT INTO Folders (name, parentId, userId) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, parentId);
            pstmt.setInt(3, userId);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Folder> getFoldersByUser(int userId) {
        List<Folder> folders = new ArrayList<>();
        String sql = "SELECT * FROM Folders WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Folder folder = new Folder();
                folder.setId(rs.getInt("id"));
                folder.setName(rs.getString("name"));
                folder.setParentId(rs.getInt("parentId"));
                folder.setUserId(rs.getInt("userId"));
                folders.add(folder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return folders;
    }
}
