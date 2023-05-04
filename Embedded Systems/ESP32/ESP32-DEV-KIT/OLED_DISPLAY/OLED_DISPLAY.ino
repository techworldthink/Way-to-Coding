/*
 * SSD1306 OLED to ESP32
 * VCC - 3.3V
 * GND - GND
 * SDA - 21
 * SCL - 22
 */

#include <Wire.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>

// OLED display width, in pixels
#define SCREEN_WIDTH 128
// OLED display height, in pixels
#define SCREEN_HEIGHT 64


Adafruit_SSD1306 display(SCREEN_WIDTH, SCREEN_HEIGHT, &Wire, -1);

void setup() {
  Serial.begin(115200);

  // Address 0x3D
  if (!display.begin(SSD1306_SWITCHCAPVCC, 0x3C)) {
    Serial.println(F("SSD1306 allocation failed"));
    for (;;);
  }
  delay(2000);
  display.clearDisplay();

  // Get screen resolution
  int screenWidth = display.width();
  int screenHeight = display.height();
  Serial.println("Screen resolution:");
  Serial.print("Width: ");
  Serial.println(screenWidth);
  Serial.print("Height: ");
  Serial.println(screenHeight);

  display.setTextSize(1);
  display.setTextColor(WHITE);
  display.setCursor(0, 10);
  display.println("Hello, world!");
  display.display();
}

void loop() {

}
