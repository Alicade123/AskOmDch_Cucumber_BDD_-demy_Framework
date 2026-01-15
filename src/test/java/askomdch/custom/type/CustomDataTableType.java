package askomdch.custom.type;

import askomdch.domain.object.BillingDetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;

import java.util.List;
import java.util.Map;

public class CustomDataTableType {
    @DataTableType
    public BillingDetails billingDetailsEntries(Map<String,String> entries){

        return new BillingDetails(
                entries.get("firstname"),
                entries.get("lastname"),
                entries.get("country"),
                entries.get("address_line1"),
                entries.get("city"),
                entries.get("state"),
                entries.get("zip"),
                entries.get("email")
                );
    }
}
