package dto;

/** DTO for transfering repair order information between layers. (Cannot be changed after creation) */
public class RepairOrderDTO {
    private final int id;
    private final String problemDescription;
    private final String customerPhoneNumber;
    private final int bikeSerialNumber;
    private final boolean newlyCreated;
    private final boolean readyForApproval;
    private final boolean accepted;
    private final DiagnosticReportDTO diagnosticReport;

    /** Creates a DTO containing the data of a repair order.
     * 
     * @param id id of the repair order
     * @param problemDescription Description of problem to be repaired
     * @param customerPhoneNumber Phone number of customer connected to repair order
     * @param bikeSerialNumber Serialnumber found on the bike that is to be repaired
     * @param newlyCreated Status field signaling if the repairorder is newly created
     * @param readyForApproval Status field signaling if diagnostic report has been added and the order is ready for approval for customer
     * @param accepted Status field signaling if customer has accepted proposed repair.
     * @param diagnosticReport Diganostic report attatched to the order after technician has diagnosed issues.
    */
    public RepairOrderDTO(int id, String problemDescription, String customerPhoneNumber, int bikeSerialNumber,
                          boolean newlyCreated, boolean readyForApproval, boolean accepted,
                          DiagnosticReportDTO diagnosticReport) {
        this.id = id;
        this.problemDescription = problemDescription;
        this.customerPhoneNumber = customerPhoneNumber;
        this.bikeSerialNumber = bikeSerialNumber;
        this.newlyCreated = newlyCreated;
        this.readyForApproval = readyForApproval;
        this.accepted = accepted;
        this.diagnosticReport = diagnosticReport;
    }

    /** Gets the repair order id */
    public int getId() { return id; }

    /** Gets the problem description */
    public String getProblemDescription() { return problemDescription; }

    /** Gets the customers phone number */
    public String getCustomerPhoneNumber() { return customerPhoneNumber; }

    /** Gets the bike serial number */
    public int getBikeSerialNumber() { return bikeSerialNumber; }

    /** Returns true if the repair order has just been created */
    public boolean isNewlyCreated() { return newlyCreated; }

    /** Returns true if the repair order has a diagnostic report ready for approval from the customer */
    public boolean isReadyForApproval() { return readyForApproval; }

    /** Returns true if the customer has accepted the repair order */
    public boolean isAccepted() { return accepted; }

    /** Gets the diagnostic report from this repair order */
    public DiagnosticReportDTO getDiagnosticReport() { return diagnosticReport; }

}
