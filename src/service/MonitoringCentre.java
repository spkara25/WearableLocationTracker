package service;

public class MonitoringCentre {
    public void receiveLocation(String deviceId, double latitude, double longitude) {
        System.out.printf("📍 Device %s at (%.5f, %.5f)%n", deviceId, latitude, longitude);
    }

    public void receiveDistressSignal(String deviceId) {
        System.out.println("🚨 ALERT! Distress signal received from device: " + deviceId);
    }
}
