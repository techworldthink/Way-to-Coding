#include <stdio.h>
#include <freertos/FreeRTOS.h>
#include <freertos/task.h>

TaskHandle_t TaskHandler = NULL;

void sample_task_1(void *arg){
  while(1){
    Serial.println("sample_task_1");
    vTaskDelay(1000 / portTICK_RATE_MS);
  }
}

void setup() {
  Serial.begin(115200);
  xTaskCreate(sample_task_1, "sample_task_1", 4096, NULL, 10, &TaskHandler);
}

void loop() {

}
