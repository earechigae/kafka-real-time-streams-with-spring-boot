echo "kafka-console-producer --broker-list localhost:9092 --topic simple-invoice-topic --property parse.key=true --property key.separator=":""
kafka-console-producer --broker-list localhost:9092 --topic simple-invoice-topic --property parse.key=true --property key.separator=":"
