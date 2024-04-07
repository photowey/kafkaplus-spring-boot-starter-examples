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
package io.github.photowey.kafkaplus.spring.boot.starter.example.property;

import io.github.photowey.kafka.plus.autoconfigure.core.property.KafkaPlusProperties;
import io.github.photowey.kafkaplus.spring.boot.starter.example.LocalTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * {@code KafkaPlusPropertyTest}
 *
 * @author photowey
 * @date 2024/04/07
 * @since 1.0.0
 */
@SpringBootTest
class KafkaPlusPropertyTest extends LocalTest {

    @Autowired(required = false)
    private KafkaPlusProperties kafkaPlusProperties;

    @Test
    void testKafkaPlusProperties() {
        Assertions.assertNotNull(this.kafkaPlusProperties);
    }
}