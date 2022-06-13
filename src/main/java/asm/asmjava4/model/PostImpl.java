/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asm.asmjava4.model;

import asm.asmjava4.dao.PostDAO;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository
public class PostImpl implements PostDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Post post) {
         Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        return jdbcTemplate.update("INSERT INTO post (idUser, content, image, date, shortDesc, title, isPublish, idCategory) VALUES (?,?,?,?,?,?,?,?)",new Object[]{post.getIdUser(),post.getContent(),post.getImage(),timestamp2,post.getShortDesc(),post.getTitle(),post.getIsPublish(),post.getIdCategory()});
    }

    @Override
    public List<Post> getAll() {
        return jdbcTemplate.query("select * from post", new BeanPropertyRowMapper<Post>(Post.class));
    }

    @Override
    public Post getById(int idPost) {
         return jdbcTemplate.queryForObject("SELECT * FROM post where idPost=?", new BeanPropertyRowMapper<Post>(Post.class),idPost);
    }

    @Override
    public int update(Post post, int id) {
         return jdbcTemplate.update("UPDATE post SET idUser= ?,  content =?, image =? , date = ?, shortDesc = ?, title =?, isPublish  =? ,idCategory = ? WHERE idPost = ?",new Object[]{post.getIdUser(),post.getContent(),post.getImage(),post.getDate(),post.getShortDesc(),post.getTitle(),post.getIsPublish(),post.getIdCategory(),id});
    }

    @Override
    public int delete(int idPost) {
       return jdbcTemplate.update("DELETE FROM post WHERE idPost = ?",idPost);
    }

    @Override
    public List<Post> getAllById(int id) {
          return jdbcTemplate.query("select * from post where idCategory = "+id, new BeanPropertyRowMapper<Post>(Post.class));
    }

}
