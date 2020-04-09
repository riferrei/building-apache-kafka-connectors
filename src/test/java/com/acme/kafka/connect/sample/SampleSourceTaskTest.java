package com.acme.kafka.connect.sample;

import org.apache.kafka.connect.source.SourceRecord;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static com.acme.kafka.connect.sample.SampleSourceConnectorConfig.*;

public class SampleSourceTaskTest {

    @Test
    public void taskVersionShouldMatch() {
        String version = PropertiesUtil.getConnectorVersion();
        assertEquals(version, new SampleSourceTask().version());
    }

    @Test
    public void checkNumberOfRecords() {
        Map<String, String> connectorProps = new HashMap<>();
        connectorProps.put(FIRST_REQUIRED_PARAM_CONFIG, "Kafka");
        connectorProps.put(SECOND_REQUIRED_PARAM_CONFIG, "Connect");
        Map<String, String> taskProps = getTaskProps(connectorProps);
        SampleSourceTask task = new SampleSourceTask();
        assertDoesNotThrow(() -> {
            task.start(taskProps);
            List<SourceRecord> records = task.poll();
            assertEquals(3, records.size());
        });
    }

    private Map<String, String> getTaskProps(Map<String, String> connectorProps) {
        SampleSourceConnector connector = new SampleSourceConnector();
        connector.start(connectorProps);
        List<Map<String, String>> taskConfigs = connector.taskConfigs(1);
        return taskConfigs.get(0);
    }
    
}
