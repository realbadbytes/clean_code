/*
 * Old error handling techniques involved setting error flags or returning error codes to caller.
 * Why shit? caller must check for errors on return. 
 * Make it less shit by throwing exceptions. This simplifies things by removing
 * the requirement for error checking by caller.
 */

public class DeviceController {
    public void sendShutdown() {
        DeviceHandle handle = getHandle(DEV1);
        // Check the state of the device
        if (handle != DeviceHandle.INVALID) {
            // Save the device status to the record field
            retrieveDeviceRecord(handle);
            // If not suspended, shut down
            if (record.getStatus() != DEVICE_SUSPENDED) {
                pauseDevice(handle);
                clearDeviceWorkQueue(handle);
                closeDevice(handle);
            } else {
                logger.log("Device suspended. Unable to shut down");
            }
        } else {
            logger.log("Invalid handle for: " + DEV1.toString());
        }
    }
}
             

/* less shit version */
/* getHandle() throws exception. Caller tryToShutDown() doesn't have to worry about error handling */

public class DeviceController {
    public void sendShutDown() {
        try {
            tryShutDown();
        } catch (DeviceShutDownError e) {
            logger.log(e);
        }
    }

    private void tryToShutDown() throws DeviceShutDownError {
        DeviceHandle handle = getHandle(DEV1);
        DeviceRecord record = retrieveDeviceRecord(handle);

        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
    }

    private DeviceHandle getHandle(DeviceID id) {
        //...
        throw new DeviceShutDownError("Invalid handle for: " + id.toString());
        ///...
    }
}












