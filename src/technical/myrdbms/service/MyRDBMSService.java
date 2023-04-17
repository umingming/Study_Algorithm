package technical.myrdbms.service;

import technical.myrdbms.queryType.QueryType;
import technical.myrdbms.repository.RdbmSRepository;

import java.util.List;
import java.util.Map;

public class MyRDBMSService {

    private static final MyRDBMSService myRDBMSService = new MyRDBMSService();

    private MyRDBMSService() {

    }

    public static MyRDBMSService getMyRDBMSService() {
        return myRDBMSService;
    }

    public void createTable(List<Map<String, String>> table) {
        RdbmSRepository.schema.add(table);
    }

    public void deleteTable(List<Map<String, String>> table) {
        RdbmSRepository.schema.remove(RdbmSRepository.schema.lastIndexOf(table));
    }

}
