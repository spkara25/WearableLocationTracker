import device.WeareableDevice;
import service.MonitoringCentre;
import service.TrackerService;
import ui.MapVisualizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WeareableDevice device = new WeareableDevice("Device001");
        MonitoringCentre monitoringCenter = new MonitoringCentre();
        MapVisualizer mapVisualizer = new MapVisualizer();

        TrackerService trackerService = new TrackerService(device, monitoringCenter, mapVisualizer);

        mapVisualizer.openMap();
        trackerService.startTracking();

        System.out.println("Press Enter to stop tracking...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        trackerService.stopTracking();

        System.out.println("Tracking stopped.");
    }
}
