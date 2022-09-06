echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic payment_request"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic payment_request

echo "kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic payment_confirmation"
kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic payment_confirmation