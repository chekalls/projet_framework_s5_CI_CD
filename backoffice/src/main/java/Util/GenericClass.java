// package Util;

// import java.lang.reflect.Field;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;

// import annotation.Column;
// import annotation.Table;


// public class GenericClass extends BaseObject {

//     @Override
//     public void save() throws Exception {
//         Table representation = this.getClass().getAnnotation(Table.class);
//         Field[] listeFields = this.getClass().getDeclaredFields();
//         StringBuilder sql = new StringBuilder();

//         sql.append("INSERT INTO " + representation.name() + "(");
//         sql.append(representation.id() + ",");
//         int size = listeFields.length;

//         for (int i = 0; i < size; i++) {
//             String columnName = listeFields[i].getAnnotation(Column.class).name();
//             if (columnName != null)
//                 sql.append("`" + columnName + "`");
//             if (i < size - 1) {
//                 sql.append(",");
//             }
//         }
//         sql.append(") VALUES(" + "?,");

//         for (int i = 0; i < size; i++) {
//             String columnName = listeFields[i].getAnnotation(Column.class).name();
//             if (columnName != null) {
//                 sql.append("?");
//                 if (i < size - 1) {
//                     sql.append(",");
//                 }
//             }
//         }
//         sql.append(")");
//         Connection connection = this.conn.getConnection();
//         if (connection != null) {
//             PreparedStatement pstmt = connection.prepareStatement(sql.toString());
//             try {
//                 pstmt.setInt(1, this.getId());
//                 for (int i = 0; i < size; i++) {
//                     String columnName = listeFields[i].getAnnotation(Column.class).name();
//                     if (columnName != null) {
//                         listeFields[i].setAccessible(true);
//                         Object value = null;
//                         try {
//                             value = listeFields[i].get(this);
//                             System.out.println(value);
//                         } catch (IllegalArgumentException e) {
//                             e.printStackTrace();
//                         } catch (IllegalAccessException e) {
//                             e.printStackTrace();
//                         }
//                         pstmt.setObject(i + 2, value);
//                     }
//                 }

//                 pstmt.executeUpdate();
//             } catch (SQLException e) {
//                 throw e;
//             } finally {
//                 connection.commit();
//                 pstmt.close();
//                 connection.close();
//             }
//         }else{
//             throw new Exception("connexion null");
//         }
//     }

//     @Override
//     public void deleteAll() throws SQLException {
//     }

//     @SuppressWarnings("deprecation")
//     @Override
//     public ArrayList<BaseObject> findAll() throws SQLException {
//         String tableName = this.getClass().getAnnotation(Table.class).name();
//         String sql = "SELECT * FROM " + tableName;
//         Connection connection = this.conn.getConnection();
//         Statement statement = connection.createStatement();
//         ArrayList<BaseObject> resultList = new ArrayList<>();
//         try {
//             ResultSet set = statement.executeQuery(sql);
//             Field[] fieldList = this.getClass().getDeclaredFields();

//             while (set.next()) {
//                 GenericClass newInstance = this.getClass().newInstance();
//                 newInstance.setId(set.getInt(this.getClass().getAnnotation(Table.class).id()));
//                 for (Field f : fieldList) {
//                     f.setAccessible(true);
//                     Column column = f.getAnnotation(Column.class);
//                     if (column != null) {
//                         String columnName = column.name();
//                         Object value = set.getObject(columnName);
//                         f.set(newInstance, value);
//                     }
//                 }
//                 resultList.add(newInstance);
//             }
//         } catch (IllegalAccessException | InstantiationException e) {
//             e.printStackTrace();
//         } catch (SQLException e) {
//             throw e;
//         } finally {
//             statement.close();
//             connection.close();
//         }
//         return resultList;
//     }

//     @SuppressWarnings("deprecation")
//     @Override
//     public ArrayList<BaseObject> findAllPaginated(int index, int count) throws SQLException {
//         String tableName = this.getClass().getAnnotation(Table.class).name();
//         String sql = String.format("SELECT * FROM " + tableName + " LIMIT %d OFFSET %d", count, index - 2);
//         Connection connection = this.conn.getConnection();
//         Statement statement = connection.createStatement();
//         ArrayList<BaseObject> resultList = new ArrayList<>();
//         try {
//             ResultSet set = statement.executeQuery(sql);
//             Field[] fieldList = this.getClass().getDeclaredFields();

