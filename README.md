# Library
## Library with java and springmvc framework

Project name : **Library**

It was my test work. Building Library Using Java Spring Framework and Hibernate

Technologies: <br>
- Spring MVC 5.0.1, 
- Spring Security 5.1.5, 
- Spring WebFlow 2.5.1, 
- Hibernate 5.1.17, 
- MySQL database 5.1.46

Opportunities: Create an administrator (for now, only by adding to the database directly). <br>Create a user account (already in the web application interface itself).

Admin features: View a list of users. Add a book (image of the cover page and the book file itself). The file extension is for now only TXT. <br>When adding a book, the following is entered: book title, author name, book genre, book abstract. <br>Edit book: change the title, author’s name, annotation, book genre, cover image, and even the book’s file itself. Delete the entire book with all attributes.

To Build:

## FIRST:

* Run the mysql workbench console and configure the db credentials wich can be found at the applicationContext.xml file. 
* Configure the server container for the project, I used tomcat 9.0 installed locally and configured inside the IDE.
*  or use ***XAMPP***

## SECOND:

Run the application once to let hibernate to create the db tables and then you can run this query in the MySQL console to create the admin user, and from there you can manage the products of the site.

- INSERT INTO users VALUES (1,0,true,'admin','admin');
- INSERT INTO authorities VALUES (1,'ROLE_ADMIN','admin');
- (These commands are commented out in applicationContext.xml)
