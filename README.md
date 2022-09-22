# reentrant-vs-synchronized

JMH Benchmark to compare `synchronized` and `ReentrantLock`

#### Build
```sh
mvn clean package
```

#### 1 Thread, 2 forks
```sh
java -jar target/bench-jmh.jar -f 2 -t 1
```

#### 10 Threads, 2 forks
```sh
java -jar target/bench-jmh.jar -f 2 -t 10
```

#### Help, command line args
```sh
java -jar target/bench-jmh.jar -h
```
