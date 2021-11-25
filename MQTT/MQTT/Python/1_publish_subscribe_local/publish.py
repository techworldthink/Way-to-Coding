import paho.mqtt.client as mqtt

broker_address="127.0.0.1" 
#broker_address="iot.eclipse.org" s

client = mqtt.Client("P1") 
client.connect(broker_address, port=1883, keepalive=60, bind_address="")

client.publish("house/main-light","OFF")

     
