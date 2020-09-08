package Connection;

import java.sql.SQLException;

public class DML extends SQL {

    public DML(String tabela) {
        super(tabela);
    }

    public void insertCustomer(int customerNumber, String customerName, String contactFirstName, String contactLastName,
            String phone, String addressLine, String city, String country) throws SQLException {
        sql = "insert into " + tabela
                + " (customerNumber, "
                + "customerName, "
                + "contactFirstName, "
                + "contactLastName, "
                + "phone, "
                + "addressLine1, "
                + "city, "
                + "country) "
                + "values("
                + customerNumber + ", '"
                + customerName + "', '"
                + contactFirstName + "', '"
                + contactLastName + "', '"
                + phone + "', '"
                + addressLine + "', '"
                + city + "', '"
                + country + "');";
        update(sql);
    }

    public void updateCustomer(int customerNumber, String customerName, String contactFirstName, String contactLastName, String phone, String addressLine1, String city, String country) throws SQLException {
        sql = "update " + super.tabela
                + " set customerName = '" + customerName
                + "', contactLastName = '" + contactLastName
                + "', contactFirstName = '" + contactFirstName
                + "', phone = '" + phone
                + "', addressLine1 = '" + addressLine1
                + "', city = '" + city
                + "', country = '" + country
                + "'where customerNumber = " + customerNumber + ";";
        update(sql);
    }

    public void deleteCustomer(int customerNumber) throws SQLException {
        sql = "delete from " + tabela
                + " where customerNumber = " + customerNumber + ";";
        update(sql);
    }

    public void insertProduct(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) throws SQLException {
        sql = "insert into " + super.tabela
                + " (productCode, "
                + "productName, "
                + "productLine, "
                + "productScale, "
                + "productVendor, "
                + "productDescription, "
                + "quantityInStock, "
                + "buyPrice, "
                + "MSRP) "
                + "values('"
                + productCode + "', '"
                + productName + "', '"
                + productLine + "', '"
                + productScale + "', '"
                + productVendor + "', '"
                + productDescription + "', "
                + quantityInStock + ", "
                + buyPrice + ", "
                + MSRP + ");";
        update(sql);
    }

    public void updateProduct(String productCode, String productName, String productLine, String productScale, String productVendor, String productDescription, int quantityInStock, double buyPrice, double MSRP) throws SQLException {
        sql = "update " + super.tabela
                + " set productCode = '" + productCode
                + "', productName = '" + productName
                + "', productLine = '" + productLine
                + "', productScale = '" + productScale
                + "', productVendor = '" + productVendor
                + "', productDescription = '" + productDescription
                + "', quantityInStock = " + quantityInStock
                + ", buyPrice = " + buyPrice
                + ", MSRP = " + MSRP
                + " where productCode = '" + productCode + "';";
        update(sql);
    }

    public void deleteProduct(String productCode) throws SQLException {
        sql = "delete from " + super.tabela
                + " where productCode = '" + productCode + "';";
        update(sql);
    }
}
