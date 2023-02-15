package technical;

public class ChangeSubstrateInfo {

    public boolean isEnableValidation() {
        return enableValidation;
    }

    public void setEnableValidation(boolean enableValidation) {
        this.enableValidation = enableValidation;
    }

    public String getSubstrateType() {
        return substrateType;
    }

    public void setSubstrateType(String substrateType) {
        this.substrateType = substrateType;
    }

    public String getSubstrateSubType() {
        return substrateSubType;
    }

    public void setSubstrateSubType(String substrateSubType) {
        this.substrateSubType = substrateSubType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getMachineRecipeName() {
        return machineRecipeName;
    }

    public void setMachineRecipeName(String machineRecipeName) {
        this.machineRecipeName = machineRecipeName;
    }

    public String getLotName() {
        return lotName;
    }

    public void setLotName(String lotName) {
        this.lotName = lotName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSubUnitName() {
        return subUnitName;
    }

    public void setSubUnitName(String subUnitName) {
        this.subUnitName = subUnitName;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getSlotNo() {
        return this.slotNo;
    }

    public void setSlotNo(Integer slotNo) {
        this.slotNo = slotNo;
    }

    public String getSubstrateStatus() {
        return substrateStatus;
    }

    public void setSubstrateStatus(String substrateStatus) {
        this.substrateStatus = substrateStatus;
    }

    public String getSubstrateJudge() {
        return substrateJudge;
    }

    public void setSubstrateJudge(String substrateJudge) {
        this.substrateJudge = substrateJudge;
    }

    public String getSubstrateGrade() {
        return substrateGrade;
    }

    public void setSubstrateGrade(String substrateGrade) {
        this.substrateGrade = substrateGrade;
    }

    public String getPairLotName() {
        return pairLotName;
    }

    public void setPairLotName(String pairLotName) {
        this.pairLotName = pairLotName;
    }

    public String getPairSubstrateName() {
        return pairSubstrateName;
    }

    public void setPairSubstrateName(String pairSubstrateName) {
        this.pairSubstrateName = pairSubstrateName;
    }

    public String getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(String defectCode) {
        this.defectCode = defectCode;
    }

    public int getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public String getInternalJudgeData() {
        return internalJudgeData;
    }

    public void setInternalJudgeData(String internalJudgeData) {
        this.internalJudgeData = internalJudgeData;
    }

    public String getInternalGradeData() {
        return internalGradeData;
    }

    public void setInternalGradeData(String internalGradeData) {
        this.internalGradeData = internalGradeData;
    }

    public String getPortWaitFlag() {
        return portWaitFlag;
    }

    public void setPortWaitFlag(String portWaitFlag) {
        this.portWaitFlag = portWaitFlag;
    }

    private boolean enableValidation = false;
    private String substrateType;
    private String substrateSubType;
    private String productType;
    private String machineRecipeName;
    private String lotName;
    private String unitName;
    private String subUnitName;
    private String portName;
    private String carrierName;
    private int slotNo;
    private String substrateStatus;
    private String substrateJudge;
    private String substrateGrade;
    private String pairLotName;
    private String pairSubstrateName;
    private String defectCode;
    private int usedCount;
    private int groupNo;
    private String internalJudgeData;
    private String internalGradeData;
    private String portWaitFlag;

}