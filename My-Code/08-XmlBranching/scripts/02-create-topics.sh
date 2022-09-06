
echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic xml-order-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic xml-order-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic error-topic"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic error-topic

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic india-orders"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic india-orders

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic abroad-orders"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic abroad-orders
