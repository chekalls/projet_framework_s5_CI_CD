package Util;

import java.sql.Connection;
import java.sql.SQLException;

import mg.kallll.persistence.service.ConnexionService;
import mg.kallll.persistence.service.TransactionCallback;
import mg.kallll.persistence.service.TransactionCallbackWithResult;
import mg.kallll.persistence.utils.ConnexionManager;
import mg.kallll.persistence.utils.ManagedConnection;

public class ConnexionProvider extends ConnexionService{

    @Override
    public void cleanup() {
        // TODO Auto-generated method stub
        super.cleanup();
    }

    @Override
    public void executeInTransaction(TransactionCallback callback) throws Exception {
        // TODO Auto-generated method stub
        super.executeInTransaction(callback);
    }

    @Override
    public <T> T executeInTransaction(TransactionCallbackWithResult<T> callback) throws Exception {
        // TODO Auto-generated method stub
        return super.executeInTransaction(callback);
    }

    @Override
    public int getAvailableConnections() {
        // TODO Auto-generated method stub
        return super.getAvailableConnections();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public ManagedConnection getManagedConnection() throws SQLException {
        // TODO Auto-generated method stub
        return super.getManagedConnection();
    }

    @Override
    public int getTotalConnections() {
        // TODO Auto-generated method stub
        return super.getTotalConnections();
    }

    @Override
    public int getUsedConnections() {
        // TODO Auto-generated method stub
        return super.getUsedConnections();
    }

    @Override
    public void init() {
      String url = "jdbc:postgresql://localhost:5432/gestion_cinema";
      String username = "postgres";
      String password = "admin";
      this.manager = ConnexionManager.getInstance(url, username, password);        
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        // TODO Auto-generated method stub
        return super.releaseConnection(connection);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}
