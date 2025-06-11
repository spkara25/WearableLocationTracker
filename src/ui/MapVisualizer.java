package ui;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MapVisualizer {
    private static final String HTML_TEMPLATE = """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="utf-8"/>
              <title>Wearable Tracker Map</title>
              <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css"/>
              <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
              <style>html, body, #map { height: 100%; margin: 0; }</style>
            </head>
            <body>
              <div id="map"></div>
              <script>
                var map = L.map('map').setView([15.0, 80.0], 6);
                L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                  attribution: '© OpenStreetMap contributors'
                }).addTo(map);
                var marker = L.marker([15.0, 80.0]).addTo(map).bindPopup("Device");
                function updateLocation(lat, lon) {
                  marker.setLatLng([lat, lon]);
                  map.panTo([lat, lon]);
                }
              </script>
            </body>
            </html>
            """;

    private File htmlFile;

    public MapVisualizer() {
        try {
            htmlFile = File.createTempFile("map_", ".html");
            try (FileWriter writer = new FileWriter(htmlFile)) {
                writer.write(HTML_TEMPLATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openMap() {
        try {
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateLocation(double lat, double lon) {
        // We can't dynamically update HTML from Java without a running server.
        // Instead, we recreate the HTML file with new coordinates each time.
        String updatedHtml = HTML_TEMPLATE.replace(
                "marker = L.marker([15.0, 80.0])",
                String.format("marker = L.marker([%.5f, %.5f])", lat, lon)
        ).replace(
                "map.setView([15.0, 80.0], 6)",
                String.format("map.setView([%.5f, %.5f], 10)", lat, lon)
        );
        try (FileWriter writer = new FileWriter(htmlFile)) {
            writer.write(updatedHtml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
