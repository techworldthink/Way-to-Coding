import paho.mqtt.client as mqtt 

broker_address="127.0.0.1" 
#broker_address="iot.eclipse.org"

print("creating new instance")
client = mqtt.Client("P1") 
print("connecting to broker")
client.connect(broker_address, port=1883, keepalive=60, bind_address="")


print("Subscribing to topic","house/bulbs/bulb1")
client.subscribe("house/bulbs/bulb1")

print("Publishing message to topic","house/bulbs/bulb1")
client.publish("house/bulbs/bulb1","OFF")
