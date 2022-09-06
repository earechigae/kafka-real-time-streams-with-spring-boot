echo "kafka-console-producer --broker-list localhost:9092 --topic user-clicks-topic --property parse.key=true --property key.separator=":""
kafka-console-producer --broker-list localhost:9092 --topic user-clicks-topic --property parse.key=true --property key.separator=":"
