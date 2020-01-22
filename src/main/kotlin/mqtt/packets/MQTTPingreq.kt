package mqtt.packets

import mqtt.MQTTControlPacketType
import mqtt.MQTTException
import mqtt.encodeVariableByteInteger
import java.io.ByteArrayOutputStream

class MQTTPingreq : MQTTPacket {

    override fun toByteArray(): ByteArray {
        val result = ByteArrayOutputStream()
        val fixedHeader = (MQTTControlPacketType.PINGREQ.value shl 4) and 0xF0
        result.write(fixedHeader)
        result.encodeVariableByteInteger(0u)
        return result.toByteArray()
    }

    companion object : MQTTDeserializer {

        override fun fromByteArray(flags: Int, data: ByteArray): MQTTPingreq {
            checkFlags(flags)
            if (data.isNotEmpty())
                throw MQTTException(ReasonCode.MALFORMED_PACKET)
            return MQTTPingreq()
        }
    }
}
