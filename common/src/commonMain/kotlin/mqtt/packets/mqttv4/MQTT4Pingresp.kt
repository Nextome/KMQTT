package mqtt.packets.mqttv4

import mqtt.packets.MQTTControlPacketType
import mqtt.packets.MQTTDeserializer
import mqtt.packets.mqtt.MQTTPingresp
import socket.streams.ByteArrayOutputStream

class MQTT4Pingresp : mqtt.packets.mqtt.MQTTPingresp(), MQTT4Packet {

    override fun toByteArray(): UByteArray {
        return ByteArrayOutputStream().wrapWithFixedHeader(MQTTControlPacketType.PINGRESP, 0)
    }

    companion object : MQTTDeserializer {

        override fun fromByteArray(flags: Int, data: UByteArray): MQTT4Pingresp {
            checkFlags(flags)
            return MQTT4Pingresp()
        }
    }
}