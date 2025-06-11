package device;

public class WeareableDevice {
    private String deviceId;
    private double latitude;
    private double longitude;
    private boolean distressSignal;

    public WeareableDevice(String deviceId) {
        this.deviceId = deviceId;
        this.latitude = 0.0;
        this.longitude = 0.0;
        this.distressSignal = false;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isDistressSignal() {
        return distressSignal;
    }

    public void updateLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void sendDistressSignal() {
        this.distressSignal = true;
        System.out.println("🚨 Distress Signal sent from device " + deviceId);
    }

    public void resetDistressSignal() {
        this.distressSignal = false;
    }
}
