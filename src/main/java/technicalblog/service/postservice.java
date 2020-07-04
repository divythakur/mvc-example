package technicalblog.service;

import org.springframework.stereotype.Service;
import technicalblog.model.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
@Service
public class postservice {

    Connection connection=null;

    public ArrayList<Post> getAllPosts ()  {
        ArrayList<Post> posts=new ArrayList<>();

        Post post1 = new Post();
        post1.setTitle("Post 1");
        post1.setBody("Post Body 1");
        post1.setDate(new Date());

        Post post2 = new Post();
        post2.setTitle("Post 2");
        post2.setBody("Post Body 2");
        post2.setDate(new Date());
        posts.add(post1);
        posts.add(post2);

//        try{
//            Class.forName("com.mysql.jdbc.Driver");
//
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "divyanshu123");
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery("SELECT * FROM posttable");
//            while(rs.next()){
//                Post post = new Post();
//                post.setTitle(rs.getString("title"));
//                post.setBody(rs.getString("postbody"));
//                posts.add(post);
//            }
//        } catch (ClassNotFoundException  | SQLException e) {
//            e.printStackTrace();
//        }
//        finally{
//            try {
//                connection.close();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//
//        }
//        return posts;


    }

    public ArrayList<Post> getOnePost() {
        ArrayList<Post> posts = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "divyanshu123");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM posttable where id=3");
            while(rs.next()){
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                post.setBody(rs.getString("postbody"));
                posts.add(post);
            }
        } catch (ClassNotFoundException  | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return posts;

    }
}