//             while (set.next()) {
//                 GenericClass newInstance = this.getClass().newInstance();
//                 newInstance.setId(set.getInt(this.getClass().getAnnotation(Table.class).id()));
//                 for (Field f : fieldList) {
//                     f.setAccessible(true);
//                     Column column = f.getAnnotation(Column.class);
//                     if (column != null) {
//                         String columnName = column.name();
//                         Object value = set.getObject(columnName);
//                         f.set(newInstance, value);
//                     }
//                 }
//                 resultList.add(newInstance);
//             }
//         } catch (IllegalAccessException | InstantiationException e) {
//             e.printStackTrace();
//         } catch (SQLException e) {
//             throw e;
//         } finally {
//             statement.close();
//             connection.close();
//         }
//         return resultList;
//     }

//     @Override
//     public void getById(int id) throws SQLException {
//         Table tableDescription = this.getClass().getAnnotation(Table.class);
//         String sql = String.format("SELECT * FROM %s WHERE %s=%d", tableDescription.name(), tableDescription.id(), id);
//         Connection connection = this.conn.getConnection();
//         Statement statement = connection.createStatement();
//         try {
//             ResultSet set = statement.executeQuery(sql);
//             Field[] fieldList = this.getClass().getDeclaredFields();

//             if (set.next()) {
//                 this.setId(set.getInt(tableDescription.id()));
//                 for (Field f : fieldList) {
//                     f.setAccessible(true);
//                     Column column = f.getAnnotation(Column.class);
//                     if (column != null) {
//                         String columnName = column.name();
//                         Object value = set.getObject(columnName);
//                         f.set(this, value);
//                     }
//                 }

//             }
//         } catch (IllegalAccessException e) {
//             e.printStackTrace();
//         } catch (SQLException e) {
//             throw e;
//         } finally {
//             statement.close();
//             connection.close();
//         }
//     }

//     @Override
//     public void update() throws SQLException {
//         Table tableDescription = this.getClass().getAnnotation(Table.class);
//         Field[] fieldList = this.getClass().getDeclaredFields();
//         StringBuilder valuesList = new StringBuilder();

//         for (int i = 0; i < fieldList.length; i++) {
//             fieldList[i].setAccessible(true);
//             Column column = fieldList[i].getAnnotation(Column.class);
//             if (column != null) {
//                 valuesList.append("`" + column.name() + "`=? ");
//                 if (i < fieldList.length - 1) {
//                     valuesList.append(",");
//                 }
//             }
//         }

//         String sql = String.format("UPDATE %s SET " + valuesList.toString() + " WHERE %s=%d", tableDescription.name(),
//                 tableDescription.id(), this.getId());
//         Connection connection = this.conn.getConnection();
//         PreparedStatement pstmt = connection.prepareStatement(sql);
//         try {
//             for (int i = 0; i < fieldList.length; i++) {
//                 fieldList[i].setAccessible(true);
//                 Column column = fieldList[i].getAnnotation(Column.class);
//                 if (column != null) {
//                     pstmt.setObject(i + 1, fieldList[i].get(this));
//                 }
//             }
//             pstmt.executeUpdate();

//         } catch (SQLException e) {
//             throw e;
//         } catch (IllegalAccessException e) {
//             e.printStackTrace();
//         } finally {
//             connection.commit();
//             pstmt.close();
//             connection.close();
//         }
//     }

//     @Override
//     public void delete() throws SQLException {
//         Table tableDescription = this.getClass().getAnnotation(Table.class);

//         String sql = String.format("DELETE FROM %s WHERE %s=%d", tableDescription.name(), tableDescription.id(),
//                 this.getId());
//         Connection connection = this.conn.getConnection();
//         PreparedStatement pstmt = connection.prepareStatement(sql);
//         try {
//             pstmt.executeUpdate();
//         } catch (SQLException e) {
//             throw e;
//         } finally {
//             connection.commit();
//             pstmt.close();
//             connection.close();
//         }
//     }

// }