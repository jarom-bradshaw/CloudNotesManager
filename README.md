# Overview

CloudNotesManager is a cloud-based notes and document management system designed to provide users with a secure, efficient way to store, organize, and manage their personal files and documents online. By integrating with a cloud database, this application ensures that data is reliably stored, easily accessible, and synchronized across different devices.

The software supports a range of features including:
- **User Authentication:** Secure login and registration for authorized access.
- **File Upload/Download:** Able to upload and download files.
- **Folder Management:** Organize files in a hierarchical folder system.
- **File Tagging:** Assign and search tags for quick document retrieval.
- **File Sharing:** Share files with others securely.
- **Version Control:** Track changes and maintain document history.

The primary goal of CloudNotesManager is to further my expertise as a software engineer by exploring cloud integration, database management, and scalable application design in Java. This project not only strengthens my programming skills but also provides valuable insights into building secure and robust cloud-based systems.


[Software Demo Video](https://www.youtube.com/watch?v=vRRLJmCF1wA)

# Cloud Database

This project uses a cloud-based SQL database service (Amazon RDS) to manage and store application data securely. The database is structured to support efficient data retrieval and scalability:

- **Users Table:**  
  Stores user information, including login credentials, authentication tokens, and profile data.
  
- **Files Table:**  
  Contains metadata for uploaded files such as file names, storage paths, upload timestamps, and associated user IDs.
  
- **Folders Table:**  
  Organizes files within a hierarchical folder structure, linking each file to its respective folder.
  
- **Tags Table:**  
  Manages tags that are associated with files to facilitate quick searching and categorization.
  
- **Version Control Table:**  
  Maintains a history of changes to files, allowing users to view previous versions and revert changes when necessary.

# Development Environment


- **Programming Language:**  
  Java (JDK 11 or higher)
  
- **Build Tool:**  
  Maven for dependency management and build automation.
  
- **Integrated Development Environment (IDE):**  
  IntelliJ IDEA or Eclipse for efficient coding and debugging.
  
- **Database Connectivity:**  
  JDBC for connecting and interacting with the cloud SQL database.
  
- **Testing Framework:**  
  JUnit for writing and running unit tests to ensure code quality and reliability.
  
- **Cloud Services:**  
  A cloud SQL database service (Amazon RDS) is used for data storage and management.


# Useful Websites


- [GitHub Repository Structure Best Practices](https://medium.com/code-factory-berlin/github-repository-structure-best-practices-248e6effc405)
- [Official Java Language Documentation](https://docs.oracle.com/javase/specs/jls/se22/html/index.html)
- [How to make a cloud project (Network Chuch)](https://www.youtube.com/watch?v=xBIowQ0WaR8)
- [Amazon instructions on how to set up a mySQL database](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_GettingStarted.CreatingConnecting.MySQL.html)
- [Choices for AWS Free Tier Capabilities.](https://aws.amazon.com/free/?all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc&awsf.Free%20Tier%20Types=*all&awsf.Free%20Tier%20Categories=*all)

# Future Work
- **Enhanced Security Features:**  
  Implement multi-factor authentication and encryption for data at rest and in transit to further secure user data.

- **User Interface Enhancements:**  
  Develop a web-based UI using frameworks like Spring Boot with Thymeleaf or integrate modern front-end technologies.

- **Additional Features:**  
  Introduce collaborative editing, real-time notifications, and further expand version control capabilities.

- **Performance Optimization:**  
  Refine database queries and file handling processes to boost application performance under heavy loads.
  
