package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TelemetryDiagnosticControlsTest
{

    
	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
    {
        String response = "Server Response";
        TelemetryClient telemetryClient = new TelemetryClientImpl();
        TelemetryDiagnosticControls telemetryDiagnosticControls =  new TelemetryDiagnosticControls(telemetryClient);
        try {
            telemetryDiagnosticControls.checkTransmission();
            System.out.println(telemetryDiagnosticControls.getDiagnosticInfo());
            if (telemetryDiagnosticControls.getDiagnosticInfo().length() == 0) {
                Assertions.fail("No Response");
            }
        } catch (Exception e) {
            Assertions.fail("Instead of Response, Recieved Error "+e);
        }
    }

    @Test
    public void CheckTransmission_Exception()
    {
        String response = "Server Response";
        TelemetryClient telemetryClient = Mockito.mock(TelemetryClientImpl.class);
        TelemetryDiagnosticControls telemetryDiagnosticControls =  new TelemetryDiagnosticControls(telemetryClient);
        try {
            telemetryDiagnosticControls.checkTransmission();
            System.out.println(telemetryDiagnosticControls.getDiagnosticInfo());
            Assertions.fail("Should Throw Error");
        } catch (Exception e) {
            Assertions.assertEquals(e.getMessage(), "Unable to connect.");
        }
    }
}
