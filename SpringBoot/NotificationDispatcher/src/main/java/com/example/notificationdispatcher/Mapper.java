package com.example.notificationdispatcher;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
@Service
public class Mapper {
    public String avroToJson(GenericRecord record) throws IOException {
        Schema schema = record.getSchema();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JsonEncoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, out, true);
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        writer.write(record, jsonEncoder);
        jsonEncoder.flush();
        return out.toString();
    }
}
