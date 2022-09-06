echo "kafka-avro-console-producer --broker-list localhost:9092 --topic avro-employees-topic --property value.schema='{"namespace": "guru.learningjournal.examples.kafka.model","type": "record","name": "Employee","fields": [{"name": "id","type": "string"},{"name": "name","type": "string"},{"name": "department","type": "string"},{"name": "salary","type":"int"}]}'"
kafka-avro-console-producer --broker-list localhost:9092 --topic avro-employees-topic --property value.schema='{"namespace": "guru.learningjournal.examples.kafka.model","type": "record","name": "Employee","fields": [{"name": "id","type": "string"},{"name": "name","type": "string"},{"name": "department","type": "string"},{"name": "salary","type":"int"}]}'

# --property parse.key=true --property key.separator=":" --property key.serializer=org.apache.kafka.common.serialization.StringSerializer
