package service;

import device.WeareableDevice;
import ui.MapVisualizer;

import java.util.Random;

public class TrackerService implements Runnable {
    private final WeareableDevice device;
    private final MonitoringCentre monitoringCenter;
    private final MapVisualizer mapVisualizer;
    private boolean isRunning;
    private final Random random;

    public TrackerService(WeareableDevice device, MonitoringCentre center, MapVisualizer mapVisualizer) {
        this.device = device;
        this.monitoringCenter = center;
        this.mapVisualizer = mapVisualizer;
        this.isRunning = false;
        this.random = new Random();
    }

    public void startTracking() {
        isRunning = true;
        new Thread(this).start();
    }

    public void stopTracking() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (isRunning) {
            double lat = 15.0 + random.nextDouble();
            double lon = 80.0 + random.nextDouble();
            device.updateLocation(lat, lon);

            monitoringCenter.receiveLocation(device.getDeviceId(), lat, lon);
            mapVisualizer.updateLocation(lat, lon);

            if (random.nextInt(10) > 8) {
                device.sendDistressSignal();
                monitoringCenter.receiveDistressSignal(device.getDeviceId());
            }

            try {
                Thread.sleep(2000);  // 2-second update interval
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
