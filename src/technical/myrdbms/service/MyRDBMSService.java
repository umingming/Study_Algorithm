package technical.myrdbms.service;

import technical.myrdbms.queryType.QueryType;
import technical.myrdbms.repository.RdbmSRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyRDBMSService {

    private static final MyRDBMSService myRDBMSService = new MyRDBMSService();

    private MyRDBMSService() {}

    public void queryEngine(String query) {

        String[] queryArr = query.split(" ");

        String queryType = queryArr[0];
        String queryTarget = queryArr[1];
        String queryTargetName = queryArr[2];

        if(queryType.equalsIgnoreCase("create")) {
            if(queryTarget.equalsIgnoreCase("table")) {
                createTable();
            }
        } if (queryType.equalsIgnoreCase("select")) {
            System.out.println();
        }
    }



    public static void main(String[] args) {
        String query = "CREATE TABLE Persons\n" +
                "(\n" +
                "PersonID int,\n" +
                "LastName varchar(255),\n" +
                "FirstName varchar(255),\n" +
                "Address varchar(255),\n" +
                "City varchar(255)\n" +
                ");";


        String[] queryArr = query.split(" ");

        String queryType = queryArr[0];
        String queryTarget = queryArr[1];
        String queryTargetName = queryArr[2];

        query = query.substring(query.indexOf("(")+2);
        query = query.substring(0, query.lastIndexOf(")"));
//        System.out.println(query);

        queryArr = query.split(",");

        System.out.print(queryArr[0]);

    }

    public static MyRDBMSService getMyRDBMSService() {
        return myRDBMSService;
    }

    public void createTable() {
        List<Map<Object, String>> table = new ArrayList<>();

        RdbmSRepository.schema.add(table);
    }

    public void deleteTable(List<Map<String, String>> table) {
        RdbmSRepository.schema.remove(RdbmSRepository.schema.lastIndexOf(table));
    }

}
