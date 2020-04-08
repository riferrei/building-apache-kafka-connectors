package com.acme.kafka.connect.sample;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleSourceTaskTest {

    @Test
    public void taskVersionShouldMatch() {
        String version = PropertiesUtil.getConnectorVersion();
        assertEquals(version, new SampleSourceTask().version());
    }
    
}
