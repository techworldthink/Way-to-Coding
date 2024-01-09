#include <LoRaWan.h>

unsigned char data[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0xA,};
char buffer[256];

void setup(void) {
  SerialUSB.begin(115200);
  while (!SerialUSB);

  lora.init();

  memset(buffer, 0, 256);
  lora.getVersion(buffer, 256, 1);
  SerialUSB.print(buffer);

  memset(buffer, 0, 256);
  lora.getId(buffer, 256, 1);
  SerialUSB.print(buffer);

  //lora.setId(char *DevAddr, char *DevEUI, char *AppEUI);
  lora.setId("0x12345678", "xxxxxxxxxx", "xxxxxxxxxx");
  //void setKey(char *NwkSKey, char *AppSKey, char *AppKey);
  lora.setKey("xxxxxxxxxx", "xxxxxxxxxx", "xxxxxxxxxx");


  //lora.setDeciveMode(LWABP);
  lora.setDeciveMode(LWOTAA);
  lora.setDataRate(DR0, IN865);

  lora.setDutyCycle(false);
  lora.setJoinDutyCycle(false);

  lora.setPower(14);
  while (!lora.setOTAAJoin(JOIN));
}

void loop(void) {
  bool result = false;

  result = lora.transferPacket("Hello World!", 10);
  //result = lora.transferPacket(data, 10, 10);

  if (result) {
    short length;
    short rssi;

    memset(buffer, 0, 256);
    length = lora.receivePacket(buffer, 256, &rssi);

    if (length) {
      SerialUSB.print("Length is: ");
      SerialUSB.println(length);
      SerialUSB.print("RSSI is: ");
      SerialUSB.println(rssi);
      SerialUSB.print("Data is: ");
      for (unsigned char i = 0; i < length; i ++) {
        SerialUSB.print("0x");
        SerialUSB.print(buffer[i], HEX);
        SerialUSB.print(" ");
      }
      SerialUSB.println();
    }
  }
}
