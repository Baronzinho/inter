package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DQL extends SQL {

    public DQL(String tabela) {
        super(tabela);
    }

    public ResultSet select() throws SQLException {
        sql = "select * from " + super.tabela + ";";
        conect(sql);
        ResultSet rset = getRset();
        return rset;
    }

    public void selectCustomer(int customerNumber) throws SQLException {
        sql = "select * from " + super.tabela + " where customerNumber"
                + " = " + Integer.toString(customerNumber) + ";";
        select(sql);
    }

    public ResultSet selectEdit(int customerNumber) throws SQLException {
        sql = "select * from " + super.tabela + " where customerNumber"
                + " = " + customerNumber + ";";
        conect(sql);
        ResultSet rset = getRset();
        return rset;
    }

    public ResultSet selectEdit2(String productCode) throws SQLException {
        sql = "select * from " + super.tabela + " where productCode"
                + " = '" + productCode + "';";
        conect(sql);
        ResultSet rset = getRset();
        return rset;
    }

    public ResultSet selectLogin() throws SQLException {
        sql = "select extension, employeeNumber from " + super.tabela + " where jobTitle = 'Sale Manager (EMEA)';";
        conect(sql);
        ResultSet rset = getRset();
        return rset;
    }
    /*
    public ObservableList<Customers> selectTable() throws SQLException {
        sql = "select customerNumber, customerName, contactFirstName, \n"
                + "phone, addressLine1, city, country from customers;";
        conect(sql);
        ResultSet rset = getRset();
        ObservableList<Customers> obList = FXCollections.observableArrayList();

        while (rset.next()) {
            Customers customer = new Customers();
            customer.setCustomerNumber(rset.getInt("customerNumber"));
            customer.setCustomerName(rset.getString("customerName"));
            customer.setContactFirstName(rset.getString("contactFirstName"));
            customer.setPhone(rset.getString("phone"));
            customer.setAdressLine1(rset.getString("addressLine1"));
            customer.setCity(rset.getString("city"));
            customer.setCountry(rset.getString("country"));

            obList.add(customer);
        }
        return obList;
    }
    */
    /*
    public ObservableList<Products> selectTable2() throws SQLException {
        sql = "select productCode, productName, productLine, productScale, "
                + "productVendor, productDescription, quantityInStock, "
                + "buyPrice, MSRP from products;";
        conect(sql);
        ResultSet rset = getRset();
        ObservableList<Products> obList = FXCollections.observableArrayList();

        while (rset.next()) {
            Products product = new Products();
            product.setProductCode(rset.getString("productCode"));
            product.setProductName(rset.getString("productName"));
            product.setProductLine(rset.getString("productLine"));
            product.setProductScale(rset.getString("productScale"));
            product.setProductVendor(rset.getString("productVendor"));
            product.setProductDescription(rset.getString("productDescription"));
            product.setQuantityInStock(rset.getInt("quantityInStock"));
            product.setBuyPrice(rset.getDouble("buyPrice"));
            product.setMSRP(rset.getDouble("MSRP"));
            obList.add(product);
        }
        return obList;
    }
    */
    /*
    public ObservableList<Products> selectReports() throws SQLException {
        sql = "select productCode, productName, productLine, productScale, "
                + "productVendor, productDescription, quantityInStock, "
                + "buyPrice, MSRP from products;";
        conect(sql);
        ResultSet rset = getRset();
        ObservableList<Products> obList = FXCollections.observableArrayList();

        while (rset.next()) {
            Products product = new Products();
            product.setProductCode(rset.getString("productCode"));
            product.setProductName(rset.getString("productName"));
            obList.add(product);
        }
        return obList;
    }
    */
    public ResultSet callProcedure(String procedureSignature) throws SQLException {
        sql = "call " + procedureSignature + ";";
        conect(sql);
        ResultSet rset = getRset();
        return rset;
    }
}
