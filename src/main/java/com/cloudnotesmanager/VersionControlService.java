package com.cloudnotesmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VersionControlService {

    public void saveNewVersion(int fileId, String version, String timestamp) {
        String sql = "INSERT INTO VersionControl (fileId, version, timestamp) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fileId);
            pstmt.setString(2, version);
            pstmt.setString(3, timestamp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<VersionControl> getVersions(int fileId) {
        List<VersionControl> versions = new ArrayList<>();
        String sql = "SELECT * FROM VersionControl WHERE fileId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, fileId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                VersionControl version = new VersionControl();
                version.setId(rs.getInt("id"));
                version.setFileId(rs.getInt("fileId"));
                version.setVersion(rs.getString("version"));
                version.setTimestamp(rs.getString("timestamp"));
                versions.add(version);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return versions;
    }

    public void revertToVersion(int versionId) {
        // Implement logic to revert to a specific version
    }
}
