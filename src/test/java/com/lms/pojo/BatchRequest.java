package com.lms.pojo;

public class BatchRequest {
    private String batchName;
    private String batchDescription;
    private String batchStatus;
    private String programId;
    private String programName;
    private String batchNoOfClasses;

    // getters and setters
    public String getBatchName() { return batchName; }
    public void setBatchName(String batchName) { this.batchName = batchName; }

    public String getBatchDescription() { return batchDescription; }
    public void setBatchDescription(String batchDescription) { this.batchDescription = batchDescription; }

    public String getBatchStatus() { return batchStatus; }
    public void setBatchStatus(String batchStatus) { this.batchStatus = batchStatus; }

    public String getProgramId() { return programId; }
    public void setProgramId(String programId) { this.programId = programId; }

    public String getProgramName() { return programName; }
    public void setProgramName(String programName) { this.programName = programName; }

    public String getBatchNoOfClasses() { return batchNoOfClasses; }
    public void setBatchNoOfClasses(String batchNoOfClasses) { this.batchNoOfClasses = batchNoOfClasses; }

}
