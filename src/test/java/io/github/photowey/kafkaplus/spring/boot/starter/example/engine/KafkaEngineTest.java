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
package io.github.photowey.kafkaplus.spring.boot.starter.example.engine;

import io.github.photowey.kafkaplus.spring.boot.starter.example.LocalTest;
import io.github.photowey.kafka.plus.autoconfigure.engine.SpringKafkaEngineImpl;
import io.github.photowey.kafka.plus.engine.KafkaEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code KafkaEngineTest}
 *
 * @author photowey
 * @date 2024/04/07
 * @since 1.0.0
 */
@SpringBootTest
class KafkaEngineTest extends LocalTest {

    @Test
    void testKafkaEngine_spring_impl() {
        Assertions.assertNotNull(this.kafkaEngine);
        Assertions.assertEquals(SpringKafkaEngineImpl.class.getName(), this.kafkaEngine.getClass().getName());
    }

    @Test
    void testKafkaEngine_builtin_impl() {
        KafkaEngine kafkaEngine = this.kafkaEngine();

        Assertions.assertNotNull(kafkaEngine);
        Assertions.assertEquals(SpringKafkaEngineImpl.class.getName(), kafkaEngine.getClass().getName());
    }
}