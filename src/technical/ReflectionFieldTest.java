package technical;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class ReflectionFieldTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {

        Substrate substrate = new Substrate();
        substrate.setSubstrateName("키키");

        ChangeSubstrateInfo info = new ChangeSubstrateInfo();

        info.setSubstrateType("type");
        info.setSubstrateSubType("subtype");
        info.setProductType("productType");
        info.setMachineRecipeName("machineRecipeName");
        info.setLotName("lot");
        info.setUnitName("unit");
        info.setSubUnitName("subunit");
        info.setPortName("port");
        info.setCarrierName("carrier");
        info.setSlotNo(22);
        info.setSubstrateStatus("status");
        info.setSubstrateJudge("judge");
        info.setSubstrateGrade("grade");
        info.setPairLotName("pairLot");
        info.setPairSubstrateName("pair substrate");
        info.setDefectCode("defect");
        info.setUsedCount(33);
        info.setGroupNo(55);
        info.setInternalGradeData("gradeData");
        info.setInternalJudgeData("judgeData");
        info.setPortWaitFlag("flag");



    }


}



