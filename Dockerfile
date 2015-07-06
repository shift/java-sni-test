FROM java:oracle-java6

ADD HTTPSClient.java /
RUN javac /HTTPSClient.java

