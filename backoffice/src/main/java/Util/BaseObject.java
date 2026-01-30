// package Util;

// import java.sql.SQLException;
// import java.util.ArrayList;



// public abstract class BaseObject {
//     private int id;


//     public BaseObject() {
//         // conn = new ConPS();
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public int getId() {
//         return this.id;
//     }

//     public abstract void save() throws Exception;

//     public abstract void deleteAll() throws SQLException;

//     public abstract ArrayList<BaseObject> findAll() throws SQLException;

//     public abstract ArrayList<BaseObject> findAllPaginated(int index, int count) throws SQLException;

//     public abstract void getById(int id) throws SQLException;

//     public abstract void update() throws SQLException;

//     public abstract void delete() throws SQLException;
// }