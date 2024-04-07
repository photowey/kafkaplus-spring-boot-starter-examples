/*
 * Copyright © 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.photowey.kafkaplus.spring.boot.starter.example.runtime.service.admin;

import io.github.photowey.kafka.plus.engine.KafkaEngine;
import io.github.photowey.kafkaplus.spring.boot.starter.example.LocalTest;
import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.KafkaFuture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

/**
 * {@code AdminServiceTest}
 *
 * @author photowey
 * @date 2024/04/07
 * @since 1.0.0
 */
@SpringBootTest
class AdminServiceTest extends LocalTest {

    @Test
    void testAdmin() {
        KafkaEngine kafkaEngine = super.kafkaEngine;

        try (Admin admin = kafkaEngine.adminService().createAdmin()
                .boostrapServers(this.defaultBoostrapServers())
                .checkConfigs(super::testBoostrapServers)
                .build()) {

            Assertions.assertNotNull(admin);
        }
    }

    @Test
    void testCreateTopic() throws Exception {
        KafkaEngine kafkaEngine = super.kafkaEngine;

        try (Admin admin = kafkaEngine.adminService().createAdmin()
                .boostrapServers(this.defaultBoostrapServers())
                .checkConfigs(super::testBoostrapServers)
                .build()) {

            NewTopic topic = kafkaEngine.adminService().createTopic()
                    .topic(this.defaultTopic())
                    .numPartitions(1)
                    .replicationFactor(1)
                    .build();

            CreateTopicsResult topicsResult = admin.createTopics(Collections.singleton(topic));
            KafkaFuture<Void> f1 = topicsResult.all();
            f1.get();

            Assertions.assertTrue(f1.isDone());
        }
    }
}